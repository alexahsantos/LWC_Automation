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
    By view_all = By.xpath("(//*[@class=\"slds-size_medium\"]/lightning-button/button)");
    By shipment_component = By.xpath("(//*[@class=\"slds-accordion__content\"]/slot/ul/li/one-app-launcher-tab-item/a/span/lightning-formatted-rich-text/span/p)");
    By titleText_shipment = By.xpath("(//*[@class=\"slds-var-p-right_x-small\"])");
    By shipment_listview = By.xpath("(//*[@title=\"Select List View\"])");
    By allshipment_view = By.xpath("(//*[@class=\"slds-dropdown__list slds-show\"]/li[2]/a/span)");
    By all_shipment_link = By.xpath("(//*[@class=\"slds-dropdown__list slds-show\"]/li[2]/a)");
    By new_button = By.xpath("((//*[@class=\"forceActionLink\"]))");
    By ship_to_name = By.xpath("(//*[@class=\" input\"])[1]");
    By tracking_number = By.xpath("(//*[@class=\" input\"])[2]");
    By shipment_provider = By.xpath("(//a[@class=\"select\"])[1]");
    By usps_option = By.xpath("(//*[@class=\"select-options\"]/ul/li[4])");
    By fedex_option = By.xpath("(//*[@class=\"select-options\"]/ul/li[2])");
    By savebutton = By.xpath("(//button[@title=\"Save\"])");

    By provider_title_text = By.xpath("(//*[@class=\"package-title slds-col\"])");
    By provider_tracking = By.xpath("(//*[@class=\"package-subtitle slds-col\"]/span)");
    By provider_text = By.xpath("(//*[@class=\"package-subtitle slds-col\"])");

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
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(appLauncher_display));
    }

    public void search_shipment_component(String component) throws InterruptedException {
        driver.findElement(view_all).click();
        Thread.sleep(800);
        driver.findElement(search_input_applauncher).sendKeys(component);
        Thread.sleep(700);
        driver.findElement(shipment_component).click();
        Thread.sleep(500);
    }

    public String getShipmentTitle(){
        return    driver.findElement(titleText_shipment).getText();
    }

    public void display_list_view() throws InterruptedException {
        driver.findElement(shipment_listview).click();
        Thread.sleep(500);
 }

    public String get_allshipment_view() {
        return  driver.findElement(allshipment_view).getText();
    }

    public void allview_shipment_option() throws InterruptedException {
        driver.findElement(all_shipment_link).click();
        Thread.sleep(1000);
    }

    public void getNewbutton() throws InterruptedException {
        driver.findElement(new_button).click();
        Thread.sleep(1000);
    }

    public void getShipToName(String shiptoname) throws InterruptedException {
        driver.findElement(ship_to_name).sendKeys(shiptoname);
        Thread.sleep(500);
    }

    public void getTrackingNumber(String Trackingnumber) throws InterruptedException {
        driver.findElement(tracking_number).sendKeys(Trackingnumber);
        Thread.sleep(500);
    }

    public void getShipmentProvider() throws InterruptedException {
        driver.findElement(shipment_provider).click();
        Thread.sleep(500);
    }

    public void selectProviderOption(String type) throws InterruptedException {
        switch (type){
            case "USPS":
                driver.findElement(usps_option).click();
                Thread.sleep(500);
                break;
            case "FedEx":
                driver.findElement(fedex_option).click();
                Thread.sleep(500);
                break;
        }
    }

    public void savebutton() throws InterruptedException {
        driver.findElement(savebutton).click();
        Thread.sleep(500);
    }

    public String getnameinformation() {
        return driver.findElement(provider_title_text).getText();
    }

    public String gettrackingtitle(){
        return driver.findElement(provider_title_text).getText();
    }

    public String gettrackingnumber(){
        return driver.findElement(provider_text).getText();
    }
}
