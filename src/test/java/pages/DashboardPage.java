package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

     private WebDriver driver;

     public DashboardPage(WebDriver Driver){
        driver = Driver;
        PageFactory.initElements(driver, this);
     }

     @FindBy(xpath="//h6[normalize-space()=\"Dashboard\"]")
     WebElement header_Dashboard;

     @FindBy(css=".oxd-userdropdown-tab")
     WebElement drp_usrDropdown;

      @FindBy(linkText ="Logout")
     WebElement lnk_Logout;

     public boolean validateHeader()
     {
        return header_Dashboard.isDisplayed();
     }

     public void click_usrDropdown()
     {
         drp_usrDropdown.click();
     }

     public void click_LogoutLink()
     {
        lnk_Logout.click();
     }
}
