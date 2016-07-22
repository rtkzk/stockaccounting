package com.stockaccounting.masterscripts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class notepaduom {

	
	public static void main(String[] args) throws IOException {
		String res;
        Stockaccounting_lib s=new Stockaccounting_lib();
		
		res = s.openApp("http://webapp.qedgetech.com");
		System.out.println(res);
		res=s.AdminLgn("admin","master");
		System.out.println(res);
		//UOM
		/*String fpath="D:\\RTKSeleniumProject\\ERP_ranat\\src\\com\\stockaccounting\\testdata\\UOM@.txt";
		String rpath="D:\\RTKSeleniumProject\\ERP_ranat\\src\\com\\stockaccounting\\results\\UOM@.txt";*/
		//category
		String fpathC="D:\\RTKSeleniumProject\\ERP_ranat\\src\\com\\stockaccounting\\testdata\\category.txt";
		String rpathC="D:\\RTKSeleniumProject\\ERP_ranat\\src\\com\\stockaccounting\\results\\category.txt";
		String sd;
		FileReader fr=new FileReader(fpathC);
		BufferedReader br=new BufferedReader(fr);
		String sread=br.readLine();
		System.out.println(sread);
		FileWriter fw=new FileWriter(rpathC);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(sread+"$$$$"+"Result");
		bw.newLine();
		while((sd=br.readLine())!=null)
		{
			System.out.println(sd);
			
			//Category
						
			String cname=sd;
			res=s.StockItemCategory(cname);
			System.out.println(res);
			bw.write(cname+"@@@@"+res);
			bw.newLine();
		}
		while((sd=br.readLine())!=null)
		{
		//Supplier
			String[] sr=sd.split("####");
			String sname=sr[0];
			System.out.println(sname);
			String addr=sr[1];
			System.out.println(addr);
			String city=sr[2];
			System.out.println(city);
			String country=sr[3];
			System.out.println(country);
			String cperson=sr[4];
			System.out.println(cperson);
			String pnumber=sr[5];
			System.out.println(pnumber);
			String mail=sr[6];
			System.out.println(mail);
			String mnumber=sr[7];
			System.out.println(mnumber);
			String note=sr[8];
			System.out.println(note);
			
			res=s.Supplier(sname,addr,city,country,cperson,pnumber,mail,mnumber,note);
			System.out.println(res);
			bw.write(sname+"@@@@@"+addr+"@@@@@"+city+"@@@@@"+country+"@@@@@"+cperson+"@@@@@"+pnumber+"@@@@@"+mail+"@@@@@"+mnumber+"@@@@@"+note+""+res);
			bw.newLine();
		}
				
		/*while((sd=br.readLine())!=null)
		{
			//UOM
			String[] sr=sd.split("####");
			String uid=sr[0];
			System.out.println(uid);
			String udes=sr[1];
			System.out.println(udes);
			res=s.UOM1(uid,udes);
			System.out.println(res);
			bw.write(uid+"@@@@"+udes+"@@@@"+res);
			bw.newLine();
			
		}*/
			bw.close();
			br.close();
		}
		
	 }

	


