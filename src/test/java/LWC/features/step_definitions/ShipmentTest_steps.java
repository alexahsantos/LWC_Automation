package LWC.features.step_definitions;

import LWC.base.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import LWC.features.page_objects.ShipmentPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Locale;
import java.util.Objects;


public class ShipmentTest_steps extends BaseUtil {
    private BaseUtil base;

    public ShipmentTest_steps(BaseUtil util) {
        this.base = util;
    }

    WebDriver driver;
    ShipmentPage Shipment_Page;

    public WebDriver webdriver;

    @And("I change the list view")
    public void iChangeTheListView() throws InterruptedException {

        //Confirmation ShipmentPage
        Thread.sleep(1000);
        String ShipmentPageTitle = Shipment_Page.getShipmentTitle();
        Assert.assertTrue(ShipmentPageTitle.contains("Shipments"));

        Shipment_Page.display_list_view();
        String AllShipmentViewTitle = Shipment_Page.get_allshipment_view();
        Assert.assertTrue("Page not found!", AllShipmentViewTitle.contains("All Shipments"));

        Shipment_Page.allview_shipment_option();

    }

    @And("I create a new {string} of shipment")
    public void iCreateANewTypeOfShipment(String arg0) throws InterruptedException {
        Shipment_Page.getNewbutton();

        Thread.sleep(2000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,350)");

        Thread.sleep(5000);

        switch (arg0) {
            case "USPS" -> {
                Shipment_Page.getShipToName("TestUSPS-Automation");
                Shipment_Page.getTrackingNumber("92612927005455000228424508");
                Shipment_Page.getShipmentProvider();
                Shipment_Page.selectProviderOption(arg0);
                Shipment_Page.savebutton();

                Thread.sleep(2000);

                //Confirmation
                String Uspsname = Shipment_Page.getnameinformation();
                Assert.assertTrue("USPS Name not found!", Uspsname.contains("USPS"));
                Thread.sleep(500);

                String UspsTracking = Shipment_Page.gettrackingnumber();
                Assert.assertTrue("Tracking Number not found!", UspsTracking.contains("Tracking Number: 92612927005455000228424508"));
                Thread.sleep(500);
            }

            case "FedEx" -> {
                Shipment_Page.getShipToName("TestFedEx-Automation");
                Shipment_Page.getTrackingNumber("020207021381215");
                Shipment_Page.getShipmentProvider();
                Shipment_Page.selectProviderOption(arg0);
                Shipment_Page.savebutton();

                Thread.sleep(10000);

                //Confirmation
                String FedExname = Shipment_Page.getnameinformation();
                Assert.assertTrue("FedEx Name not found!", FedExname.contains("FedEx"));
                Thread.sleep(500);

                String FedExTracking = Shipment_Page.gettrackingnumber();
                Assert.assertTrue("Tracking Number not found!", FedExTracking.contains("Tracking Number: 020207021381215"));
                Thread.sleep(500);
            }
        }
    }

    @And("I inspect a {string} Shipment Component")
    public void iInspectShipmentComponent(String arg0) throws InterruptedException {
        Thread.sleep(500);
        Shipment_Page.checkfisrtrecord(arg0);
        Thread.sleep(10000);

        switch (arg0) {
            case "USPS" -> {
                String Uspsname = Shipment_Page.getnameinformation();
                Assert.assertTrue("USPS Name not found!", Uspsname.contains("USPS"));

                String UspsTracking = Shipment_Page.gettrackingnumber();
                Assert.assertTrue("Tracking Number not found!", UspsTracking.contains("92612927005455000228424508"));
            }
            case "FedEx" -> {
                String FedExname = Shipment_Page.getnameinformation();
                System.out.println(FedExname);
                Assert.assertTrue("FedEx Name not found!", FedExname.contains("FedEx"));

                String FedExTracking = Shipment_Page.gettrackingnumber();
                System.out.println(FedExTracking);
                Assert.assertTrue("Tracking Number not found!", FedExTracking.contains("Tracking Number: 020207021381215"));
            }
        }

        Shipment_Page.checktrackinginformation();

        String linkHistorialTracking = Shipment_Page.getTrackingHistoryLink();
        Assert.assertTrue("Tracking Historial link not found!", linkHistorialTracking.contains("Show the complete tracking history"));
        Thread.sleep(500);
    }
//    @After()
//    public void quitBrowser() {
//        driver.quit();
//    }
}

