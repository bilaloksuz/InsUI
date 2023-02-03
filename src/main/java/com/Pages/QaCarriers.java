package com.Pages;

import com.Common.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class QaCarriers extends BasePage
{
    public SelenideElement qaBlock=$(byClassName("big-title-media"));
    public SelenideElement allQaJobsButton=$(byClassName("btn-outline-secondary"));

    public QaCarriers()
    {

    }

    public void clickJobButton()
    {
        isExits("Qa block is not visible.",qaBlock);
        isExits("Qa jobs button is not visible.",allQaJobsButton);
        assertValue(qaBlock.getText(),config.getQaJobTitle());
        clickButton(allQaJobsButton);
    }

}
