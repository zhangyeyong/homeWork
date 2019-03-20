package com.zte.i18nhelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class I18nUtil {

    public static class LangMsg {

        public String code;
        public String msg;
        public String en;
        public String es;

        @Override
        public String toString() {
            return code + "\t" + msg + "\t" + en + "\t" + es;
        }

        public String get(String lang) {
            if (lang.equals("en")) {
                return en;
            } else if (lang.equals("es")) {
                return es;
            } else {
                return msg;
            }

        }

    }

    public static class XmlMsg {
        public String code;
        public String value;
        public File from;

        public XmlMsg clone() {
            return new XmlMsg(code, value);
        }

        public XmlMsg(String code, String value) {
            this.code = code;
            this.value = value;
        }

        @Override
        public String toString() {
            if (value.contains("&")) {
                return "    <msg code=\"" + code + "\"><![CDATA[" + value + "]]></msg>";
            } else {
                return "    <msg code=\"" + code + "\">" + value + "</msg>";
            }
        }
    }

    public static void putMsg(String code, String msg, String lang, String langMsg, Map<String, LangMsg> genMsgMap) {
        code = code.toLowerCase();
        lang = lang.toLowerCase();
        LangMsg lm = genMsgMap.get(code);
        if (lm == null) {
            lm = new LangMsg();
            lm.code = code;
            genMsgMap.put(code, lm);
        }
        lm.msg = msg;
        if (lang.equals("es")) {
            lm.es = langMsg;
        } else if (lang.equals("en")) {
            lm.en = langMsg;
        }
    }

    public static void createI18nXls(File xls, Map<String, LangMsg> msgMap) {
        try {
            // 创建文件
            WritableWorkbook wwb = Workbook.createWorkbook(xls);
            try {
                WritableSheet sheet = wwb.createSheet("i18n", 0);
                WritableFont wfHead = new WritableFont(WritableFont.ARIAL, 13, WritableFont.BOLD);
                wfHead.setColour(Colour.RED);
                WritableCellFormat cfHeader = new WritableCellFormat(wfHead);
                cfHeader.setBackground(Colour.GRAY_25);
                sheet.addCell(new Label(0, 0, "Index", cfHeader));
                sheet.addCell(new Label(1, 0, "Code", cfHeader));
                sheet.setColumnView(1, 30);
                sheet.addCell(new Label(2, 0, "Chinese", cfHeader));
                sheet.setColumnView(2, 60);
                sheet.addCell(new Label(3, 0, "English", cfHeader));
                sheet.setColumnView(3, 60);
                sheet.addCell(new Label(4, 0, "Spanish", cfHeader));
                sheet.setColumnView(4, 60);

                List<LangMsg> list = new ArrayList<LangMsg>(msgMap.values());
                Collections.sort(list, new Comparator<LangMsg>() {

                    @Override
                    public int compare(LangMsg o1, LangMsg o2) {
                        return o1.msg.compareToIgnoreCase(o2.msg);
                    }
                });

                for (int i = 0; i < list.size(); i++) {
                    LangMsg msg = list.get(i);
                    int row = i + 1;
                    sheet.addCell(new Label(0, row, Integer.toString(row)));
                    sheet.addCell(new Label(1, row, msg.code));
                    sheet.addCell(new Label(2, row, msg.msg));
                    sheet.addCell(new Label(3, row, msg.en));
                    sheet.addCell(new Label(4, row, msg.es));
                }
                wwb.write();
            } finally {
                wwb.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isBlank(String s) {
        return s == null || s.trim().length() == 0;
    }

    private static String cellText(Cell[] cells, int i) {
        if (cells == null || i >= cells.length || i < 0) {
            return null;
        } else {
            return cells[i].getContents();
        }
    }

    public static List<LangMsg> readXls(File xlsFile) {
        List<LangMsg> ret = new ArrayList<LangMsg>();
        try {
            // Workbook wb = Workbook.getWorkbook(xlsFile);

            WorkbookSettings workbookSettings = new WorkbookSettings();
            workbookSettings.setEncoding("ISO-8859-1");
            Workbook wb = Workbook.getWorkbook(new FileInputStream(xlsFile), workbookSettings);

            try {
                Sheet sheet = wb.getSheet(0);
                for (int row = 0, rows = sheet.getRows(); row < rows; row++) {
                    Cell[] cells = sheet.getRow(row);
                    if (cells.length > 3) {
                        LangMsg msg = new LangMsg();
                        msg.code = cells[1].getContents().toLowerCase().trim();
                        msg.msg = cells[2].getContents();
                        msg.en = cellText(cells, 3);
                        msg.es = cellText(cells, 4);
                        if (!isBlank(msg.msg)) {
                            ret.add(msg);
                        }
                    }
                }
            } finally {
                wb.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ret;
    }

    public static void loadOneFile(File file, List<XmlMsg> msgList) throws Exception {
        if (file.isDirectory() || !file.exists()) {
            return;
        }

        FileInputStream in = new FileInputStream(file);
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Element root = builder.parse(in).getDocumentElement();
            NodeList nodeList = root.getElementsByTagName("msg");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element eMsg = (Element) nodeList.item(i);
                String code = nvl(eMsg.getAttribute("code")).trim().toLowerCase();
                String msg = eMsg.getTextContent();
                XmlMsg xmlMsg = new XmlMsg(code, msg);
                xmlMsg.from = file;
                msgList.add(xmlMsg);
            }
        } finally {
            in.close();
        }
    }

    public static String nvl(String s) {
        return s == null ? "" : s;
    }

    public static void printXml(List<XmlMsg> msgList, PrintWriter out) {
        try {
            out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            out.println("<i18n>");
            for (XmlMsg msg : msgList) {
                out.println(msg);
            }
            out.println("</i18n>");
        } finally {
            out.close();
        }
    }

    public static boolean isI18nFolder(File folder) {
        if (!folder.isDirectory() || !folder.getName().equals("i18n")) {
            return false;
        }

        for (File f : folder.listFiles()) {
            if (f.getName().toLowerCase().endsWith(".i18n.xml")) {
                return true;
            }
        }
        return false;
    }

}