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

    @Before()
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/alexandrasantos/Downloads/Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("I am on Salesforce page")
    public void i_am_on_Salesforce_page() {
        driver.get("https://oktana-be-dev-ed.my.salesforce.com");
    }

    @When("I enter valid credentials {string} and {string}")
    public void i_enter_valid_credentials(String username, String password) throws InterruptedException {
        Shipment_Page = new ShipmentPage(driver);
        Shipment_Page.personalLogin(username, password);
    }

    @Then("I go to {string} page")
    public void i_go_to_Shipment_page(String arg0) throws InterruptedException {

        Thread.sleep(10000);
        Shipment_Page = new ShipmentPage(driver);

        //Confirmation Home Page
        String HomePageTitle = Shipment_Page.getConfirmationHomePage();
        Assert.assertTrue(HomePageTitle.contains("Sales"));

        //Search Shipment Launcher
        Thread.sleep(10000);
        Shipment_Page.display_app_launcher();
        Thread.sleep(1000);
        Shipment_Page.search_shipment_component(arg0);
    }

    @And("I confirm Shipment Page")
    public void i_confirm_Shipment_Page() throws InterruptedException {

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
                Shipment_Page.getShipToName("TestUSPS");
                Shipment_Page.getTrackingNumber("92612927005455000228424508");
                Shipment_Page.getShipmentProvider();
                Shipment_Page.selectProviderOption(arg0);
                Shipment_Page.savebutton();

                Thread.sleep(2000);

                //Confirmation
                String Uspsname = Shipment_Page.getnameinformation();
                Assert.assertTrue("USPS Name not found!", Uspsname.contains("USPS"));
                Thread.sleep(500);

                String UspsTrackingTitle = Shipment_Page.gettrackingtitle();
                Assert.assertTrue("Tracking Title not found!", UspsTrackingTitle.contains("Tracking Number:  "));
                Thread.sleep(500);

                String UspsTracking = Shipment_Page.gettrackingnumber();
                Assert.assertTrue("Tracking Number not found!", UspsTracking.contains("92612927005455000228424508"));
                Thread.sleep(500);
            }

            case "FedEx" -> {
                Shipment_Page.getShipToName("TestFedEx");
                Shipment_Page.getTrackingNumber("020207021381215");
                Shipment_Page.getShipmentProvider();
                Shipment_Page.selectProviderOption(arg0);
                Shipment_Page.savebutton();

                Thread.sleep(10000);

                //Confirmation
                String FedExname = Shipment_Page.getnameinformation();
                System.out.println(FedExname);
                Assert.assertTrue("FedEx Name not found!", FedExname.contains("FedEx"));
                Thread.sleep(500);

//                String FedExTrackingTitle = Shipment_Page.gettrackingtitle();
//                Assert.assertTrue("Tracking Title not found!", FedExTrackingTitle.contains("Tracking Number:  "));
//                Thread.sleep(500);

                String FedExTracking = Shipment_Page.gettrackingnumber();
                System.out.println(FedExTracking);
                Assert.assertTrue("Tracking Number not found!", FedExTracking.contains("Tracking Number: 020207021381215"));
                Thread.sleep(500);
                System.out.println("Finish");
            }
        }
    }

    @After()
    public void quitBrowser() {
        driver.quit();
    }
}

