package GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRW {
	
	FileInputStream fi;
	XSSFWorkbook wb;
	
//	Initializing excel and workbook
	public ExcelRW(String fpath) throws Exception{
		
		 fi = new FileInputStream(fpath);
		 wb = new XSSFWorkbook(fi);
	}
	
//	Get the Row count
	
	public int getrowcount(String sheetname){
		
		XSSFSheet xs = wb.getSheet(sheetname);
		return xs.getLastRowNum();
	}		
	
//	get column count
	
	public int columncount(String sheetname){
		XSSFSheet xs = wb.getSheet(sheetname);
		return xs.getRow(0).getLastCellNum();
	}
	
//	Read the cell values
	
	public String readvalue(String sheetname, int ri,int ci){
		
		XSSFSheet xs = wb.getSheet(sheetname);
		XSSFCell cl = xs.getRow(ri).getCell(ci);
		String cellval = null;
		
		if(cl.getCellType()==cl.CELL_TYPE_STRING){
			
			cellval = cl.getStringCellValue();
		}else if (cl.getCellType()== cl.CELL_TYPE_NUMERIC){
			
			cellval = String.valueOf(cl.getNumericCellValue());
		}else if (cl.getCellType()==cl.CELL_TYPE_BLANK && cl.getCellType()==cl.CELL_TYPE_ERROR){
			
			cellval = "";
		}
		return cellval;
	}

	// Write the values to cell
	
	public void writevalue(String sheetname,int ri,int ci,String input){
		
		XSSFSheet xs = wb.getSheet(sheetname);
		xs.getRow(ri).getCell(ci).setCellValue(input);
	}
	
//	Save & close the excel
	
	public void saveclose(String fpath) throws Exception{
		
		FileOutputStream fo = new FileOutputStream(fpath);
		
//		Write to excel
		wb.write(fo);
		
//		close the streams
		
		fo.close();
		fi.close();
	}
	
}
