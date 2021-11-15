package LWC.features.page_objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShipmentPage {
    WebDriver driver;
//    WebDriverWait wait = new WebDriverWait(driver, 30);

    By usernameinput = By.id("username");
    By passwordinput = By.id("password");
    By login_button = By.id("Login");
    By confirmation_page = By.xpath("(//*[@class=\"appName slds-context-bar__label-action slds-context-bar__app-name\"]/span)");
    By appLauncher = By.xpath("(//*[@class=\"appLauncher slds-context-bar__icon-action\"]/one-app-launcher-header/button)");
    By appLauncher_display = By.xpath("(//*[@class=\"panel-content scrollable\"])");
    By search_input_applauncher = By.xpath("(//input[@class=\"slds-input\"])");
//    By shipment_component = By.xpath("(//*[@class=\"al-menu-dropdown-list\"][2]/one-app-launcher-menu-item/a)");
    By titleText_shipment = By.xpath("(//*[@class=\"slds-var-p-right_x-small\"])");
    By shipment_listview = By.xpath("(//*[@title=\"Select List View\"])");
    By allshipment_view = By.xpath("(//*[@class=\"slds-dropdown__list slds-show\"]/li[2]/a/span)");
    By all_shipment_link = By.xpath("(//*[@class=\"slds-dropdown__list slds-show\"]/li[2]/a)");

    public ShipmentPage(WebDriver driver) {
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

    //Shipment

    public String getConfirmationHomePage(){
        return    driver.findElement(confirmation_page).getText();
    }

    public void display_app_launcher(){
        driver.findElement(appLauncher).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(appLauncher_display));
    }

    public void search_shipment_component(String component) throws InterruptedException {
        driver.findElement(search_input_applauncher).sendKeys(component);
        Thread.sleep(800);
//        JavascriptExecutor executor = (JavascriptExecutor) driver2;
//        executor.executeScript("arguments[0].scrollIntoView()", shipment_component);
//        executor.executeScript("arguments[0].click();", shipment_component);
//        Thread.sleep(200);
    }

    public String getShipmentTitle(){
        return    driver.findElement(titleText_shipment).getText();
    }

    public void display_list_view(){
        System.out.println("First executor");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView()", shipment_listview);
        executor.executeScript("arguments[0].click();", shipment_listview);
    }

    public String get_allshipment_view() {
        return  driver.findElement(allshipment_view).getText();
    }

    public void allview_shipment_option() throws InterruptedException {
        System.out.println("Second executor");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView()", all_shipment_link);
        executor.executeScript("arguments[0].click();", all_shipment_link);
    }
}
