package com.lithium.mineraloi.university.browser;

import com.lithium.mineraloil.selenium.elements.Driver;

public enum DriverManager {
    INSTANCE;

    private static Driver driver = new Driver();

    public Driver getDriver() {
        return driver;
    }
}
