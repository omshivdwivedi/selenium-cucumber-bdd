package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

public class TestContext {
    private WebDriver driver;
    private Scenario scenario;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

     public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void addScreenshot(String name) {
        if (driver != null && scenario != null) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", name);
        }
    }

    public void addScreenshot(){
        this.addScreenshot("");
    }

    public void addText(String txt){
        scenario.attach(txt,"text/plain","Log");

    }

    public void log(String message) {
        
        scenario.log("INFO: " + message);
    }

}

