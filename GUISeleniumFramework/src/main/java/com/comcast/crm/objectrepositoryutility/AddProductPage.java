package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class AddProductPage {

	  WebDriver driver ;
		public AddProductPage(WebDriver driver) 
        {
			this.driver=driver;
          PageFactory.initElements(driver, this);
       }

	@FindBy(name = "txtProductName")
    private WebElement productEdt;

    @FindBy(name = "txtProductPrice")
    private WebElement priceEdt;

   @FindBy(name = "cmbProductUnit")
   private WebElement UnitDD;

	@FindBy(name = "cmbProductCategory")
	private WebElement CategDD;

	public WebElement getProductEdt() {
      return productEdt;

	}

	public WebElement getPriceEdt() {
      return priceEdt;

	}

	public WebElement getUnitDD() {
		return UnitDD;

	}
    
	public WebElement getCategDD() {
      return CategDD;

	}
	public WebElement getEnableRbtn() {
     return EnableRbtn;

	}

	public WebElement getDisableRbtn() {
     return DisableRbtn;

	}

	public WebElement getDescriptn() {
     return Descriptn;
	}
	
	public WebElement getAddpbtn() {
      return Addpbtn;

	}

	@FindBy(xpath = "//input[@value='1']")
     private WebElement EnableRbtn;

	@FindBy(xpath = "//input[@value='2']")
    private WebElement DisableRbtn;

	@FindBy(xpath = "//textarea[@placeholder='Description']")
    private WebElement Descriptn;

	@FindBy(xpath = "//input[@type='submit']")
    private WebElement Addpbtn;

}

	

