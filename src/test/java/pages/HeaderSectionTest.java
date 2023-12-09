package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HeaderSectionTest {
    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL.DESKTOP-SL1EEPE\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");

    }
    @AfterMethod
    public void setDown(){
        driver.close();
    }
    @Test(priority = 1)
    public void CheckingHeaderSectionUI(){
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
        driver.findElement(By.className("login-button")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        WebElement display=driver.findElement(By.className("website-logo"));
        if(display.isDisplayed()){
            System.out.println("MovieLogo is displayed");
        }
        else{
            System.out.println("MovieLogo is not displayed");
        }


        WebElement hometext=driver.findElement(By.xpath("//a[text()='Home']"));
        String expect= hometext.getText();
        String current="Home";
        Assert.assertEquals(expect,current,"Nav element is checked");
        WebElement popultext=driver.findElement(By.xpath("//a[text()='Popular']"));
        String expected= popultext.getText();
        String currenttext="Popular";
        Assert.assertEquals(expected,currenttext,"Nav element is not checked");








    }
    @Test(priority = 2)
    public void CheckingHeaderSection(){
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
        driver.findElement(By.className("login-button")).click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        driver.findElement(By.linkText("Popular")).click();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/popular"));
        driver.findElement(By.linkText("Home"));


    }










}
