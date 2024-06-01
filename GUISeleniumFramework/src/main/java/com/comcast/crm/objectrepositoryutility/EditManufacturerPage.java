package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;

public class EditManufacturerPage {

	 WebDriver driver;
     public EditManufacturerPage(WebDriver driver) {            
     this.driver = driver;
     PageFactory.initElements(driver, this);
     }
     
    @FindBy(linkText= "Edit Profile")
    private WebElement editProfileBtn;
    
	@FindBy(id = "manufacturer:name")

	private WebElement Editname;

	@FindBy(id = "manufacturer:email")

	private WebElement EditEmail;

	@FindBy(id = "manufacturer:phone")

	private WebElement Editphone;

	@FindBy(xpath = "//input[@value='Update Profile']")

	private WebElement updateBtn;

	@FindBy(xpath = "//input[@value='Change Password']")

	private WebElement changepass;

	@FindBy(name = "txtOldPassword")

	private WebElement oldpass;

	@FindBy(name = "txtNewPassword")

	private WebElement newpass;

	@FindBy(name = "txtConfirmPassword")

	private WebElement confpass;

	@FindBy(xpath = "//input[@value='Change Password']")

	private WebElement changepass2;

	public WebElement getEditname() {

		return Editname;

	}

	public WebElement getEditEmail() {

		return EditEmail;

	}

	public WebElement getEditphone() {

		return Editphone;

	}

	public WebElement getUpdateBtn() {

		return updateBtn;

	}

	public WebElement getChangepass() {

		return changepass;

	}

	public WebElement getOldpass() {

		return oldpass;

	}

	public WebElement getNewpass() {

		return newpass;

	}

	public WebElement getConfpass() {

		return confpass;

	}

	public WebElement getChangepass2() {

		return changepass2;

	}

	public WebElement getEditProfileBtn() {
		return editProfileBtn;
	}
	
	//Business logic
	public void editManufacturerPassword() throws Throwable {
		editProfileBtn.click();
		changepass.click();
		ExcelUtility eLib = new ExcelUtility();
		String oldPas = eLib.getDataFromExcel("Sheet1", 4, 1);
		String newPas = eLib.getDataFromExcel("Sheet1", 4, 2);
		String confirmPas = eLib.getDataFromExcel("Sheet1", 4, 3);
		oldpass.sendKeys(oldPas);
		newpass.sendKeys(newPas);
		confpass.sendKeys(confirmPas);
		changepass2.click();
		
	}
}
