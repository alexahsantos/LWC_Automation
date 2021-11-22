package LWC.features.page_objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class LimitsMonitorPage {
    WebDriver driver;

    By confirmation_page = By.xpath("(//*[@class=\"appName slds-context-bar__label-action slds-context-bar__app-name\"]/span)");
    By appLauncher = By.xpath("(//*[@class=\"appLauncher slds-context-bar__icon-action\"]/one-app-launcher-header/button)");
    By appLauncher_display = By.xpath("(//*[@class=\"panel-content scrollable\"])");
    By search_input_applauncher = By.xpath("(//input[@class=\"slds-input\"])");
    By view_all = By.xpath("(//*[@class=\"slds-size_medium\"]/lightning-button/button)");
    By limitsmonitor_component = By.xpath("(//*[@class=\"slds-accordion__content\"]/slot/ul/li/one-app-launcher-tab-item/a/span/lightning-formatted-rich-text/span/p)");

    //Elements Page
    By LimitMonitor_title_text = By.xpath("//*[@class=\"truncate title\"]");
    By logo_oktana = By.xpath("//*[@class=\"slds-no-flex\"]/slot/img");
    By limitsmonitor_subtitle = By.xpath("//*[@class=\"slds-text-title_bold\"]");


    public LimitsMonitorPage(WebDriver driver) {
        this.driver = driver;
    }

    //Shipment

    public String getConfirmationHomePage(){
        return    driver.findElement(confirmation_page).getText();
    }

    public void display_app_launcher(){
        driver.findElement(appLauncher).click();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(appLauncher_display));
    }

    public void search_limitsmonitor_component(String component) throws InterruptedException {
        driver.findElement(view_all).click();
        Thread.sleep(800);
        driver.findElement(search_input_applauncher).sendKeys(component);
        Thread.sleep(700);

        driver.findElement(limitsmonitor_component).click();
        Thread.sleep(1000);
    }

    public String getTitle(){
        return driver.findElement(LimitMonitor_title_text).getText();
    }

    public String getSubtitle(){
        return driver.findElement(limitsmonitor_subtitle).getText();
    }

    public void confirm_elements_on_the_page() throws InterruptedException {
        driver.findElement(logo_oktana).isDisplayed();
        Thread.sleep(500);
    }
}
