package com.lithium.mineraloi.university.browser;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class AfterClassExt implements AfterAllCallback {

    public void afterAll(ExtensionContext extensionContext) throws Exception {
        new BrowserHelper(DriverManager.INSTANCE.getDriver()).stopBrowser();
    }

}
