package com.zte.i18nhelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import com.zte.i18nhelper.I18nUtil.LangMsg;
import com.zte.i18nhelper.I18nUtil.XmlMsg;

public class I18nMain {

    public static List<String> langs = Arrays.asList("en", "es");

    static void loadI18nFolder(File pFolder, List<File> i18nFolders) throws Exception {
        for (File f : pFolder.listFiles()) {
            if (I18nUtil.isI18nFolder(f)) {
                i18nFolders.add(f);
            } else if (f.isDirectory()) {
                loadI18nFolder(f, i18nFolders);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        List<LangMsg> excelMsgList = new ArrayList<LangMsg>();
        Map<String, LangMsg> msgMap = new HashMap<String, LangMsg>();
        File tmpFile = new File(I18nMain.class.getResource("/").getPath());
        File searchingFolder = tmpFile.getParentFile().getParentFile().getParentFile();
        System.out.println(searchingFolder);

        JFileChooser fc = new JFileChooser();
        fc.setToolTipText("请选择翻译后的i18n Excel97 文件");
        fc.setFileFilter(new FileFilter() {

            @Override
            public String getDescription() {
                return "I18n Excel97(xls)";
            }

            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".xls");
            }
        });
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            excelMsgList.addAll(I18nUtil.readXls(fc.getSelectedFile()));
        }

        List<File> i18nFolders = new ArrayList<File>();
        loadI18nFolder(searchingFolder, i18nFolders);

        for (File i18nFolder : i18nFolders) {
            for (File f : i18nFolder.listFiles()) {
                if (f.isDirectory() || !f.getName().toLowerCase().endsWith(".i18n.xml")) {
                    continue;
                }

                for (String lang : langs) {
                    genOneFile(f, lang, msgMap, excelMsgList);
                }
            }
        }

        I18nUtil.createI18nXls(new File(searchingFolder, "i18n.xls"), msgMap);
    }

    static void genOneFile(File srcFile, String lang, Map<String, LangMsg> msgMap, List<LangMsg> excelMsgList)
            throws Exception {
        File dstFile = new File(new File(srcFile.getParentFile(), lang), srcFile.getName());
        List<XmlMsg> srcXmlList = new ArrayList<XmlMsg>();
        List<XmlMsg> dstXmlList = new ArrayList<XmlMsg>();

        I18nUtil.loadOneFile(srcFile, srcXmlList);
        I18nUtil.loadOneFile(dstFile, dstXmlList);

        for (XmlMsg src : srcXmlList) {
            boolean found = false;
            String val = src.value;
            for (LangMsg lm : excelMsgList) {
                if (lm.code.equalsIgnoreCase(src.code)) {
                    val = lm.get(lang);
                    found = true;
                    break;
                }
            }

            if (!found || I18nUtil.isBlank(val)) {
                for (XmlMsg dst : dstXmlList) {
                    if (src.code.equals(dst.code)) {
                        val = dst.value;
                        break;
                    }
                }
            }
            I18nUtil.putMsg(src.code, src.value, lang, val, msgMap);
            src.value = val;
        }

        System.out.println("\n");
        System.out.println(srcFile);
        dstFile.getParentFile().mkdirs();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(dstFile)));
        try {
            I18nUtil.printXml(srcXmlList, out);
        } finally {
            out.close();
        }
    }

}
