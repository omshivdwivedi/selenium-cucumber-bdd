package steps;

import org.junit.Assert;

import base.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;

public class DashboardSteps {

    TestContext testContext;
    private DashboardPage dp;

    public DashboardSteps(TestContext context)
    {
        dp = new DashboardPage(context.getDriver());
        testContext = context;
    }
    
    @Then("user land on Dashboard page")
    public void user_land_on_Dashboard_page() 
    {
        boolean flag = dp.validateHeader();
        Assert.assertTrue(flag);
        testContext.log("DashBoard Page Displayed");
    }

    @When("user click on user dropdown")
    public void user_click_on_user_dropdown()
    {
        dp.click_usrDropdown();
        testContext.addScreenshot();
    }

    @Then("user click on logout link")
    public void user_click_on_logout_Link()
    {
        dp.click_LogoutLink();
    }
}
