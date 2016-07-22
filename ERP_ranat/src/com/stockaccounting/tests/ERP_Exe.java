package com.stockaccounting.tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import com.stockaccounting.masterscripts.Stockaccounting_lib;

public class ERP_Exe {
	static String res;
	//private static Stockaccounting_lib s1;
	public static void main(String[] args) throws IOException 
	{
		
		
		Stockaccounting_lib s=new Stockaccounting_lib();
		
		res=s.openApp("http://webapp.qedgetech.com");
		System.out.println(res);
		res=s.AdminLgn("admin","master");
		System.out.println(res);
		
	FileInputStream fis=new FileInputStream("D:\\RTKSeleniumProject\\ERP_ranat\\src\\com\\stockaccounting\\testdata\\Inputdata.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet ws=wb.getSheet("Sheet1");
	
	int rc=ws.getLastRowNum();
	for (int i = 1; i <=rc; i++)
	{
		
		XSSFRow wr=ws.getRow(i);
		XSSFCell wc1=wr.getCell(0);
		XSSFCell wc2=wr.getCell(1);
		XSSFCell wc3=wr.createCell(2);
		
		String uid=wc1.getStringCellValue();
		String udec=wc2.getStringCellValue();
		String res=s.UOM1(uid, udec);
		wc3.setCellValue(res);
		
		
	}
	
	FileOutputStream fos=new FileOutputStream("D:\\RTKSeleniumProject\\ERP_ranat\\src\\com\\stockaccounting\\results\\UOMres.xlsx");

wb.write(fos);
wb.close();

	
		res=s.openApp("http://webapp.qedgetech.com");
		System.out.println(res);
		res=s.AdminLgn("admin","master");
		System.out.println(res);
		res=s.Supplier("rahul","hyderabad","hyderabad","india","rohit","9898989898","hello@gmail.com","9963714030","urgent");
		System.out.println(res);
		res=s.StockItemCategory("watches");
		System.out.println(res);
		res=s.UOM1("Mobile","quality good");
		System.out.println(res);
		res=s.st_items("Watches","Richards","Rolex watch","Quality 3","21587","28564","Branded watch");
		System.out.println(res);
		res=s.logout();
		System.out.println(res);
		
	    s.close();
	    
		
	}

}
