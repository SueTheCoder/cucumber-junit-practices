package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    XSSFRow row;


    @Test
    public void excel_writing_test() throws IOException {

        String path = "sampleData.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);

        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet("Employees");
        row = sheet.getRow(1);
        cell = row.getCell(1);
        
        XSSFCell adamsCell = sheet.getRow(2).getCell(0);
        System.out.println("adamsCell = " + adamsCell);

        // this method will write to cell
        adamsCell.setCellValue("Madam");
        System.out.println("adamsCell = " + adamsCell);

        adamsCell.setCellValue("Adam");
        
        //TODO: change steven's name to TOM

        XSSFCell stevenCell = sheet.getRow(1).getCell(0);
        for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Steven")){
                sheet.getRow(rowNum).getCell(0).setCellValue("Tom");
            }
        }
        System.out.println("AFTER stevenCell = " + stevenCell);


        //================== WRITE & CLOSE ========================
        // write all changes to file using FileOutputStream
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        fileOutputStream.close();
        fileInputStream.close();

    }

}
