package LWC.features.step_definitions;

import LWC.features.page_objects.GeneralPage;
import LWC.features.page_objects.LimitsMonitorPage;
import LWC.features.page_objects.ShipmentPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class General_steps {

    WebDriver driver;
    GeneralPage General_Page;

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
        General_Page = new GeneralPage(driver);
        General_Page.personalLogin(username, password);
    }

    @Then("I go to {string} page")
    public void i_go_to_component_page(String arg0) throws InterruptedException {

        Thread.sleep(10000);
        General_Page = new GeneralPage(driver);

        //Confirmation Home Page
        String HomePageTitle = General_Page.getConfirmationHomePage();
        Assert.assertTrue(HomePageTitle.contains("Sales"));

        //Search Shipment Launcher
        Thread.sleep(10000);
        General_Page.display_app_launcher();
        Thread.sleep(1000);

        General_Page.search_component(arg0);
    }
}
