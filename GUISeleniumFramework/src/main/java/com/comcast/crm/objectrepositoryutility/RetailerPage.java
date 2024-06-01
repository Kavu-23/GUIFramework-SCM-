package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
/*
 * @auother:Preethi
 *
 * contains RetailerPage web elemnets
 */
public class RetailerPage {

WebDriver driver;

public RetailerPage(WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
}

@FindBy(id = "retailer:username")
private WebElement retailername;

public WebElement getretailername() {
return retailername;
}
@FindBy(id = "retailer:password")
private WebElement retailerpwd;

public WebElement getretailerpwd() {
return retailerpwd;
}
@FindBy(id = "retailer:phone")
private WebElement retailerphone;

public WebElement getretailerphone() {
return retailerphone;
}
@FindBy(id = "retailer:email")
private WebElement retaileremail;

public WebElement getretaileremail() {
return retaileremail;
}
@FindBy(id = "retailer:address")
private WebElement retaileraddress;

public WebElement getretaileraddress() {
return retaileraddress;

}

@FindBy(id = "retailer:areaCode")
private WebElement retailerareaCodeDD;

public WebElement getretailerareaCodeDD() {
return retailerareaCodeDD;

}
@FindBy(xpath= "//input[@value='Add Retailer']")
private WebElement retaileraddbutton;

public WebElement getretaileraddbutton()
{
return retaileraddbutton;
}

//Business logic
public void addDetailsOfRetailer() throws Throwable {
	ExcelUtility eLib = new ExcelUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	retailername.sendKeys(eLib.getDataFromExcel("Sheet1", 7, 1));
	retailerpwd.sendKeys(eLib.getDataFromExcel("Sheet1", 7, 2));
	wLib.select(retailerareaCodeDD, eLib.getDataFromExcel("Sheet1", 7, 3));
	retailerphone.sendKeys(eLib.getDataFromExcel("Sheet1", 7, 4));
	retaileremail.sendKeys(eLib.getDataFromExcel("Sheet1", 7, 5));
	retaileraddress.sendKeys(eLib.getDataFromExcel("Sheet1", 7, 6));
	retaileraddbutton.click();
}

}
