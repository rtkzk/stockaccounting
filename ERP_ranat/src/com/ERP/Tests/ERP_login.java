package com.ERP.Tests;

import java.io.IOException;

import com.stockaccounting.masterscripts.Stockaccounting_lib;

public class ERP_login {

	
	public static void main(String[] args) throws IOException {
		Stockaccounting_lib sl=new Stockaccounting_lib();
		String res=sl.openApp("http://webapp.qedgetech.com");
		System.out.println(res);
		sl.AdminLgn("admin","master");


	}

}
