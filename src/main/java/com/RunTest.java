package com;

import com.Common.Config;
import com.Pages.Careers;
import com.Pages.Landing;
import com.Pages.OpenPosition;
import com.Pages.QaCarriers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.junit.Assert;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;

import static com.codeborne.selenide.Selenide.screenshot;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class RunTest {

    public static void main(String[] args)
    {
        try
        {
            Config config=new Config().config("production");
            Landing landing = new Landing();
            Careers careers = new Careers();
            QaCarriers qaCarriers = new QaCarriers();
            OpenPosition openPosition = new OpenPosition();

            Configuration.browser = "chrome";
            Configuration.browserSize="start-maximized";
            Configuration.reportsFolder=System.getProperty("user.dir")+"/test-result";

            //Selenium grid start
            DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
            RemoteWebDriver driver = null;
            URL url=new URL(config.getGridUrl());
            switch (config.getBrowser())
            {
                case "firefox":
                    desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
                    FirefoxOptions firefoxOptions=new FirefoxOptions();
                    firefoxOptions.merge(desiredCapabilities);
                    driver = new RemoteWebDriver(url, firefoxOptions);
                    break;
                case "chrome":
                default:
                    desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
                    ChromeOptions chromeOptions=new ChromeOptions();
                    chromeOptions.merge(desiredCapabilities);
                    driver = new RemoteWebDriver(url, chromeOptions);
                    break;
            }
            setWebDriver(driver);
            //Selenium grid end


            /* Test Automation 1. step*/
            landing.openLandingPage();

            /* Test Automation 2. step*/
            landing.clickCareersButton();
            careers.checkCareerPageAndBlocks();

            /* Test Automation 3. step*/
            careers.findQaTeams();
            qaCarriers.clickJobButton();
            openPosition.checkAndFilter();

            /* Test Automation 4. step*/
            openPosition.checkJobs();

            /* Test Automation 5. step*/
            openPosition.clickApplyButton();
            switchTo().window(1);
            String leverUrl=WebDriverRunner.getWebDriver().getCurrentUrl();
            if(!leverUrl.contains("lever"))
            {
                Assert.assertTrue("Lever Application is not open",false);
            }
        }
        catch (Exception e)
        {
            screenshot("test-failed-"+new Timestamp(System.currentTimeMillis()));
            e.printStackTrace();
        }

    }
}
