package com.wikia.webdriver.PageObjectsFactory.ComponentObject.Lightbox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wikia.webdriver.Common.Core.Assertion;
import com.wikia.webdriver.Common.Logging.PageObjectLogging;
import com.wikia.webdriver.PageObjectsFactory.PageObject.Special.FilePage.FilePagePageObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.WikiBasePageObject;

/**
 * @author Karol 'kkarolk' Kujawiak
 * @author Saipetch Kongkatong
 */
public class LightboxComponentObject extends WikiBasePageObject {
	public LightboxComponentObject(WebDriver driver) {
		super(driver);
	}

	@FindBy(className="WikiaLightbox")
	private WebElement lightBoxHeader;
	@FindBy(css=".thumb.thumbinner")
	private WebElement imageThumbnail;
	@FindBy(css="#LightboxModal")
	private WebElement lightBoxModal;
	@FindBy(css="span[data-pinned-title='Unpin top and bottom bars']")
	private WebElement pinButton;
	@FindBy(css="button.share-button.secondary")
	private WebElement shareButton;
	@FindBy(css="div.hero-inner")
	private WebElement moreInfoThumbnail;
	@FindBy(css="a.facebook")
	private WebElement facebookShareLink;
	@FindBy(css="a.twitter")
	private WebElement twitterShareLink;
	@FindBy(css="a.stumbleupon")
	private WebElement stumbleUponShareLink;
	@FindBy(css="a.reddit")
	private WebElement redditShareLink;
	@FindBy(css="a.plusone")
	private WebElement plusoneShareLink;
	@FindBy(css="div.video-media")
	private WebElement videoContainer;
	@FindBy(css=".LightboxHeader h1 a")
	private WebElement titleLink;
	@FindBy(css="a.more-info-button")
	private WebElement moreInfoLink;
	@FindBy(css=".WikiaLightbox div:not(.video-media)")
	private WebElement imageContainer;

	public void verifyLightboxPopup() {
		waitForElementByElement(lightBoxHeader);
		PageObjectLogging.log("verifyLightboxPopup", "verify lightbox appeared", true);
	}

	public void verifyLightboxVideo() {
		waitForElementByElement(videoContainer);
		PageObjectLogging.log("verifyLightboxVideo", "verify lightbox video appeared", true);
	}

	public void verifyLightboxImage() {
		waitForElementByElement(imageContainer);
		PageObjectLogging.log("verifyLightboxImage", "Verify lightbox image appeared", true);
	}

	public LightboxComponentObject openLightbox() {
		waitForElementByElement(imageThumbnail);
		scrollAndClick(imageThumbnail);
		PageObjectLogging.log("openLightbox", "opened ligthbox", true);
		return new LightboxComponentObject(driver);
	}

	public void clickPinButton() {
		builder.moveToElement(lightBoxModal).
				click(pinButton).
				build().
				perform();
		PageObjectLogging.log("clickPinButton", "pin button was clicked", true);
	}

	public void clickShareButton() {
		waitForElementByElement(shareButton);
		shareButton.click();
		waitForElementByElement(moreInfoThumbnail);
		PageObjectLogging.log("clickShareButton", "share button is clicked", true);
	}

	public void verifyShareButtons() {
		waitForElementByElement(plusoneShareLink);
		waitForElementByElement(redditShareLink);
		waitForElementByElement(stumbleUponShareLink);
		waitForElementByElement(twitterShareLink);
		waitForElementByElement(facebookShareLink);
		PageObjectLogging.log("verifyShareButtons", "all share buttons are visible", true);
	}

	public void clickFacebookShareButton() {
		facebookShareLink.click();
		PageObjectLogging.log("clickFacebookShareButton", "fb share button is clicked", true);
	}

	public void clickTwitterShareButton() {
		twitterShareLink.click();
		PageObjectLogging.log("clickTwitterShareButton", "twitter share button is clicked", true);
	}

	public void clickStumbleUponShareButton() {
		stumbleUponShareLink.click();
		PageObjectLogging.log("clickStumbleUponShareButton", "stumbleupon share button is clicked", true);
	}

	public void clickRedditShareButton() {
		redditShareLink.click();
		PageObjectLogging.log("clickRedditShareButton", "reddit share button is clicked", true);
	}

	public void clickPlusOneShareButton() {
		plusoneShareLink.click();
		PageObjectLogging.log("clickPlusOneShareButton", "plus one share button is clicked", true);
	}

	public void verifyTitleUrl(String fileUrl) {
		String titleUrl = getTitleUrl();
		Assertion.assertEquals(fileUrl, titleUrl);
		verifyMoreInfoUrl(titleUrl);
	}

	public String getTitleUrl() {
		String url = titleLink.getAttribute("href");
		PageObjectLogging.log("getTitleUrl", "Title url: " + url, true);
		return url;
	}

	public FilePagePageObject clickTitle() {
		waitForElementByElement(titleLink);
		titleLink.click();
		PageObjectLogging.log("clickTitleUrl", "Title url is clicked", true);
		return new FilePagePageObject(driver);
	}

	public void verifyMoreInfoUrl(String fileUrl) {
		Assertion.assertEquals(fileUrl, getMoreInfoUrl());
	}

	public String getMoreInfoUrl() {
		return moreInfoLink.getAttribute("href");
	}
}
