package com.Pages;

import com.Common.BasePage;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Careers extends BasePage {


    private List<SelenideElement> locationLists = $$(byClassName("location-figure"));
    private List<SelenideElement> jobTitles = $$(byClassName("job-title"));
    private SelenideElement qaJobs;
    private SelenideElement findJobButton = $(byClassName("button-group"));
    private SelenideElement seeAllTeamsButton = $(byClassName("btn-outline-secondary"));
    private SelenideElement teamsButton = $(byClassName("btn-outline-secondary"));
    private SelenideElement teamsBlock = $(byClassName("career-load-more"));
    private SelenideElement locationBlock = $(byId("career-our-location"));
    private SelenideElement lifeBlock = $(byAttribute("data-id","a8e7b90"));

    public Careers()
    {

    }

    public void checkCareerPageAndBlocks()
    {
        isDisplayed("Find job button is not visible.",findJobButton);
        assertValue(findJobButton.getText(),config.getFindJobButtonText());
        isDisplayed("Teams block is not visible.",teamsBlock);
        isDisplayed("Location block is not visible.",locationBlock);
        isDisplayed("Life at Insider block is not visible.",lifeBlock);
    }

    public void findQaTeams() throws InterruptedException
    {
        clickButton(seeAllTeamsButton);
        Thread.sleep(5000);

        for (int i = 0; i <jobTitles.size() ; i++)
        {
            if (jobTitles.get(i).getText().equals(config.getQaJobButtonText()))
            {
                qaJobs=jobTitles.get(i);
                break;
            }
        }
        clickButton(qaJobs);
    }


}
