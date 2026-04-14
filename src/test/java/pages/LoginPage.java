package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

     private WebDriver driver;
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20000));

    public LoginPage(WebDriver Driver)
     {
        driver = Driver;
        PageFactory.initElements(driver, this);
     }

    @FindBy(name="username")
          WebElement txtUsername;

    @FindBy(name="password")
          WebElement txtPassword;

    @FindBy(css="button[type='submit']")
    WebElement btnSubmit;

    @FindBy(css="div[role='alert']")
    WebElement alrt_invalidCredentials;
   

    public void gotoLoginPage() {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait.until(ExpectedConditions.elementToBeClickable(btnSubmit));
    }

        public void Login() {

        txtUsername.sendKeys("Admin");
        txtPassword.sendKeys("admin123");
        btnSubmit.click();
    }

    public void enterUsername()
    {
        txtUsername.sendKeys("Admin");
    }
     public void enterPassword()
    {
         txtPassword.sendKeys("admin123");
    }

    public void enterUsername(String username)
    {
        txtUsername.sendKeys(username);
    }

     public void enterPassword(String password)
    {
         txtPassword.sendKeys(password);
    }

    public void clickLoginButton()
    {
         btnSubmit.click();
    }

    public boolean validateInvalidCredentialsAlrt()
    {
        return alrt_invalidCredentials.isDisplayed();
    }

}
