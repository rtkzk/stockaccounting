package com.stockaccounting.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.stockaccounting.masterscripts.TestNGBase;

public class SAtcs extends TestNGBase {
@Test(dataProvider="Udata")
public void UOM(String uid,String udesc)
	{
			sl.UOM1(uid,udesc);
		}
	@Test
	public void sc()
	{
		sl.StockItemCategory("mobileACC11");
	}
	@DataProvider
	public Object[][] udata()
	{
	Object[][] obj=new Object[3][2];
	obj[0][0]="1001gb";
	obj[0][1]="testing1";
	
	obj[1][0]="1002gb";
	obj[1][1]="testing2";
	
	obj[2][0]="1003gb";
	obj[2][1]="testing3";
	return obj;
	}
}


