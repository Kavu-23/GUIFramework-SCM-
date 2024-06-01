package com.finsBury.SCM.System;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.EditManufacturerPage;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.ManufacturerPage;

//@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class System_ManufacturerTest extends BaseClass{

	@Test
	public void manufacturerTest() throws Throwable {
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp();
		UtilityClassObject.getTest().log(Status.INFO, "Login as admin");
		
		Home hp= new Home(driver);
		hp.getHomeAddManufacturer().click();
		UtilityClassObject.getTest().log(Status.INFO, "clicked on add Manufacturer");
		
		ManufacturerPage mp = new ManufacturerPage(driver);
		mp.addDetailsOfManufacturer();
		wLib.switchtoAlertAndAccept(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Add all the details of Manufacturer"); 
		
		hp.logout();
		//verified
		lp.loginToappManu();

		String USERNAME = fLib.getDataFromPropertiesFile("usermanuf");
		String txt = driver.findElement(By.xpath("//section[contains(text(), 'Welcome "+USERNAME+"')]")).getText();
		Assert.assertTrue(txt.contains("Welcome "+USERNAME+""));
		UtilityClassObject.getTest().log(Status.INFO, "kavya is verified");
		
		EditManufacturerPage emp =new EditManufacturerPage(driver);
		emp.editManufacturerPassword();
		wLib.switchtoAlertAndAccept(driver);
		
		
		
	}
}
