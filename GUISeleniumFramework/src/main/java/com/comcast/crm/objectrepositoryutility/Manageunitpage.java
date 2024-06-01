package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;



public class Manageunitpage{

	WebDriver driver;
		public Manageunitpage(WebDriver driver)

	{

		PageFactory.initElements(driver, this);

	}



@FindBy(xpath = "//input[@value='Delete']")
private WebElement Deletbtn;

//edit
@FindBy(xpath="//*[@class='table_mainWrapper']//section//form//tr[last()]//td[3]")
private WebElement viewUnit;

public WebElement getViewUnit() {
	return viewUnit;
}



@FindBy(xpath = "//img[@alt='edit'])[4]")
private WebElement Editimg;


@FindBy(xpath = "//input[@placeholder='Unit Name']")
private WebElement unitNameEdit;

@FindBy(xpath = "//textarea[@placeholder='Details']")
private WebElement DtailseEdit;

@FindBy(xpath = "//input[@value='Update Unit']")
private WebElement updateunitBtn;


@FindBy(xpath = "//input[@value='+ Add Unit']")
private WebElement Addunitbtn;

// add unit page

@FindBy(id = "unitName")
private WebElement addunitname;


@FindBy(id = "unitDetails")
private WebElement addDetails;

@FindBy(xpath = "//input[@value='Add Unit']")
private WebElement AddunitBtn2;

public WebElement getDeletbtn() {
return Deletbtn;

}

public WebElement getEditimg() {
return Editimg;

}

public WebElement getUnitNameEdit() {
return unitNameEdit;

}

public WebElement getDtailseEdit() {
return DtailseEdit;

}

public WebElement getUpdateunitBtn() {
return updateunitBtn;

}

public WebElement getAddunitbtn() {
return Addunitbtn;

}

public WebElement getAddunitname() {
return addunitname;

}

public WebElement getAddDetails() {
return addDetails;

}

public WebElement getAddunitBtn2() {
return AddunitBtn2;

}
//Business logic
public void addUnit() throws Throwable {
	Addunitbtn.click();
	ExcelUtility eLib = new ExcelUtility();
	addunitname.sendKeys(eLib.getDataFromExcel("Sheet1", 10, 1));
	addDetails.sendKeys(eLib.getDataFromExcel("Sheet1", 10, 2));
	AddunitBtn2.click();
}


}
