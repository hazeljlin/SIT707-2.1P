package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class SeleniumClean {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void officeworks_registration_page(String url) {
        System.out.println("✅ Running CLEAN Officeworks version");

        System.setProperty("webdriver.chrome.driver", "/Users/jxl/desktop/2025T1/SIT707/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();
        sleep(2);

        driver.get(url);

        driver.findElement(By.id("firstname")).sendKeys("Ahsan");
        driver.findElement(By.id("lastname")).sendKeys("Habib");
        driver.findElement(By.id("phoneNumber")).sendKeys("0412345678");
        driver.findElement(By.id("email")).sendKeys("ahsan@example.com");
        driver.findElement(By.id("password")).sendKeys("123");

        try {
            WebElement createBtn = driver.findElement(By.xpath("//button[contains(text(), 'Create account')]"));
            createBtn.click();
        } catch (Exception e) {
            System.out.println("Create button not found: " + e.getMessage());
        }

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("officeworks_screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        sleep(2);
        driver.quit();
    }
    public static void second_registration_page(String url) {
        System.setProperty("webdriver.chrome.driver", "/Users/jxl/desktop/2025T1/SIT707/chromedriver-mac-arm64/chromedriver");

        System.out.println("✅ Running second registration site - Guru99");

        WebDriver driver = new ChromeDriver();
        sleep(2);

        driver.get(url);

        // Fill in the form fields
        driver.findElement(By.name("firstName")).sendKeys("Hazel");
        driver.findElement(By.name("lastName")).sendKeys("Lee");
        driver.findElement(By.name("phone")).sendKeys("0412345678");
        driver.findElement(By.name("userName")).sendKeys("hazel@example.com");
        driver.findElement(By.name("address1")).sendKeys("123 Test Street");
        driver.findElement(By.name("city")).sendKeys("Melbourne");
        driver.findElement(By.name("state")).sendKeys("VIC");
        driver.findElement(By.name("postalCode")).sendKeys("3000");
        driver.findElement(By.name("email")).sendKeys("hazel123");
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.name("confirmPassword")).sendKeys("123");

        // Click submit
        try {
            driver.findElement(By.name("submit")).click();
            System.out.println("Submitted registration form.");
        } catch (Exception e) {
            System.out.println("Submit button not found: " + e.getMessage());
        }

        // Take screenshot after submission
        sleep(3);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("second_screenshot.png"));
            System.out.println("✅ Guru99 screenshot saved.");
        } catch (IOException e) {
            System.out.println("❌ Screenshot failed: " + e.getMessage());
        }

        sleep(2);
        driver.quit();
    }
}
