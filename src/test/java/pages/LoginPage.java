package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPage {

        public WebDriver driver;
        @BeforeMethod
        public void setUp () {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL.DESKTOP-SL1EEPE\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://qamoviesapp.ccbp.tech");

        }
        @AfterMethod
        public void setDown(){
            driver.close();
        }

        @Test(priority = 1)
    public void CheckingLogosandNames() {
            WebElement element = driver.findElement(By.className("login-website-logo"));
            if (element.isDisplayed()) {
                System.out.println("Logo is displayed");

            } else {
                System.out.println("Logo is not displayed");
            }
            WebElement currenttext = driver.findElement(By.className("sign-in-heading"));
            String expextedtext = "Login";
            if (currenttext.getText().equals(expextedtext)) {
                System.out.println("Text is correct");

            } else {
                System.out.println("Text is wrong");
            }
            WebElement currenttext1 = driver.findElement(By.xpath("//label[text()=\"USERNAME\"]"));
            if (currenttext1.getText().equals("USERNAME")) {
                System.out.println("usernametext is correct");
            } else {
                System.out.println("usernametext is wrong");
            }
            WebElement currentyext2 = driver.findElement(By.xpath("//label[text()=\"PASSWORD\"]"));
            String text = currentyext2.getText();
            String expected = "PASSWORD";
            Assert.assertEquals(expected, text);


            WebElement currenttext2 = driver.findElement(By.className("login-button"));
            String text1 = currenttext2.getText();
            String expected1 = "Login";
            Assert.assertEquals(text1,expected1);


        }
        @Test(priority = 2)
    public void LoginwithEmptyFields(){
            driver.findElement(By.id("usernameInput")).sendKeys("");
            driver.findElement(By.id("passwordInput")).sendKeys("");
            driver.findElement(By.className("login-button")).click();
        }
        @Test(priority = 3)
    public void LoginwithEmptyUsername(){
            driver.findElement(By.id("usernameInput")).sendKeys("");
            driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
            driver.findElement(By.className("login-button")).click();

        }
        @Test(priority = 4)
    public void LoginwithEmptyPassword(){
            driver.findElement(By.id("usernameInput")).sendKeys("rahul");
            driver.findElement(By.id("passwordInput")).sendKeys("");
            driver.findElement(By.className("login-button")).click();


        }
        @Test(priority = 5)
    public void LoginwithInvalidCredentioals(){
            driver.findElement(By.id("usernameInput")).sendKeys("rah");
            driver.findElement(By.id("passwordInput")).sendKeys("rahul@20");
            driver.findElement(By.className("login-button")).click();

        }
        @Test(priority = 6)
    public void LoginwithValidCredentioals(){
            driver.findElement(By.id("usernameInput")).sendKeys("rahul");
            driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
            driver.findElement(By.className("login-button")).click();

        }




















}
