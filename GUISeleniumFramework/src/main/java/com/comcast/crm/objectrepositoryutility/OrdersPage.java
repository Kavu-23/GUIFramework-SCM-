package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/*
 * @auother:Preethi
 *
 * contains OrdersPAge web elements
 */
public class OrdersPage {

WebDriver driver;

public OrdersPage(WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
}

@FindBy(linkText="My Orders")
private WebElement myOrderslnk;

@FindBy(id="cmbFilter")
private WebElement OrdersSearchBy;

@FindBy(id="cmbStatus")
private WebElement searchSelOpt;


@FindBy(xpath = "//input[@value='Search']")
private WebElement OrdersSearchbutton;

@FindBy(linkText ="Details")
private WebElement details;

@FindBy(xpath ="//*[@id='td_section']/section/form/table/tbody/tr[2]/td[3]")
private WebElement actQuantity;


public WebElement getActQuantity() {
	return actQuantity;
}

public WebElement getDetails() {
	return details;
}

public WebElement getSearchSelOpt() {
	return searchSelOpt;
}

public WebElement getMyOrderslnk() {
	return myOrderslnk;
}

public WebElement getOrdersSearchBy() {
return OrdersSearchBy;
}

public WebElement getOrdersSearchbutton() {
return OrdersSearchbutton;
}

//Business logic
public void myOrders() throws Throwable {
	
	myOrderslnk.click();
	ExcelUtility eLib = new ExcelUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	wLib.select(OrdersSearchBy, eLib.getDataFromExcel("Sheet1", 7, 8));
	wLib.select(searchSelOpt, eLib.getDataFromExcel("Sheet1", 7, 9));
	OrdersSearchbutton.click();
	details.click();
	
}

}
