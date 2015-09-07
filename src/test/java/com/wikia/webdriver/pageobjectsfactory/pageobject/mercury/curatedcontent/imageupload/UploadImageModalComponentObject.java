package com.wikia.webdriver.pageobjectsfactory.pageobject.mercury.curatedcontent.imageupload;

import com.wikia.webdriver.pageobjectsfactory.pageobject.mercury.BasePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @ownership: Content X-Wing
 */
public class UploadImageModalComponentObject extends BasePageObject {

  @FindBy(css = ".modal-dialog li:nth-of-type(3)")
  private WebElement searchForImageButton;
  @FindBy(css = ".modal-dialog .crop-image")
  private WebElement cropImageButton;

  public UploadImageModalComponentObject(WebDriver driver) {
    super(driver);
  }

  public SearchForImagePageObject clickSearchForImageButton() {
    waitAndClick(searchForImageButton);
    return new SearchForImagePageObject(driver);
  }

  public boolean isCropOptionEnabled() {
    return !cropImageButton.getAttribute("class").contains("disabled");
  }

  public CroppingToolPageObject selectRecrop() {
    cropImageButton.click();
    return new CroppingToolPageObject(driver);
  }
}
