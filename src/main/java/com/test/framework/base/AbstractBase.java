package com.test.framework.base;

import com.test.framework.support.Property;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public abstract class AbstractBase<T extends WebElement> {

    private static final Logger LOG = Logger.getLogger(AbstractBase.class);
    private WebDriver driver;

    public AbstractBase(WebDriver driver) {
        this.driver = driver;
        //LOG.info("Current Driver: " + driver);
    }

    public void clickOnIfPresent(T element, int duration) {
        if (elementPresent(element, duration)) {
            element.click();
        }
    }

    public void clickOnIfPresents(List<T> element, int duration, int index) {
        if (elementsPresent(element, duration)) {
            element.get(index).click();
        }
    }

    public boolean contains(T element, String text) {
        return element.getText().contains(text);
    }

    public boolean contains(List<T> elements, int index, String text) {
        return elements.get(index).getText().contains(text);
    }

    public boolean elementNotPresent(T element) {
        try {
            element.isDisplayed();
            return false;
        } catch (NoSuchElementException | TimeoutException ignore) {
            return true;
        }
    }

    public boolean elementNotPresent(T element, int duration) {
        try {
            new WebDriverWait(driver, duration).until(ExpectedConditions.invisibilityOf(element));
            return false;
        } catch (NoSuchElementException | TimeoutException ignore) {
            return true;
        }
    }

    public boolean elementPresent(T element, int duration) {
        try {
            driver.getPageSource();
            new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException ignore) {
            return false;
        }
    }

    public boolean elementPresent(T element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException | TimeoutException ignore) {
            return false;
        }
    }

    public boolean elementsNotPresent(List<T> elements, int duration) {
        try {
            new WebDriverWait(driver, duration).until(ExpectedConditions.invisibilityOfAllElements((List<WebElement>) elements));
            return false;
        } catch (NoSuchElementException | TimeoutException | IndexOutOfBoundsException ignore) {
            return true;
        }
    }

    public boolean elementsPresent(List<T> elements, int duration) {
        try {
            new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOfAllElements((List<WebElement>) elements));
            return true;
        } catch (NoSuchElementException | TimeoutException | IndexOutOfBoundsException ignore) {
            return false;
        }
    }

    public boolean elementClickable(T element) {
        try {
            new WebDriverWait(driver, Property.IMPLICIT_WAIT.toInt()).until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (NoSuchElementException | TimeoutException ignore) {
            return false;
        }
    }

    public void assertElementClickable(T element) {
        assertTrue(elementClickable(element));
    }

    public boolean multipleElementsWithAnd(int duration, T... args) {
        ExpectedCondition[] expected = getExpectedConditions(args);
        try {
            new WebDriverWait(driver, duration).until(ExpectedConditions.and(expected));
            return true;
        } catch (NoSuchElementException | TimeoutException ignore) {
            return false;
        }
    }

    public boolean multipleElementsWithOr(int duration, T... args) {
        ExpectedCondition[] expected = getExpectedConditions(args);
        try {
            new WebDriverWait(driver, duration).until(ExpectedConditions.or(expected));
            return true;
        } catch (NoSuchElementException | TimeoutException ignore) {
            return false;
        }
    }

    public void setDefaultDriverWaitTime() {
        setDriverWaitTime(Integer.parseInt(Property.IMPLICIT_WAIT.toString()));
    }

    public void setDriverWaitTime(int duration) {
        LOG.info("Setting implicit wait time for driver: '" + duration + "'");
        driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
    }

    public boolean visibleAndInvisibleElement(T visibleElement, T invisibleElement, int duration) {
        ExpectedCondition<Boolean> expectation = driver -> (visibleElement.isDisplayed() && !invisibleElement.isDisplayed());
        try {
            new WebDriverWait(driver, duration).until(expectation);
            return true;
        } catch (NoSuchElementException | TimeoutException ignore) {
            return false;
        }
    }

    private ExpectedCondition[] getExpectedConditions(T[] args) {
        List<T> elements = Arrays.asList(args);
        ExpectedCondition[] expected = new ExpectedCondition[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            expected[i] = ExpectedConditions.visibilityOf(elements.get(i));
        }
        return expected;
    }
}
