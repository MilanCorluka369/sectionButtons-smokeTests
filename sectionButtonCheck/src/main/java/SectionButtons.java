import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SectionButtons {
    private WebDriver driver;
    private WebDriverWait driverWait;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "G:\\Dev & QA\\IT Bootcamp\\Materijal\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.manage().window().maximize();
        driver.navigate().to("https://www.telerik.com/support/demos");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void desktopSectionButtonCheck(){
        WebElement desktopElement = driver.findElement
                (By.xpath("//*[@id='ContentPlaceholder1_T53129E6C012_Col00']/nav/div/div[2]/a[2]"));
        desktopElement.click();
        driverWait.until(ExpectedConditions.attributeContains(desktopElement, "class", "is-active"));
        String actualResult = desktopElement.getAttribute("class");
        String expectedResult = "NavAlt-anchor u-b0 is-active";

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void mobileSectionButtonCheck(){
        WebElement mobileElement = driver.findElement
                (By.xpath("//*[@id='ContentPlaceholder1_T53129E6C012_Col00']/nav/div/div[2]/a[3]"));
        mobileElement.click();
        driverWait.until(ExpectedConditions.attributeContains(mobileElement, "class", "is-active"));
        String actualResult = mobileElement.getAttribute("class");
        String expectedResult = "NavAlt-anchor u-b0 is-active";

        Assert.assertEquals(actualResult, expectedResult);
    }

    @AfterClass
    public void afterClass() { driver.close(); }
}
