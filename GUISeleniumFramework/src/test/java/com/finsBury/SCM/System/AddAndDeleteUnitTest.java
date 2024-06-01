package com.finsBury.SCM.System;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.Manageunitpage;

//@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class AddAndDeleteUnitTest extends BaseClass {

	@Test
	public void addAndDeleteUnit() throws Throwable {
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToappManu();
		
		Home hp= new Home(driver);
		hp.getHomeManageUnit().click();
		 
		Manageunitpage mup=new Manageunitpage(driver);
		mup.addUnit();
		wLib.switchtoAlertAndAccept(driver);
		
		//verification
		hp.getHomeManageUnit().click();
		String actUnit= mup.getViewUnit().getText();
		String expectedUnit =eLib.getDataFromExcel("Sheet1", 10, 1);
		System.out.println(actUnit);
		Assert.assertEquals(actUnit, expectedUnit);
		
		driver.findElement(By.xpath("//td[text()='"+" "+expectedUnit+" "+"']/preceding-sibling::*")).click();
		mup.getDeletbtn().click();
		
		//verification
		//String popupMsg= driver.switchTo().alert().getText();
		wLib.switchtoAlertAndAccept(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Deleted unit: ");
		
		
	}
}
