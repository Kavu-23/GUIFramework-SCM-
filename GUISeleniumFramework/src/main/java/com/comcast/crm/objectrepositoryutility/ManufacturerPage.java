package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * @auother:Preethi
 *
 * contains Manufacture page web elemnets
 */

public class ManufacturerPage {

WebDriver driver;
public ManufacturerPage(WebDriver driver)
{            
this.driver = driver;
PageFactory.initElements(driver, this);
}
@FindBy(id = "manufacturer:name")
private WebElement manufname;

public WebElement getmanufname() {
return manufname;
}
@FindBy(id = "manufacturer:email")
private WebElement manufemail;

public WebElement getmanufemail() {
return manufemail;
}
@FindBy(id = "manufacturer:phone")
private WebElement manufphone;

public WebElement getmanufphone() {
return manufphone;
}
@FindBy(id = "manufacturer:username")
private WebElement manufusername;

public WebElement getmanufusername() {
return manufusername;
}
@FindBy(id = "manufacturer:password")
private WebElement manufpassword;

public WebElement getmanufpassword() {
return manufpassword;
}

@FindBy(xpath= "//input[@value='Add Manufacturer']")
private WebElement manufaddbutton;

public WebElement getmanufaddbutton()
{
return manufaddbutton;
}

}
