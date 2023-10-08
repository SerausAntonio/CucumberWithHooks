package stepDefinitions;

import base.BaseUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;


import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

public class LoginSteps extends BaseUtil {

    @Given("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        driver.navigate().to("https://admin-demo.nopcommerce.com/login");
    }

    @And("I enter the credentials as follows")
    public void iEnterTheCredentialsAsFollows(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class,String.class);
        String email = data.get(0).get("username");
        String password = data.get(0).get("password");
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);

    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        driver.findElement(By.xpath("//*[text()='Log in']")).click();
    }

    @Then("I should see the userform page")
    public void iShouldSeeTheUserformPage() {
        boolean status = driver.findElement(By.xpath("//*[@class='content-header']/h1")).isDisplayed();
        Assert.assertTrue(status);
    }

}
