package com.lithium.mineraloi.university;

import com.lithium.mineraloi.university.browser.DriverManager;
import com.lithium.mineraloil.selenium.elements.BaseElement;
import com.lithium.mineraloil.selenium.elements.Driver;
import com.lithium.mineraloil.selenium.elements.TextElement;
import org.openqa.selenium.By;

public class TwitterView {
    private Driver driver;

    public TwitterView() {
        driver = DriverManager.INSTANCE.getDriver();
    }

    public BaseElement getFilterHomeTimelineButton() {
        return driver.createBaseElement(By.xpath("//button[@class='filterHomeTimelineButton']"));
    }

    public TextElement getFilterTextElement() {
        return driver.createTextElement(By.xpath("//input[@class='filter-keyword']"));
    }

    public BaseElement getTweetStyleOneElement() {
        return driver.createBaseElement(By.xpath("//div[@class='homeTimeline']"))
                .createBaseElement(By.xpath("//div[@id='timeline-inner']"))
                .createBaseElement(By.xpath("//div[@class='tweet-style-one']"));
    }

    public BaseElement getErrorElement() {
        return driver.createBaseElement(By.xpath("//div[@class='error']"));
    }
}
