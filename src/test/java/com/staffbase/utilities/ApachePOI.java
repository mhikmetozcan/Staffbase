package com.staffbase.utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ApachePOI {

    public static String readFromExcel(int rowNum, int colNum){

        String value = "";

        try {
            FileInputStream excelFile = new FileInputStream("LinkedInCredentials.xlsx");

            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);

            XSSFSheet sheet = workbook.getSheet("Sheet1");

            XSSFRow row = sheet.getRow(rowNum);
            XSSFCell cell = row.getCell(colNum);

            value += cell;



        } catch (IOException e) {
            e.printStackTrace();
        }

        return value;
    }

}
