package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class GoogleSearchSteps {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();  // Ensures the chromedriver is available
        driver = new ChromeDriver();              // Initializes the ChromeDriver
        driver.manage().window().maximize();      // Maximize the window
    }

    @Given("I navigate to {string}")
    public void i_navigate_to(String url) {
        driver.get(url);  // Opens the URL
    }

    @When("I search for {string}")
    public void i_search_for(String query) {
        driver.findElement(By.name("q")).sendKeys(query);  // Locate the search bar and enter the query
        driver.findElement(By.name("q")).submit();         // Submit the search form
    }

    @Then("I should see search results")
    public void i_should_see_search_results() {
        boolean resultsDisplayed = driver.findElement(By.id("search")).isDisplayed();  // Verify search results are displayed
        assert(resultsDisplayed);
    }
}
