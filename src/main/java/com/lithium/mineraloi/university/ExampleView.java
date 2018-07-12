package com.lithium.mineraloi.university;

import com.lithium.mineraloi.university.browser.DriverManager;
import com.lithium.mineraloil.selenium.elements.BaseElement;
import com.lithium.mineraloil.selenium.elements.Driver;
import com.lithium.mineraloil.selenium.elements.TextElement;
import org.openqa.selenium.By;

public class ExampleView {
    private Driver driver;

    public ExampleView() {
        driver = DriverManager.INSTANCE.getDriver();
    }

    public BaseElement getSomeElement() {
        return driver.createBaseElement(By.xpath("//div[@class='someClass']"));
    }

    public TextElement getTextElement() {
        return driver.createTextElement(By.xpath("//input[@class='textInput']"));
    }
}
