package es.upm.h4g.atopa;


import java.io.*;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Read {
    public static void main(String[] args) {
        try {

            FileInputStream file = new FileInputStream(new File("testExcel.xls"));
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_BOOLEAN:
                            System.out.println("boolean===>>>" + cell.getBooleanCellValue() + "\t");
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.println("numeric===>>>" + cell.getNumericCellValue() + "\t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.println("String===>>>" + cell.getStringCellValue() + "\t");
                            break;
                    }
                }
                System.out.println("");
            }
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


