package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;

import base.TestContext;
import pages.LoginPage;
import utils.DataReader;

public class LoginSteps {
    
    TestContext testContext;
    private LoginPage lp;
    String TestDataPath = System.getProperty("user.dir")+"/src/test/resources/testData/";
     List<HashMap<String, String>> datamap;

    public LoginSteps(TestContext context)
    {
        lp = new LoginPage(context.getDriver());
        testContext = context;
    }

    @Given("user navigates to login page")
    public void user_navigate_to_login_page() 
    {
        lp.gotoLoginPage();
        testContext.addScreenshot();
    }
    
    @When("user fill login details and click submit button")
    public void user_fill_login_details_and_click_submit_button()
    {
        lp.enterUsername();
        lp.enterPassword();
        testContext.addScreenshot();
        lp.clickLoginButton();
    }

    @When("user enter email and password with excel row {string}")
    public void user_enter_email_and_password_with_excel_row (String rows)
    {
        try {
            datamap=DataReader.data(TestDataPath+"Invalid_Login_Test_Data.xlsx", "Sheet1");
            
        } catch (IOException e) {
           e.printStackTrace();
            testContext.log(e.getMessage());
        }

        int index=Integer.parseInt(rows)-1;

         String username= datamap.get(index).get("Username");
         String password = datamap.get(index).get("Password");

         lp.enterUsername(username);
         lp.enterPassword(password);
         testContext.addScreenshot();
    }

    @When("user click on login button")
    public void user_click_on_login_button()
    {
        lp.clickLoginButton();
    }

    @Then("validate the Error Message")
    public void validate_the_Error_Message()
    {
        boolean flag = lp.validateInvalidCredentialsAlrt();
        testContext.addScreenshot();
        Assert.assertEquals(true,flag);
    }


}
