package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class NewOrderPage {

	/*
	 * @author Kaveri
	 */
	    
	    WebDriver driver;
	        public NewOrderPage(WebDriver driver) {            
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	     }
	    
	  @FindBy(linkText = "New Order")
	  private WebElement newOrder;
	  
	  @FindBy(xpath = "//*[@id='1']")
	  private WebElement quantityEdit;
	  
	  public WebElement getQuantityEdit() {
		return quantityEdit;
	}

	@FindBy(xpath = "//input[@value='Post Order']")
	  private WebElement postOrderBtn;
	  
	public WebElement getNewOrder() {
		return newOrder;
	}

	public WebElement getPostOrderBtn() {
		return postOrderBtn;
	}
	
	//Business logic
	public void postNewOrder() throws Throwable {
		newOrder.click();
		ExcelUtility eLib = new ExcelUtility();
		String quantity = eLib.getDataFromExcel("Sheet1", 7, 7);
		quantityEdit.sendKeys(quantity);
		postOrderBtn.click();
	}
	  
	  
}
