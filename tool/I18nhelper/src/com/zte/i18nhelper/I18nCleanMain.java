package com.zte.i18nhelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import com.zte.i18nhelper.I18nUtil.XmlMsg;

public class I18nCleanMain {

    static Set<Character> codeChars = initCodeChars();
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

    private static Set<Character> initCodeChars() {
        Set<Character> ret = new HashSet<Character>();
        for (char c = '0'; c <= '9'; c++) {
            ret.add(c);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            ret.add(c);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            ret.add(c);
        }
        ret.add('_');
        ret.add('-');
        return ret;
    }

    static boolean ifUseI18n(String fileName) {
        fileName = fileName.toLowerCase();
        return fileName.endsWith(".tml") || fileName.endsWith(".java") || fileName.endsWith(".js");
    }

    static void loadUseI18nFiles(File pFolder, List<File> files) throws Exception {
        for (File file : pFolder.listFiles()) {
            if (file.isDirectory()) {
                loadUseI18nFiles(file, files);
            } else if (ifUseI18n(file.getName())) {
                files.add(file);
            }
        }
    }

    static void deleteUseless(File f, List<XmlMsg> xmlList) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "utf-8"));
        try {
            for (String line; (line = br.readLine()) != null;) {
                for (ListIterator<XmlMsg> liXmlMsg = xmlList.listIterator(); liXmlMsg.hasNext();) {
                    String code = liXmlMsg.next().code;
                    if (code.startsWith("lov_") || contains(code, line)) {
                        liXmlMsg.remove();
                    }
                }
            }
        } finally {
            br.close();
        }
    }

    public static int indexOfText(CharSequence s, CharSequence sub, int start) {
        if (s == null || sub == null || start < 0) {
            return -1;
        }
        int len = s.length();
        int subLen = sub.length();
        if (len < subLen || start + subLen > len) {
            return -1;
        }

        for (int i = start, count = len - subLen + 1; i < count; i++) {
            boolean isEq = true;
            for (int k = 0, t = i; k < subLen; k++, t++) {
                if (!eqChar(s.charAt(t), sub.charAt(k))) {
                    isEq = false;
                    break;
                }
            }

            if (isEq) {
                return i;
            }
        }
        return -1;
    }

    static boolean eqChar(char c1, char c2) {
        return c1 == c2 || Character.toLowerCase(c1) == Character.toLowerCase(c2);
    }

    static boolean contains(String word, String line) {
        int i = 0;
        do {
            i = indexOfText(line, word, i);
            if (i < 0) {
                break;
            }

            if (isSeperator(line, i - 1) && isSeperator(line, i + word.length())) {
                return true;
            } else {
                i += word.length();
            }

        } while (i < line.length());
        return false;
    }

    static boolean isSeperator(String s, int index) {
        if (index < 0 || index >= s.length()) {
            return true;
        }
        return !codeChars.contains(s.charAt(index));
    }

    /**
     * 判断文件是否为 可移除词条的i18n.xml文件
     * 
     * @param i18nFile
     * @return
     */
    static boolean isRemovableI18nXml(File i18nFile) {
        if (i18nFile.isDirectory() || !i18nFile.getName().toLowerCase().endsWith(".i18n.xml")) {
            return false;
        }

        String name = i18nFile.getName();
        String[] unmodifies = { "enumType.i18n.xml", "lov.i18n.xml", "barEnum.i18n.xml" };
        for (String u : unmodifies) {
            if (u.equalsIgnoreCase(name)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        File tmpFile = new File(I18nCleanMain.class.getResource("/").getPath());
        File searchingFolder = tmpFile.getParentFile().getParentFile().getParentFile();
        System.out.println(searchingFolder);

        List<File> i18nFolders = new ArrayList<File>();
        loadI18nFolder(searchingFolder, i18nFolders);

        List<File> useI18nFiles = new ArrayList<File>();
        loadUseI18nFiles(searchingFolder, useI18nFiles);

        List<XmlMsg> xmlList = new LinkedList<XmlMsg>();
        for (File i18nFolder : i18nFolders) {
            for (File i18nFile : i18nFolder.listFiles()) {
                if (isRemovableI18nXml(i18nFile)) {
                    I18nUtil.loadOneFile(i18nFile, xmlList);
                }
            }
        }

        long start = System.currentTimeMillis();
        System.out.println("正在努力计算无效的i18n，请耐心等待......");
        for (File i18nFile : useI18nFiles) {
            deleteUseless(i18nFile, xmlList);
        }

        Map<File, List<XmlMsg>> deletedMap = new HashMap<File, List<XmlMsg>>();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File(searchingFolder,
                "DeletedI18n.txt")), "utf-8"));
        try {
            int i = 1;
            for (XmlMsg m : xmlList) {
                List<XmlMsg> aList = deletedMap.get(m.from);
                if (aList == null) {
                    aList = new ArrayList<I18nUtil.XmlMsg>();
                    deletedMap.put(m.from, aList);
                }
                aList.add(m);
            }

            for (File file : deletedMap.keySet()) {
                List<XmlMsg> aList = deletedMap.get(file);
                out.println("\n文件" + file.getName() + "中无效i18n:");
                for (XmlMsg xm : aList) {
                    out.println(i++ + "/" + xmlList.size() + ": " + xm.code);
                }
            }
        } finally {
            out.close();
        }

        for (File file : deletedMap.keySet()) {
            deleteXmlI18n(file, deletedMap.get(file));
        }

        System.out.println("完成无效的i18n计算时间:" + (System.currentTimeMillis() - start) / 1000);
    }

    static void deleteXmlI18n(File xmlFile, List<XmlMsg> msgList) throws IOException {
        List<String> lines = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(xmlFile), "utf-8"));
        try {
            for (String line; (line = br.readLine()) != null;) {
                boolean deleted = false;
                for (XmlMsg xm : msgList) {
                    if (contains(xm.code, line)) {
                        deleted = true;
                        break;
                    }
                }

                if (!deleted) {
                    lines.add(line);
                }
            }
        } finally {
            br.close();
        }

        PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(xmlFile), "utf-8"));
        try {
            for (String l : lines) {
                out.println(l);
            }
        } finally {
            out.close();
        }

    }

}
