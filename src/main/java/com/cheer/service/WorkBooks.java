package com.cheer.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.sql.Types.BOOLEAN;
import static java.sql.Types.NUMERIC;
import static netscape.security.Privilege.BLANK;
import static org.apache.poi.ss.usermodel.Cell.*;
import static org.apache.poi.ss.usermodel.DataValidationConstraint.ValidationType.FORMULA;
import static org.apache.xmlbeans.impl.piccolo.xml.Piccolo.STRING;

public class WorkBooks {

    public static void main(String[] args) {
        Map<Integer, List<String>> map = new WorkBooks().readBook();
        List<String> list = map.get(1);
        for (String s : list) {
            System.out.println(s);

        }

    }


    public Map<Integer, List<String>> readBook(){
        FileInputStream file = null;
        try {
            file = new FileInputStream(new File("d:/题目.xlsx"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Workbook workbook = null;
        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
// 打开Excel中的第一个Sheet
        Sheet sheet = workbook.getSheetAt(0);

// 读取Sheet中的数据
        Map<Integer, List<String>> data = new HashMap<>();
        List<String> list=new ArrayList<>();
        int i = 0;
        for (Row row : sheet) { // 行
            data.put(i, list);
            for (Cell cell : row) { // 单元格
                switch (cell.getCellType()) { // 不同的数据类型
                    case CELL_TYPE_STRING:
                        data.get(i).add(cell.getRichStringCellValue().getString());
                        break; // 字符串类型

                    case CELL_TYPE_BOOLEAN:
                        data.get(i).add(String.valueOf(cell.getBooleanCellValue()));
                        break; // 布尔类型
                    case CELL_TYPE_FORMULA:
                        data.get(i).add(cell.getCellFormula());
                        break; // 公式类型
                    case CELL_TYPE_BLANK:
                        data.get(i).add("");
                        break; // 空白类型
                }
            }
            i++;
        }

        return data;

    }
}
