package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class ManageCategoryPage {

WebDriver driver;

public ManageCategoryPage(WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//input[@value='Delete']")
private WebElement deletebutton;

public WebElement getdeletebutton() {
return deletebutton;
}
@FindBy(xpath = "//input[@value='+ Add Category']")
private WebElement Addcategorybutton;

public WebElement getAddcategorybutton() {
return Addcategorybutton;
}
//ADD Category

@FindBy(id = "categoryName")
private WebElement categoryname;

public WebElement getcategoryname() {
return categoryname;
}

@FindBy(xpath="//*[@class='table_mainWrapper']//section//tr[last()]//td[3]")
private WebElement viewCategory;

public WebElement getViewCategory() {
	return viewCategory;
}

@FindBy(xpath="//*[@class='table_mainWrapper']//section//tr[last()]//td[4]")
private WebElement viewCatgryDetails;


public WebDriver getDriver() {
	return driver;
}

public WebElement getDeletebutton() {
	return deletebutton;
}

public WebElement getCategoryname() {
	return categoryname;
}

public WebElement getViewCatgryDetails() {
	return viewCatgryDetails;
}

public WebElement getCategorydetails() {
	return categorydetails;
}

public WebElement getEditcategoryname() {
	return editcategoryname;
}


public WebElement getUpdatecategorybtn() {
	return updatecategorybtn;
}

@FindBy(id = "categoryDetails")
private WebElement categorydetails;

public WebElement getcategorydetails() {
return categorydetails;
}

@FindBy(xpath = "//input[@value='Add Category']")
private WebElement Addcategorybutton2;

public WebElement getAddcategorybutton2() {
return Addcategorybutton2;
}
// edit category


@FindBy(id = "categoryName")
private WebElement editcategoryname;

public WebElement geteditcategoryname() {
return editcategoryname;
}


@FindBy(xpath = "//input[@value='Update Category']")
private WebElement updatecategorybtn;

public WebElement getupdatecategorybtn() {
return updatecategorybtn;
}

//Business Logic
public void addCategory() throws Throwable {
	
    ExcelUtility eLib = new ExcelUtility();
	
	String catDetails = eLib.getDataFromExcel("Sheet1", 13, 2);
	categorydetails.sendKeys(catDetails);
	Addcategorybutton2.click();
}

public void editCategory(String catgryDetails) throws Throwable {
	//categorydetails.clear();
	//ExcelUtility eLib= new ExcelUtility();
	//JavaUtility jLib = new JavaUtility();
	//String catgryDetails = eLib.getDataFromExcel("Sheet1", 13, 3)+jLib.getRandomNumber();
	//categorydetails.sendKeys(catgryDetails);
	//updatecategorybtn.click();
}
}
