package stepDefinitions;

import base.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.sql.Timestamp;

public class Hooks extends BaseUtil {
   // WebDriver driver;

    @Before
    public void setUp(Scenario scenario){
        System.out.println(scenario.getName());
        initializeBrowser();

    }
    @AfterStep
    public void captureExceptionImage(Scenario scenario) throws IOException {
        if (scenario.isFailed()){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeMilliseconds = Long.toString(timestamp.getTime());

            byte[] screenshot = ((TakesScreenshot)  driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",timeMilliseconds);
        }
    }
    @After
    public void tearDown(Scenario scenario){
        System.out.println(scenario.getStatus());
    }
}
