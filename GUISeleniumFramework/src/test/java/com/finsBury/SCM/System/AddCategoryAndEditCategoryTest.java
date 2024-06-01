package com.finsBury.SCM.System;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.ManageCategoryPage;

//@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class AddCategoryAndEditCategoryTest extends BaseClass{

	@Test
    public void addCategoryAndEditCategoryTest() throws Throwable

	{

		LoginPage lp = new LoginPage(driver);
        lp.loginToapp();

		Home ho = new Home(driver);
        ho.getHomeManageCategory().click();

		ManageCategoryPage map = new ManageCategoryPage(driver);
		map.getAddcategorybutton().click();
	    String catName = eLib.getDataFromExcel("Sheet1", 13, 1)+jLib.getRandomNumber();
	    map.getcategoryname().sendKeys(catName);
        map.addCategory();
        wLib.switchtoAlertAndAccept(driver);	
        
        //verify
        Thread.sleep(2000);
        ho.getHomeManageCategory().click();
        String actCatgry = map.getViewCategory().getText();
		Assert.assertEquals(actCatgry,catName);
		UtilityClassObject.getTest().log(Status.INFO, "expectedCatgry is verified with actCatgry");

	    
        //Edit 
		driver.findElement(By.xpath("//td[text()='"+" "+catName+" "+"']/..//img")).click();
		Thread.sleep(2000);
		map.getCategorydetails().clear();
		String catgryDetails = eLib.getDataFromExcel("Sheet1", 13, 3)+jLib.getRandomNumber();
		map.getCategorydetails().sendKeys(catgryDetails);
		map.getupdatecategorybtn().click();
	
        //Verification
	    wLib.switchtoAlertAndAccept(driver);
	    String actCatgrydetailsInfo = driver.findElement(By.xpath("//td[text()='"+" "+catgryDetails+" "+"']")).getText();
		Assert.assertEquals(actCatgrydetailsInfo, catgryDetails);
		UtilityClassObject.getTest().log(Status.INFO, "verified actCatgryDetails treat");
	}

}
