package com.Common;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage {

    protected Config config = new Config().config("production");

    public BasePage()
    {

    }

    public static void navigateUrl(String url) {
        open(url);
    }

    public static void isExits(String message, SelenideElement element)
    {
        Assert.assertTrue(message, element.shouldBe(Condition.visible,Duration.ofSeconds(60)).exists());
    }

    public static void isDisplayed(String message, SelenideElement element)
    {
        Assert.assertTrue(message, element.shouldBe(Condition.visible,Duration.ofSeconds(60)).isDisplayed());
    }

    public static void assertValue(String condition, String message)
    {
        Assert.assertEquals(condition+" and "+message+" must be equals. It's not.",condition, message);
    }

    public static SelenideElement waitElementForVisible(SelenideElement selenideElement)
    {
        return selenideElement.shouldBe(Condition.visible, Duration.ofSeconds(60));
    }

    public static List<SelenideElement> waitElementForVisible(List<SelenideElement> selenideElement)
    {
        List<SelenideElement> elements=new ArrayList<>();
        for (int i = 0; i <selenideElement.size() ; i++)
        {
            elements.add(selenideElement.get(i).shouldBe(Condition.visible, Duration.ofSeconds(60)));
        }
        return elements;
    }

    public static void clickButton(SelenideElement element) {
        element.shouldBe(Condition.visible, Duration.ofSeconds(60)).click();
    }

}