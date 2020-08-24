package excelUtility;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataHelper {
	   public static List<HashMap<String,String>> data(String filepath,String sheetName)
	   {
	      List<HashMap<String,String>> mydata = new ArrayList<HashMap<String, String>>();
	      try
	      {
	         FileInputStream fs = new FileInputStream(filepath);
	         XSSFWorkbook workbook = new XSSFWorkbook(fs);
	         XSSFSheet sheet = workbook.getSheet(sheetName);
	         
	         Row HeaderRow = sheet.getRow(0);
	         
	         FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
	         //DataFormatter formatter = new DataFormatter();
	         for(int i=1;i<sheet.getPhysicalNumberOfRows();i++)
	         {
	            Row currentRow = sheet.getRow(i);
	            HashMap<String,String> currentHash = new HashMap<String,String>();
	            System.out.println("Column Count:"+currentRow.getPhysicalNumberOfCells());
	            for(int j=0;j<currentRow.getPhysicalNumberOfCells();j++)
	            {
	                Cell currentCell = currentRow.getCell(j);
	            	 switch (formulaEvaluator.evaluateInCell(currentCell).getCellTypeEnum())
		               {
		               case STRING:
		                  System.out.print(currentCell.getStringCellValue() + "\t");
		                  currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
		                  break;
		                  
		               case NUMERIC:
		            	   System.out.print(currentCell.getStringCellValue() + "\t");
		            	   currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
		                   break;
		               }
	              
//	               currentHash.put(formatter.formatCellValue(HeaderRow.getCell(j)), formatter.formatCellValue(currentCell));
	            }
	            mydata.add(currentHash);
	         }
	         fs.close();
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return mydata;
	   }
	}

