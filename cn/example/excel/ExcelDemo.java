package cn.example.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * HSSFWorkbook:是操作Excel2003以前（包括2003）的版本，扩展名是.xls
 * XSSFWorkbook:是操作Excel2007的版本，扩展名是.xlsx
 * 对于不同版本的EXCEL文档要使用不同的工具类，如果使用错了，会提示如下错误信息。
 * 
 * HSSFWorkbook，后来发现超出65536条后系统就报错
 * SXSSFWorkbook,海量数据处理,导出15W、20W条数据都正常运行
 * 
 * @author yzx
 *
 */
public class ExcelDemo {
	public static void main(String[] args) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss");
			String name = sdf.format(new Date());
			System.out.println(name);
			
			int rows = 100;
			
			exportExcelHSSF(rows, name); // 65535 max
			generateExcel(rows, name);
			offAutoFlushing(rows, name);
			importExcel("D:/16-46-22-cfsxxs.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void importExcel(String fileName) throws IOException {
		long start = System.currentTimeMillis();
		FileInputStream fis = new FileInputStream(fileName);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		
		StringBuilder sb = null;
		for(Iterator<Row> rowit = sh.rowIterator(); rowit.hasNext(); ) {
			sb = new StringBuilder();
			for(Iterator<Cell> cellit = rowit.next().cellIterator(); cellit.hasNext(); ) {
				sb.append(cellit.next().getStringCellValue()).append("|");
			}
			System.out.println(sb.toString());
			sb = null;
		}
		
		wb.close();
		fis.close();
		System.out.println("use time importExcel " + (System.currentTimeMillis() - start));
	}
	
	public static void exportExcelHSSF(int rows, String fileName) throws IOException {
		long start = System.currentTimeMillis();
		HSSFWorkbook hb = new HSSFWorkbook();
		HSSFSheet sh = hb.createSheet();
		
		for(int i = 0; i < rows; i++) {
			HSSFRow row = sh.createRow(i);
			for(int j = 0; j < 11; j++) {
				HSSFCell cell = row.createCell(j, CellType.STRING);
				String addr = new CellReference(cell).formatAsString();
				cell.setCellValue(addr);
			}
		}
		
		FileOutputStream fos = new FileOutputStream("D:/" + fileName + "-hss.xls");
		hb.write(fos);
		
		fos.close();
		hb.close();
		System.out.println("use time exportExcelHSSF " + (System.currentTimeMillis() - start));
	}
	
	public static void generateExcel(int rows, String fileName) throws IOException {
		long start = System.currentTimeMillis();
		SXSSFWorkbook wb = new SXSSFWorkbook(100);
		Sheet sh = wb.createSheet();
		
		for(int row = 0; row < rows; row++) {
			Row nrow = sh.createRow(row);
			for(int cellnum = 0; cellnum < 10; cellnum++) {
				Cell cell = nrow.createCell(cellnum);
				String address = new CellReference(cell).formatAsString();
				cell.setCellValue(address);
			}
		}
		
/*		for(int rownum = 0; rownum < 900; rownum++) {
			Assert.assertNull(sh.getRow(rownum));
		}
		for(int rownum = 900; rownum < 1000; rownum++){
            Assert.assertNotNull(sh.getRow(rownum));
        }*/
		
		FileOutputStream fos = new FileOutputStream("D:/"+ fileName +"-fsxxs.xlsx",false);
		wb.write(fos);
		fos.close();
		
		wb.dispose();
		wb.close();
		System.out.println("use time generateExcel " + (System.currentTimeMillis() - start));
	}
	
	public static void offAutoFlushing(int rows, String fileName) throws IOException {
		long start = System.currentTimeMillis();
		SXSSFWorkbook wb = new SXSSFWorkbook(-1);
//		wb.setCompressTempFiles(true); // temp files will be gzipped
		
		
		Sheet sh = wb.createSheet();
		for(int rownum = 0; rownum < rows; rownum++) {
			Row row = sh.createRow(rownum);
			for(int cellnum = 0; cellnum < 10; cellnum++) {
				Cell cell = row.createCell(cellnum);
				String addr = new CellReference(cell).formatAsString();
				cell.setCellValue(addr);
			}
			
			// manually control how rows are flushed to disk
			if(rownum % 100 == 0) {
				((SXSSFSheet)sh).flushRows(100);
				 // ((SXSSFSheet)sh).flushRows() is a shortcut for ((SXSSFSheet)sh).flushRows(0),
                // this method flushes all rows
			}
		}
		
		FileOutputStream fos = new FileOutputStream("D:/"+ fileName +"-cfsxxs.xlsx", false);
		wb.write(fos);
		fos.close();
		wb.dispose();
		wb.close();
		System.out.println("use time offAutoFlushing " + (System.currentTimeMillis() - start));
	}
}
