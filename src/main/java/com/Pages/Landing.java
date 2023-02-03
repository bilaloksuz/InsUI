package com.Pages;

import com.Common.BasePage;
import com.codeborne.selenide.*;
/*
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.BrowserType;
*/
import java.util.List;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class Landing extends BasePage {

    private SelenideElement logo = $(byClassName("navbar-brand")).$("img");
    private SelenideElement cookies = $(byId("wt-cli-accept-all-btn"));
    private List<SelenideElement> menuItemList = $$(byId("mega-menu-1"));
    private List<SelenideElement> moreItemList;
    private SelenideElement moreItem;
    private SelenideElement careerItem;

    public Landing() {

    }

    public void openLandingPage() {
        navigateUrl(config.getBaseUrl());
        isExits("Logo is not found. Landing page is not open.",logo);
        assertValue(config.getInsiderLogoUrl(), logo.getAttribute("src"));

        if(cookies.exists())
        {
            clickButton(cookies);
        }

        for (int i = 0; i < menuItemList.size(); i++) {
            SelenideElement selenideElement = menuItemList.get(i);
            if(selenideElement.getText().equals(config.getMoreText()))
            {
                moreItem=selenideElement;
            }
        }
    }

    public void clickCareersButton()
    {
        clickButton(moreItem);
        /* */
        moreItemList=$$(byClassName("col-lg-4"));
        for (int i = 0; i <moreItemList.size() ; i++) {
            String value=moreItemList.get(i).getText().replace("\n"," ");
            if(value.equals(config.getCareerText()))
            {
                careerItem=moreItemList.get(i);
                break;
            }
        }
        clickButton(careerItem);
    }

    public static void main(String[] args) {

        Configuration.browser="chrome";
        Landing landing = new Landing();

        landing.openLandingPage();
        landing.clickCareersButton();
    }
}
