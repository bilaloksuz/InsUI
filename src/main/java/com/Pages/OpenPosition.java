package com.Pages;

import com.Common.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OpenPosition extends BasePage
{
    public SelenideElement departmentFilter=$(byId("select2-filter-by-department-container"));
    public SelenideElement locationFilter=$(byId("select2-filter-by-location-container"));
    public List<SelenideElement> cities;
    public SelenideElement myLocation;
    public List<SelenideElement> positionTitles=$$(byClassName("position-title"));
    public List<SelenideElement> positionDepartments=$$(byClassName("position-department"));
    public List<SelenideElement> positionLocations=$$(byClassName("position-location"));
    public List<SelenideElement> positionLists=$$(byClassName("position-list-item-wrapper"));
    public List<SelenideElement> applyButtons=$$(byClassName("btn-navy"));

    public OpenPosition()
    {

    }

    public void checkAndFilter()
    {
        isExits("Department Filter is not visible.",departmentFilter);
        isExits("Location Filter is not visible.",locationFilter);
        String departmentValue=departmentFilter.getText().replace("×\n","");
        assertValue(departmentValue,config.getQaJobButtonText());
        clickButton(locationFilter);
        cities=$$(byClassName("select2-results__option"));
        for (int i = 0; i <cities.size() ; i++) {
            if(cities.get(i).getText().equals(config.getDefaultLocation()))
            {
                myLocation=cities.get(i);
                break;
            }
        }
        isExits(config.getDefaultLocation()+" is not visible.",myLocation);
        clickButton(myLocation);
    }

    public void checkJobs() throws InterruptedException {
        Thread.sleep(5000);

        for (int i = 0; i <positionTitles.size() ; i++)
        {
            SelenideElement position=waitElementForVisible(positionLists.get(i));
            if(!position.getText().contains(config.getQaJobTitle()))
            {
                Assert.assertTrue("Position title is not match.", false);
            }
        }

        for (int i = 0; i <positionDepartments.size() ; i++)
        {
            SelenideElement position=waitElementForVisible(positionDepartments.get(i));
            if(!position.getText().contains(config.getQaJobTitle()))
            {
                Assert.assertTrue("Position department is not match.",false);
            }
        }

        for (int i = 0; i <positionLocations.size() ; i++)
        {
            SelenideElement position=waitElementForVisible(positionLocations.get(i));
            if(!position.getText().contains(config.getDefaultLocation()))
            {
                Assert.assertTrue("Position location is not match.",false);
            }
        }
    }

    public void clickApplyButton()
    {
        for (int i = 0; i <applyButtons.size() ; i++)
        {
            SelenideElement button=waitElementForVisible(applyButtons.get(i).hover());
            if(button.getText().equals("Apply Now"))
            {
                clickButton(button);
                break;
            }
        }
    }

}
