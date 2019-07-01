package com.lithium.mineraloi.university.browser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.lithium.mineraloil.selenium.browsers.BrowserType;
import com.lithium.mineraloil.selenium.elements.Driver;
import com.lithium.mineraloil.selenium.elements.DriverConfiguration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

/**
 * This class contains helper methods that start up the Chrome Driver that is located in the resources.
 */
public class BrowserHelper {
    private Config config;
    private final Driver driver;


    public BrowserHelper(Driver driver) {
        this.driver = driver;
    }

    public void startBrowser() {
        driver.setDriverConfiguration(getDriverConfiguration());
        driver.startDriver();
        driver.get(getConfig().getBaseUrl());
    }

    public void stopBrowser() {
        driver.stop();
    }

    public DriverConfiguration getDriverConfiguration() {
        String remoteWebDriverAddress = "127.0.0.1";

        BrowserType browserType = BrowserType.CHROME;
        return DriverConfiguration.builder()
                                  .browserType(browserType)
                                  .executablePath(getChromeBinary().getPath())
                                  .chromeDesiredCapabilities(getDesiredCapabilities())
                                  .build();
    }

    public URL getChromeBinary() {
        return BrowserHelper.class.getClassLoader().getResource("chromedriver");
    }

    private DesiredCapabilities getDesiredCapabilities() {
        Map<String, Object> prefs = new HashMap();
        DesiredCapabilities profile = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences loggingPrefs = new LoggingPreferences();
        loggingPrefs.enable(LogType.BROWSER, Level.ALL);

        prefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
        prefs.put("download.prompt_for_download", false);
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);
        options.addArguments("disable-notifications");

        profile.setCapability("name", "chrome");
        profile.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
        profile.setCapability(ChromeOptions.CAPABILITY, options);
        profile.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        profile.setCapability(CapabilityType.LOGGING_PREFS, loggingPrefs);
        return profile;
    }

    private Config getConfig() {
        if (config == null) {
            String configFile = System.getProperty("user.dir") + "/conf/config.yml";
            final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            try {
                config = mapper.readValue(new File(configFile), Config.class);
            } catch (IOException e) {
                System.out.println("Cannot Read File");
            }
        }
        return config;
    }
}
