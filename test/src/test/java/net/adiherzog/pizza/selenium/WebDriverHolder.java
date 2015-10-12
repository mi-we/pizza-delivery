package net.adiherzog.pizza.selenium;

import net.adiherzog.pizza.scenarioo.ScenariooEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * This singleton creates and holds the reference to the WebDriver which controls the browser.
 * This makes it possible to access the WebDriver from all the page objects and wherever else
 * needed without passing any references.
 *
 * Currently this holder only supports one concurrent WebDriver. If you want to run your tests in parallel
 * you should extend the holder to hold an instance of a WebDriver for each thread.
 */
public enum WebDriverHolder {

    INSTANCE;

    private EventFiringWebDriver webDriver;

    public void openBrowser() {
        webDriver = new EventFiringWebDriver(new FirefoxDriver());
    }

    public void registerEventListener(ScenariooEventListener scenariooEventListener) {
        webDriver.register(scenariooEventListener);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void closeBrowser() {
        webDriver.quit();
    }

}