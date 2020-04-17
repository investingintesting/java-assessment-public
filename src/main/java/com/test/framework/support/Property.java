package com.test.framework.support;

import org.junit.Assert;

import java.util.Optional;

import static com.test.framework.support.Util.stringIsEmpty;

public enum Property {

    PLATFORM_NAME(System.getProperty("platform.name")),
    PLATFORM_VERSION(System.getProperty("platform.version")),
    IMPLICIT_WAIT(Optional.ofNullable(System.getProperty("implicit.wait")).orElse("3")),
    COMPARE_IMAGE(Optional.ofNullable(System.getProperty("compare.image")).orElse("false")),

    //Appium Specific
    APP_FILE(System.getProperty("app.file")),
    DEVICE_NAME(System.getProperty("device.name")),
    APPIUM_HOST(Optional.ofNullable(System.getProperty("appium.host")).orElse("127.0.0.1")),
    APPIUM_PORT(Optional.ofNullable(System.getProperty("appium.port")).orElse("0")),
    NO_RESET(Optional.ofNullable(System.getProperty("no.reset")).orElse("true")),
    IGNORE_UNIMPORTANT_VIEWS(Optional.ofNullable(System.getProperty("ignore.unimportant.views")).orElse("false")),
    NATIVE_WEB_SCREENSHOT(Optional.ofNullable(System.getProperty("native.web.screenshot")).orElse("false")),
    APPIUM_LOG(Optional.ofNullable(System.getProperty("appium.log")).orElse("warn")),
    XCODE_ORG_ID(System.getProperty("xcode.org.id")),
    XCODE_SIGNING_ID(System.getProperty("xcode.signing.id")),

    //Selenium Specific
    BROWSER_NAME(Optional.ofNullable(System.getProperty("browser.name")).orElse("Chrome")),
    BASE_URL(System.getProperty("base.url")),
    GRID_URL(System.getProperty("grid.url")),
    GRID_USE(System.getProperty("grid.use")),
    SELENIUM_LOG(Optional.ofNullable(System.getProperty("selenium.log")).orElse("WARNING")),
    BROWSER_HEIGHT(Optional.ofNullable(System.getProperty("browser.height")).orElse("900")),
    BROWSER_WIDTH(Optional.ofNullable(System.getProperty("browser.width")).orElse("1400")),

    TESTRAIL_URL(System.getProperty("testrail.url"));

    private String value;

    Property(String value) {
        this.value = value;
    }

    public boolean toBoolean() {
        if (stringIsEmpty(value)) {
            Assert.fail("Property " + this.name() + " is missing. Check your your pom.xml");
        }
        return Boolean.parseBoolean(value);
    }

    public int toInt() {
        if (stringIsEmpty(value)) {
            Assert.fail("Property " + this.name() + " is missing. Check your your pom.xml");
        }
        return Integer.parseInt(value);
    }

    public String toString() {
        if (stringIsEmpty(value)) {
            Assert.fail("Property " + this.name() + " is missing. Check your your pom.xml");
        }
        return value;
    }
}
