package com.thetestingacademy.utils;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class ExcelReader {

    @Test(dataProvider = "testData")
    public void readExcel(LinkedHashMap<String, Object> data) {
        System.out.println(data);
    }

    @DataProvider(name = "testData")
    public Object[][] getData() throws IOException {
        String sheetName = "Sheet1"; // Specify the sheet name directly
        List<LinkedHashMap<String, Object>> testData = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(new File("C:\\Users\\Thousif_Danki\\Documents\\Automation\\LearnAutomation\\ATB4xSeleniumAdvanceFramework\\src\\main\\java\\com\\thetestingacademy\\testData\\testDataExcel.xlsx"));
        Sheet sheet = workbook.getSheet(sheetName);
        DataFormatter formatter = new DataFormatter();
        int rowCount = sheet.getPhysicalNumberOfRows();
        int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
        for (int i = 1; i < rowCount; i++) {
            LinkedHashMap<String, Object> map = new LinkedHashMap<>();
            for (int j = 0; j < columnCount; j++) {
                String key = formatter.formatCellValue(sheet.getRow(0).getCell(j));
                String value = formatter.formatCellValue(sheet.getRow(i).getCell(j));
                map.put(key, value);
            }
            testData.add(map);
        }
        Object[][] objects = new Object[testData.size()][1];
        for (int i = 0; i < testData.size(); i++) {
            objects[i][0] = testData.get(i);
        }
        return objects;
    }
}