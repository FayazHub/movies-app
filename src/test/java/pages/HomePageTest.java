package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


public class HomePageTest {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL.DESKTOP-SL1EEPE\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");

        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
        driver.findElement(By.className("login-button")).click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        WebElement text=driver.findElement(By.className("movies-list-heading"));
        System.out.println(text.getText());
        if(text.getText().equals("Trending Now")){
            System.out.println("Matched");
        }
        else{
            System.out.println("Not Matched");
        }
        WebElement text2=driver.findElement(By.xpath("//h1[text()=\"Originals\"]"));
        System.out.println(text2.getText());
        if(text2.getText().equals("Originals")){
            System.out.println("Matched");
        }
        else{
            System.out.println("Not Matched");
        }

        WebElement element=driver.findElement(By.className("home-movie-play-button"));
        if(element.isDisplayed()){
            System.out.println("PlayButton is Displayed");
        }
        else{
            System.out.println("Button is not displayed");
        }

        WebElement check=driver.findElement((By.className("home-movie-heading")));
        if(check.isDisplayed()){
            System.out.println("Movies aee dispalye");
        }
        else{
            System.out.println("Movies are not displayed");
        }

        WebElement texting=driver.findElement((By.className("contact-us-paragraph")));
        if(texting.getText().equals("Contact Us")){
            System.out.println("text is correct");
        }
        else{
            System.out.println("text is not correct");
        }
        driver.close();







    }






}
