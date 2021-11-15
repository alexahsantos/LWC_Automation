package LWC.features.step_definitions;

import LWC.base.BaseUtil;
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


public class ShipmentTest_steps extends BaseUtil{
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
        Shipment_Page.personalLogin(username,password);
    }

    @Then("I go to {string} page")
    public void i_go_to_Shipment_page(String component) throws InterruptedException {

        Thread.sleep(2000);
        Shipment_Page = new ShipmentPage(driver);
        JavascriptExecutor executor = (JavascriptExecutor) webdriver;

        //Confirmation Home Page
        String HomePageTitle = Shipment_Page.getConfirmationHomePage();
        Assert.assertTrue(HomePageTitle.contains("Sales"));

        //Search Shipment Launcher
        Shipment_Page.display_app_launcher();
        Shipment_Page.search_shipment_component(component);

        Thread.sleep(500);
        WebElement shipment_component = driver.findElement(By.xpath("(//*[@class=\"al-menu-dropdown-list\"][2]/one-app-launcher-menu-item/a)"));
        executor.executeScript("arguments[0].scrollIntoView()", shipment_component);
        System.out.println("scroll");
        executor.executeScript("arguments[0].click();", shipment_component);
        shipment_component.click();
        Thread.sleep(600);
        System.out.println("clcik");
    }

    @Then("I confirm Shipment Page")
    public void i_confirm_Shipment_Page() throws InterruptedException {

        //Confirmation ShipmentPage
        Thread.sleep(500);
        String ShipmentPageTitle = Shipment_Page.getShipmentTitle();
        Assert.assertTrue(ShipmentPageTitle.contains("Shipments"));
        System.out.println("Shipment Text");

        Shipment_Page.display_list_view();
        Thread.sleep(200);
        String AllShipmentViewTitle = Shipment_Page.get_allshipment_view();
        Assert.assertTrue("Page not found!", AllShipmentViewTitle.contains("All Shipments"));
        System.out.println("List View");

        Shipment_Page.allview_shipment_option();
        Thread.sleep(500);
    }
}
