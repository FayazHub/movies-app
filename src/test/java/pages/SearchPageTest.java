package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPageTest {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL.DESKTOP-SL1EEPE\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech/login");
        driver.findElement(By.id("usernameInput")).sendKeys("rahul");
        driver.findElement(By.id("passwordInput")).sendKeys("rahul@2021");
        driver.findElement(By.className("login-button")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        driver.findElement(By.className("search-empty-button")).click();
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/search"));

        driver.findElement(By.className("search-input-field")).sendKeys("Titanic");
        driver.findElement(By.className("search-button")).click();
        driver.findElement(By.className("search-input-field")).clear();
        driver.findElement(By.className("search-input-field")).sendKeys("Avatar");
        driver.findElement(By.className("search-button")).click();
        List<WebElement> total=driver.findElements(By.className("movie-image"));
        System.out.println(total.size());





    }
}
