package com.lithium.mineraloi.university.browser;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class BeforeClassExt implements BeforeAllCallback {

    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        new BrowserHelper(DriverManager.INSTANCE.getDriver()).startBrowser();
    }
}
