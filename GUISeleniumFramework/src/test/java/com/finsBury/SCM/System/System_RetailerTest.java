package com.finsBury.SCM.System;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.NewOrderPage;
import com.comcast.crm.objectrepositoryutility.OrdersPage;
import com.comcast.crm.objectrepositoryutility.RetailerPage;

//@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class System_RetailerTest extends BaseClass{

	@Test
	public void retailerTest() throws Throwable {
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp();
		
		Home hp= new Home(driver);
		hp.getHomeAddRetailers().click();
		
		RetailerPage rp = new RetailerPage(driver);
		rp.addDetailsOfRetailer();
		wLib.switchtoAlertAndAccept(driver);
		
		hp.logout();
		
		lp.loginToappRet();
		 
		NewOrderPage nop = new NewOrderPage(driver);
		nop.postNewOrder();
		
		OrdersPage op = new OrdersPage(driver);
		op.myOrders();
		
		//verification
		String quantity = eLib.getDataFromExcel("Sheet1", 7, 7);
	    String actquantity = op.getActQuantity().getText();
	    Assert.assertTrue(actquantity.equals(quantity));
	    UtilityClassObject.getTest().log(Status.INFO, "Quanity is verified");
		
	}
}
