package LWC.features.page_objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class ShipmentPage {
    WebDriver driver;
//    WebDriverWait wait = new WebDriverWait(driver, 30);

    By titleText_shipment = By.xpath("(//*[@class=\"slds-var-p-right_x-small\"])");
    By shipment_listview = By.xpath("(//*[@title=\"Select List View\"])");
    By allshipment_view = By.xpath("(//*[@class=\"slds-dropdown__list slds-show\"]/li[2]/a/span)");
    By all_shipment_link = By.xpath("(//*[@class=\"slds-dropdown__list slds-show\"]/li[2]/a)");
    By new_button = By.xpath("(//*[@class=\"forceActionLink\"])");
    By ship_to_name = By.xpath("(//*[@class=\" input\"])[1]");
    By tracking_number = By.xpath("(//*[@class=\" input\"])[2]");
    By shipment_provider = By.xpath("(//a[@class=\"select\"])[1]");
    By usps_option = By.xpath("(//*[@class=\"select-options\"]/ul/li[4])");
    By fedex_option = By.xpath("(//*[@class=\"select-options\"]/ul/li[2])");
    By savebutton = By.xpath("(//button[@title=\"Save\"])");


    By provider_title_text = By.xpath("(//*[@class=\"package-title slds-col\"])");
    By provider_text = By.xpath("(//*[@class=\"package-subtitle slds-col\"])");
    By tracking_map = By.xpath("(//*[@class=\"map-container\"])");
    By refresh_icon = By.xpath("(//*[@class=\"refresh-icon-container slds-col slds-size_1-of-12\"])");
    By current_location_section = By.xpath("(//*[@class=\"tile-container slds-grid status-selected\"])[1]");

    By shiptoname_text = By.xpath("(//*[@class= \"slds-truncate uiOutputText\"])[4]");
    By provider_text_select = By.xpath("(//*[@class= \"slds-truncate\"])[29]");
    By first_record_usps = By.xpath("(//*[@class=\"slds-cell-edit lockTrigger cellContainer\"]/span/a)[4]");

    By current_icon_location = By.xpath("(//*[@class= \"icon-current-marker\"])");
    By source_location_section = By.xpath("(//*[@class=\"tile-container slds-grid\"])[1]");
    By source_location_icon = By.xpath("(//*[@class=\"icon-marker\"])[2]");
    By destination_location_section = By.xpath("(//*[@class=\"tile-container slds-grid\"])[2]");
    By destination_location_icon = By.xpath("(//*[@class=\"icon-marker\"])[3]");
    By link_historial = By.xpath("(//*[@class=\"show-historial\"])");


    public ShipmentPage(WebDriver driver) {
        this.driver = driver;
    }

    //Shipment
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

    public String gettrackingnumber(){
        return driver.findElement(provider_text).getText();
    }

    public void checkfisrtrecord(String type) throws InterruptedException {
        switch (type){
            case "USPS" -> {
                if ((Objects.equals(driver.findElement(shiptoname_text).getText(), "TestUSPS")) && (Objects.equals(driver.findElement(provider_text_select).getText(), "USPS"))) {
                    driver.findElement(first_record_usps).click();
                    Thread.sleep(500);
                } else {
                    System.out.println("Element not found");
                }
            }
            case "FedEx" -> {
                if ((Objects.equals(driver.findElement(shiptoname_text).getText(), "TestFedEx")) && (Objects.equals(driver.findElement(provider_text_select).getText(), "FedEx"))) {
                    driver.findElement(fedex_option).click();
                    Thread.sleep(500);
                } else {
                    System.out.println("Element not found");
                }
            }
        }
    }
    public void checktrackinginformation() throws InterruptedException {
        Assert.assertTrue(driver.findElement(refresh_icon).isDisplayed());
        Assert.assertTrue(driver.findElement(tracking_map).isDisplayed());
        Assert.assertTrue(driver.findElement(current_location_section).isDisplayed());
        Assert.assertTrue(driver.findElement(current_icon_location).isDisplayed());
        Assert.assertTrue(driver.findElement(source_location_section).isDisplayed());
        Assert.assertTrue(driver.findElement(source_location_icon).isDisplayed());
        Assert.assertTrue(driver.findElement(destination_location_section).isDisplayed());
        Assert.assertTrue(driver.findElement(destination_location_icon).isDisplayed());
    }

    public String getTrackingHistoryLink(){
        return driver.findElement(link_historial).getText();
    }
}
