package com.finsBury.SCM.System;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.AddProductPage;
import com.comcast.crm.objectrepositoryutility.EditManufacturerPage;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.ManageCategoryPage;
import com.comcast.crm.objectrepositoryutility.Manageunitpage;
import com.comcast.crm.objectrepositoryutility.ManufacturerPage;
import com.comcast.crm.objectrepositoryutility.NewOrderPage;
import com.comcast.crm.objectrepositoryutility.OrdersPage;
import com.comcast.crm.objectrepositoryutility.RetailerPage;

//@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class supplySyncAllTest extends BaseClass{

	@Test(groups="smokeTest")
	public void manufacturerTest() throws Throwable {

		LoginPage lp = new LoginPage(driver);
		lp.loginToapp();
		UtilityClassObject.getTest().log(Status.INFO, "Login as admin");

		Home hp = new Home(driver);
		hp.getHomeAddManufacturer().click();
		UtilityClassObject.getTest().log(Status.INFO, "clicked on add Manufacturer");

		ManufacturerPage mp = new ManufacturerPage(driver);
		mp.addDetailsOfManufacturer();
		wLib.switchtoAlertAndAccept(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Add all the details of Manufacturer");

		hp.logout();
		// verified
		lp.loginToappManu();

		String USERNAME = fLib.getDataFromPropertiesFile("usermanuf");
		String txt = driver.findElement(By.xpath("//section[contains(text(), 'Welcome " + USERNAME + "')]")).getText();
		Assert.assertTrue(txt.contains("Welcome " + USERNAME + ""));
		UtilityClassObject.getTest().log(Status.INFO, "kavya is verified");

		EditManufacturerPage emp = new EditManufacturerPage(driver);
		emp.editManufacturerPassword();
		wLib.switchtoAlertAndAccept(driver);
	}

	@Test(groups="smokeTest")
	public void retailerTest() throws Throwable {

		LoginPage lp = new LoginPage(driver);
		lp.loginToapp();

		Home hp = new Home(driver);
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

		// verification
		String quantity = eLib.getDataFromExcel("Sheet1", 7, 7);
		String actquantity = op.getActQuantity().getText();
		Assert.assertTrue(actquantity.equals(quantity));
		UtilityClassObject.getTest().log(Status.INFO, "Quanity is verified");

	}

	@Test(groups="regressionTest")
	public void addCategoryAndEditCategoryTest() throws Throwable

	{

		LoginPage lp = new LoginPage(driver);
		lp.loginToapp();

		Home ho = new Home(driver);
		ho.getHomeManageCategory().click();

		ManageCategoryPage map = new ManageCategoryPage(driver);
		map.getAddcategorybutton().click();
		String catName = eLib.getDataFromExcel("Sheet1", 13, 1) + jLib.getRandomNumber();
		map.getcategoryname().sendKeys(catName);
		map.addCategory();
		wLib.switchtoAlertAndAccept(driver);

		// verify
		Thread.sleep(2000);
		ho.getHomeManageCategory().click();
		String actCatgry = map.getViewCategory().getText();
		Assert.assertEquals(actCatgry, catName);
		UtilityClassObject.getTest().log(Status.INFO, "expectedCatgry is verified with actCatgry");

		// Edit
		driver.findElement(By.xpath("//td[text()='" + " " + catName + " " + "']/..//img")).click();
		Thread.sleep(2000);
		map.getCategorydetails().clear();
		String catgryDetails = eLib.getDataFromExcel("Sheet1", 13, 3) + jLib.getRandomNumber();
		map.getCategorydetails().sendKeys(catgryDetails);
		map.getupdatecategorybtn().click();

		// Verification
		wLib.switchtoAlertAndAccept(driver);
		String actCatgrydetailsInfo = driver.findElement(By.xpath("//td[text()='" + " " + catgryDetails + " " + "']"))
				.getText();
		Assert.assertEquals(actCatgrydetailsInfo, catgryDetails);
		UtilityClassObject.getTest().log(Status.INFO, "verified actCatgryDetails treat");
	}

	@Test(groups="regressionTest")
	public void addAndDeleteUnit() throws Throwable {

		LoginPage lp = new LoginPage(driver);
		lp.loginToappManu();

		Home hp = new Home(driver);
		hp.getHomeManageUnit().click();

		Manageunitpage mup = new Manageunitpage(driver);
		mup.addUnit();
		wLib.switchtoAlertAndAccept(driver);

		// verification
		hp.getHomeManageUnit().click();
		String actUnit = mup.getViewUnit().getText();
		String expectedUnit = eLib.getDataFromExcel("Sheet1", 10, 1);
		System.out.println(actUnit);
		Assert.assertEquals(actUnit, expectedUnit);

		driver.findElement(By.xpath("//td[text()='" + " " + expectedUnit + " " + "']/preceding-sibling::*")).click();
		mup.getDeletbtn().click();

		// verification
		wLib.switchtoAlertAndAccept(driver);
		UtilityClassObject.getTest().log(Status.INFO, "Deleted unit successully");

	}

	@Test(groups="regressionTest")
	public void addProductTest() throws Throwable

	{
		LoginPage lp = new LoginPage(driver);
		lp.loginToappManu();

		Home hp = new Home(driver);
		hp.getHomeAddProducts().click();

		AddProductPage adp = new AddProductPage(driver);
		String ProductName = eLib.getDataFromExcel("Sheet1", 16, 1) + jLib.getRandomNumber();
		adp.getProductEdt().sendKeys(ProductName);
		String Price = eLib.getDataFromExcel("Sheet1", 16, 2);
		adp.getPriceEdt().sendKeys(Price);
		wLib.select(adp.getUnitDD(), eLib.getDataFromExcel("Sheet1", 16, 3));
		wLib.select(adp.getCategDD(), eLib.getDataFromExcel("Sheet1", 16, 4));
		adp.getEnableRbtn().click();
		String Description = eLib.getDataFromExcel("Sheet1", 16, 5);
		adp.getDescriptn().sendKeys(Description);
		adp.getAddpbtn().click();

		// verification
		wLib.switchtoAlertAndAccept(driver);
		hp.getHomeProducts().click();

		String actProductname = driver.findElement(By.xpath("//td[text()='" + " " + ProductName + " " + "']"))
				.getText();
		Assert.assertTrue(actProductname.contains(ProductName));
		UtilityClassObject.getTest().log(Status.INFO, "Pass: verified Product name ");

	}

}
