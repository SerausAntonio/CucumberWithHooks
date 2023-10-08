package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseUtil {
    public static WebDriver driver;

    public WebDriver initializeBrowser(){
        driver = new ChromeDriver();
        return driver;
    }
    public void closeBrowser(){
        driver.quit();
    }
}
