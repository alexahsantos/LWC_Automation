package LWC.features.step_definitions;

import LWC.base.BaseUtil;
import LWC.features.page_objects.LimitsMonitorPage;
import LWC.features.page_objects.ShipmentPage;
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

import LWC.features.page_objects.LimitsMonitorPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Locale;
import java.util.Objects;

import io.cucumber.java.en.Then;

public class LimitsMonitor_steps {

    private BaseUtil base;

    public LimitsMonitor_steps(BaseUtil util) {
        this.base = util;
    }

    WebDriver driver;
    LimitsMonitorPage LimitsMonitor_Page;

    public WebDriver webdriver;

    @And("I check it the page Limits Monitor")
    public void iCheckItThePage() throws InterruptedException {
        //Confirmation Home Page
        String HomePageTitle = LimitsMonitor_Page.getTitle();
        Assert.assertTrue(HomePageTitle.contains("Limits Monitor"));
        System.out.println("Title");

        String SubtitlePage = LimitsMonitor_Page.getSubtitle();
        Assert.assertTrue(SubtitlePage.contains("ORG LIMITS MONITOR"));
        System.out.println("Subtitle");

        LimitsMonitor_Page.confirm_elements_on_the_page();
        Thread.sleep(500);
    }
}
