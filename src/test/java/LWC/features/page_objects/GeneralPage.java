package LWC.features.page_objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralPage {
    WebDriver driver;

    By usernameinput = By.id("username");
    By passwordinput = By.id("password");
    By login_button = By.id("Login");

    By confirmation_page = By.xpath("(//*[@class=\"appName slds-context-bar__label-action slds-context-bar__app-name\"]/span)");
    By appLauncher = By.xpath("(//*[@class=\"appLauncher slds-context-bar__icon-action\"]/one-app-launcher-header/button)");
    By appLauncher_display = By.xpath("(//*[@class=\"panel-content scrollable\"])");
    By search_input_applauncher = By.xpath("(//input[@class=\"slds-input\"])");
    By view_all = By.xpath("(//*[@class=\"slds-size_medium\"]/lightning-button/button)");
    By shipment_component = By.xpath("(//*[@class=\"slds-accordion__content\"]/slot/ul/li/one-app-launcher-tab-item/a/span/lightning-formatted-rich-text/span/p)");

    public GeneralPage(WebDriver driver) {
        this.driver = driver;
    }

    //Login

    public void setUsername(String strUserName){
        driver.findElement(usernameinput).sendKeys(strUserName);
    }
    public void setPassword(String strPassword) {
        driver.findElement(passwordinput).sendKeys(strPassword);
    }
    public void setclickLogin(){
        driver.findElement(login_button).click();
    }

    public void personalLogin (String username, String password) throws InterruptedException {
        this.setUsername(username);
        Thread.sleep(200);
        this.setPassword(password);
        Thread.sleep(200);
        this.setclickLogin();
        Thread.sleep(500);
    }

    public String getConfirmationHomePage(){
        return    driver.findElement(confirmation_page).getText();
    }

    public void display_app_launcher(){
        driver.findElement(appLauncher).click();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(appLauncher_display));
    }

    public void search_component(String component) throws InterruptedException {
        driver.findElement(view_all).click();
        Thread.sleep(800);
        driver.findElement(search_input_applauncher).sendKeys(component);
        Thread.sleep(700);

        driver.findElement(shipment_component).click();
        Thread.sleep(1000);
    }


}
