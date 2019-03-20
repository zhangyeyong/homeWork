package com.zte.i18nhelper;

import java.io.File;
import java.io.FileInputStream;
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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.zte.i18nhelper.I18nUtil.LangMsg;

public class I18nForPDAMain {

    public static List<String> langs = Arrays.asList("en", "es");

    static class Msg {
        public String code;
        public String value;

        public Msg clone() {
            return new Msg(code, value);
        }

        public Msg(String code, String value) {
            this.code = code;
            this.value = value;
        }

        @Override
        public String toString() {
            return "    <string name=\"" + code + "\">" + value + "</string>";
        }
    }

    static boolean isI18nFolder(File folder) {
        if (!folder.isDirectory() || !folder.getName().equals("values")) {
            return false;
        }

        for (File f : folder.listFiles()) {
            if (f.getName().toLowerCase().startsWith("strings")) {
                return true;
            }
        }
        return false;
    }

    static void loadI18nFolder(File pFolder, List<File> i18nFolders) throws Exception {
        for (File f : pFolder.listFiles()) {
            if (isI18nFolder(f)) {
                i18nFolders.add(f);
            } else if (f.isDirectory()) {
                loadI18nFolder(f, i18nFolders);
            }
        }
    }

    static void loadI18nFolder(String path, List<File> i18nFolders) throws Exception {
        File pFolder = new File(path);
        for (File f : pFolder.listFiles()) {
            if (isI18nFolder(f)) {
                i18nFolders.add(f);
            } else if (f.isDirectory()) {
                loadI18nFolder(f, i18nFolders);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        List<LangMsg> excelMsgList = new ArrayList<LangMsg>();
        Map<String, LangMsg> msgMap = new HashMap<String, LangMsg>();
        File tmpFile = new File(I18nForPDAMain.class.getResource("/").getPath());
        String rootPath = tmpFile.getParentFile().getParentFile().getParentFile().getAbsolutePath();
        String searchingPath = rootPath + "/ext/wms";

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
        loadI18nFolder(searchingPath, i18nFolders);

        for (File i18nFolder : i18nFolders) {
            for (File f : i18nFolder.listFiles()) {
                if (f.isDirectory() || !f.getName().toLowerCase().startsWith("strings")) {
                    continue;
                }
                for (String lang : langs) {
                    genOneFile(f, lang, msgMap, excelMsgList);
                }
            }
        }

        I18nUtil.createI18nXls(new File(rootPath, "i18n_pda.xls"), msgMap);
    }

    static String nvl(String s) {
        return s == null ? "" : s;
    }

    private static void loadOneFile(File file, List<Msg> msgList) throws Exception {
        if (file.isDirectory() || !file.exists()) {
            return;
        }

        FileInputStream in = new FileInputStream(file);
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Element root = builder.parse(in).getDocumentElement();
            NodeList nodeList = root.getElementsByTagName("string");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element eMsg = (Element) nodeList.item(i);
                String code = nvl(eMsg.getAttribute("name")).trim().toLowerCase();
                String msg = eMsg.getTextContent();
                msgList.add(new Msg(code, msg));
            }
        } finally {
            in.close();
        }
    }

    static void genOneFile(File srcFile, String lang, Map<String, LangMsg> msgMap, List<LangMsg> excelMsgList)
            throws Exception {
        File dstFile = new File(new File(srcFile.getParentFile().getParent(), srcFile.getParentFile().getName() + "-"
                + lang), srcFile.getName());
        List<Msg> srcList = new ArrayList<Msg>();
        List<Msg> dstList = new ArrayList<Msg>();

        loadOneFile(srcFile, srcList);
        loadOneFile(dstFile, dstList);

        for (Msg src : srcList) {
            boolean found = false;
            String val = src.value;
            for (LangMsg lm : excelMsgList) {
                if (lm.code.equalsIgnoreCase(src.code)) {
                    val = lm.get(lang);
                    found = true;
                    break;
                }
            }

            if (!found) {
                for (Msg dst : dstList) {
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
        if (!dstFile.getParentFile().exists())
            dstFile.getParentFile().mkdirs();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(dstFile)));
        try {
            printXml(srcList, out);
        } finally {
            out.close();
        }
    }

    static void printXml(List<Msg> msgList, PrintWriter out) {
        try {

            out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
            out.println("<resources>");
            for (Msg msg : msgList) {
                out.println(msg);
            }
            out.println("</resources>");
        } finally {
            out.close();
        }
    }

}
