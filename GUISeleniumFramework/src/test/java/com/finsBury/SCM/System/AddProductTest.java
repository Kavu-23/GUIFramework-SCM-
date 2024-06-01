package com.finsBury.SCM.System;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.AddProductPage;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.LoginPage;

//@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class AddProductTest extends BaseClass{

	@Test
	public void addProductTest() throws Throwable
	
	{
    LoginPage lp= new LoginPage(driver);
	lp.loginToappManu();

	Home hp= new Home(driver);
	hp.getHomeAddProducts().click();
	
	AddProductPage adp= new AddProductPage(driver);
	String ProductName =eLib.getDataFromExcel("Sheet1", 16, 1)+jLib.getRandomNumber();
	adp.getProductEdt().sendKeys(ProductName);
	String Price =eLib.getDataFromExcel("Sheet1", 16, 2);
	adp.getPriceEdt().sendKeys(Price);
	wLib.select(adp.getUnitDD(), eLib.getDataFromExcel("Sheet1", 16, 3));
	wLib.select(adp.getCategDD(), eLib.getDataFromExcel("Sheet1", 16, 4));
	adp.getEnableRbtn().click();
	String Description =eLib.getDataFromExcel("Sheet1", 16, 5);
	adp.getDescriptn().sendKeys(Description);
	adp.getAddpbtn().click();
	
    //verification
	wLib.switchtoAlertAndAccept(driver);
    hp.getHomeProducts().click();
    
	String actProductname = driver.findElement(By.xpath("//td[text()='"+" "+ProductName+" "+"']")).getText();
	Assert.assertTrue(actProductname.contains(ProductName));
	UtilityClassObject.getTest().log(Status.INFO, "Pass: verified Product name ");

	}
}
