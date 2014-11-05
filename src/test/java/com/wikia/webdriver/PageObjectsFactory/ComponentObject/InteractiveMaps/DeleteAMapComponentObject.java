package com.wikia.webdriver.PageObjectsFactory.ComponentObject.InteractiveMaps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wikia.webdriver.Common.ContentPatterns.InteractiveMapsContent;
import com.wikia.webdriver.Common.Core.Assertion;
import com.wikia.webdriver.PageObjectsFactory.PageObject.BasePageObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.Special.InteractiveMaps.InteractiveMapsPageObject;

/**
 * @author Robert 'Rochan' Chan
 *
 */

public class DeleteAMapComponentObject extends BasePageObject {

	@FindBy(css = "#intMapsDeleteMapModal .button.primary")
	private WebElement deleteMapButton;
	@FindBy(css = "#intMapsDeleteMapModal")
	private WebElement deleteMapModal;
	@FindBy(css = "#intMapError")
	private WebElement deleteMapError;

	public DeleteAMapComponentObject(WebDriver driver) {
		super(driver);
	}

	public InteractiveMapsPageObject deleteMap() {
		clickDeleteMap();
		waitForElementNotVisibleByElement(deleteMapModal);
		return new InteractiveMapsPageObject(driver);
	}

	public void clickDeleteMap() {
		waitForElementVisibleByElement(deleteMapModal);
		waitForElementClickableByElement(deleteMapButton);
		deleteMapButton.click();
	}

	public String getDeleteMapError() {
		waitForElementVisibleByElement(deleteMapError);
		return deleteMapError.getText();
	}
}