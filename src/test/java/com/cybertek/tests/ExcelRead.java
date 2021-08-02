package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {


    @Test
    public void read_from_excel_file() throws IOException {

        String path = "sampleData.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        // workbook -> sheet -> row -> cell

        // create a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        // get specific sheet from opened workbook
        XSSFSheet sheet = workbook.getSheet("Employees");

        // select row and cell
        // indexes start from 0
        System.out.println("sheet.getRow(1).getCell(0) = " + sheet.getRow(1).getCell(0));

        /*
        return the count of used cells only
        if some rows empty, they will not count
        it will not count empty rows or columns
        starts counting from 1
         */
        int usedRows = sheet.getPhysicalNumberOfRows();
        /*
        returns the number fromm the top cell to buttom cell
        it doesn't care if there are empty cells or not
        starts counting from 0
         */
        int lastUsedRow = sheet.getLastRowNum();

        //TODO: create a logic to print out Suheyla's name dynamically
        for(int rowNum = 0; rowNum < usedRows; rowNum++){
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Suheyla")){
                System.out.println("name = " + sheet.getRow(rowNum).getCell(0));
            }
        }

        //TODO: create a logic to print out Steven's JOB_ID dynamically

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Steven")){
                System.out.println("Steven's JOB_ID = " + sheet.getRow(rowNum).getCell(2));
            }

        }

        // or I can call this method that I created by myself
        printCellsFromExcel("sampleData.xlsx","Employees","Kimukin");


    }

    public static void printCellsFromExcel(String path,String sheetName, String name) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(path);
        // workbook -> sheet -> row -> cell
        // create a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        // get specific sheet from opened workbook
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int usedRows = sheet.getPhysicalNumberOfRows();
        for(int rowNum = 0; rowNum < usedRows; rowNum++){
                if(sheet.getRow(rowNum).getCell(rowNum).toString().equals(name)){
                    System.out.println("name = " + sheet.getRow(rowNum).getCell(0));
                }

        }
    }

}
