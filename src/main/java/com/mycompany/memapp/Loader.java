package com.mycompany.memapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Loader {
    
    /**
     * System Loader
     */
    
    public static void main(String[] args) throws Exception{
        System.out.println("[INFO] Software is now loading...\n[VERSION] 1.0.0");
        credentials = new HashMap<>();
        
        Loader load = new Loader();
        load.dataImport();
        
        System.out.println("[INFO] Log-in Frame opens");
        SignIn launch = new SignIn();
        launch.setVisible(true);
    }
    
    /**
     * Global Variables for saving important data needed later
     */
    protected static HashMap<String, String> credentials;
    protected static String LoggedUser;
    
    /**
     * Data Handlers
     */
    
    protected void dataImport() throws Exception {
        System.out.println("[INFO] Importing Data");
        
        FileInputStream file = new FileInputStream(new File(System.getProperty("user.home")+"\\AppData\\Roaming\\MemApp\\data.xlsx"));
        
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);
        FormulaEvaluator forEval = wb.getCreationHelper().createFormulaEvaluator();
        
        int cellNo;
        String keyHis;
        
        for(Row row:sheet) {
            cellNo=0;
            keyHis="";
            for(Cell cell:row) {
                switch(forEval.evaluateInCell(cell).getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                        if(cellNo==0) {
                            credentials.put(String.valueOf((int)cell.getNumericCellValue()), null);
                            keyHis=String.valueOf((int)cell.getNumericCellValue());
                        }
                        else if(cellNo==1) credentials.replace(keyHis, null, String.valueOf(cell.getNumericCellValue()));
                        break;
                    case Cell.CELL_TYPE_STRING:
                        if(cellNo==0) {
                            credentials.put(cell.getStringCellValue(), null);
                            keyHis = cell.getStringCellValue();
                        }
                        else if(cellNo==1) credentials.replace(keyHis, null, cell.getStringCellValue());
                        break;
                }
                cellNo++;
            }
        }
        System.out.println("[INFO] Successfully imported data!");
        file.close();
    }
    
    protected void dataExport() throws Exception {
      XSSFWorkbook workbook = new XSSFWorkbook();
      XSSFSheet spreadsheet = workbook.createSheet("Credentials");
      XSSFRow row;
      
      Set < String > keyid = credentials.keySet();
      int rowid = 0;
      for (String key : keyid) {
         row = spreadsheet.createRow(rowid++);
         int cellid = 0;
         Cell cell = row.createCell(cellid++);
         cell.setCellValue(key);
         cell = row.createCell(cellid++);
         cell.setCellValue(credentials.get(key));
      }
      
      FileOutputStream file = new FileOutputStream(new File(System.getProperty("user.home")+"\\AppData\\Roaming\\MemApp\\data.xlsx"));
      
      workbook.write(file);
      file.close();
      System.out.println("Data has been exported! Data.xlsx written successfully");
    }
}
