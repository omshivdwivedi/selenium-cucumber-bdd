package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import base.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberHooks {
    private TestContext testContext;
    private WebDriver driver;

    public CucumberHooks(TestContext context) {
        this.testContext = context;
    }

    @Before
    public void setup(Scenario scenario){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        this.driver=driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20000));
        testContext.setDriver(driver);
        testContext.setScenario(scenario);
        
    }

    @After
    public void teardown(Scenario scenario)
    {
        if(scenario.isFailed()) {
            
            testContext.addScreenshot();
        }

        driver.quit();
    }
    
}
