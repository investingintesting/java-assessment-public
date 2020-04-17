package com.test.framework.support;

import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.test.framework.support.Util.getCurrentScenario;
import static com.test.framework.support.Util.setCurrentScenario;

public class Hooks {

    private static final Logger LOG = Logger.getLogger(Hooks.class);

    public static void hookAfter(WebDriver driver) {
        Scenario scenario = getCurrentScenario();
        LOG.info("### " + scenario.getStatus() + " ###");
        LOG.info("### Ending scenario: " + scenario.getName() + " ###");
        List<String> caseList = getScenariosStartWithCaseIds(scenario.getSourceTagNames());
        for (String currentTag : caseList) {
            scenario.write("<a href=\"" + Property.TESTRAIL_URL + currentTag + "\"> Test Scenario: C" + currentTag + "</a>");
        }
        if (scenario.isFailed()) {

        }
        ThreadLocalMap.cleanup();
    }

    public static void hookBefore(Scenario scenario) {
        LOG.info("### Starting scenario: " + scenario.getName() + " ###");
        setCurrentScenario(scenario);
    }

    private static String captureLog(WebDriver driver) {
        LOG.info("Capturing device logs");
        String logType;
        if (Property.PLATFORM_NAME.toString().equalsIgnoreCase("android"))
            logType = "logcat";
        else
            logType = "syslog";
        StringBuilder deviceLog = new StringBuilder();
        List<LogEntry> logEntries = driver.manage().logs().get(logType).getAll();
        for (LogEntry logLine : logEntries) {
            deviceLog.append(logLine).append(System.lineSeparator());
        }
        return deviceLog.toString();
    }

    private static List<String> getScenariosStartWithCaseIds(Collection collection) {
        List<String> list = new ArrayList<>();
        for (Object currentTag : collection) {
            if (currentTag.toString().startsWith("@C")) {
                list.add(currentTag.toString().substring(2));
            }
        }
        return list;
    }
}
