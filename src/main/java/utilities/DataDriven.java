package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataDriven {
	
	private static final String sheetname="Sheet1";
	public static String celltype(Cell cell) {
		if(cell==null) {
			return "";
		}
		switch(cell.getCellType()) {
		
		case STRING:
		return cell.getStringCellValue();
		
		case NUMERIC:
			return String.valueOf((int)cell.getNumericCellValue());
			
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		
		default:
			return "";
		}
	}
	
	@DataProvider(name = "logindata")
	public static Object[][] getsheetdata() throws IOException {
		try {
		String filepath=ConfigReader.getproperty("Testdatapath");
		FileInputStream file= new FileInputStream(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet= workbook.getSheet(sheetname);
		
		if(sheet==null) {
			workbook.close();
			throw new IllegalArgumentException("sheet not found" + sheet +"not found");
		}
		
		int rowcount=sheet.getPhysicalNumberOfRows();
		int columncount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data = new Object[rowcount-1][columncount];
		for(int i=1;i<rowcount;i++) {
			Row row= sheet.getRow(i);
			for(int j=0;j<columncount;j++) {
				data[i-1][j]=celltype(row.getCell(j));
			}
		}
			workbook.close();
			file.close();
		
		
		return data;
		}
		catch(Exception e) {
			throw new IllegalArgumentException("fiel not found");
		}
			
		}
	

}
