import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import sun.security.util.Password;

public class TestNG extends Connection {

    WebDriver driver;

    @Test(priority = 1)
    void openBrowser() {
        System.out.println("Browser open successfully");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

    }

    @Test(priority = 2)
    void Register() {
        System.out.println("Register page");
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Twinkle");
        driver.findElement(By.id("LastName")).sendKeys("Patel");
        WebElement Day = driver.findElement(By.name("DateOfBirthDay"));
        WebElement Month = driver.findElement(By.name("DateOfBirthMonth"));
        WebElement Year = driver.findElement(By.name("DateOfBirthYear"));

        selectValueFromDropDown(Day, "25");
        selectValueFromDropDown(Month, "March");
        selectValueFromDropDown(Year, "1987");


        driver.findElement(By.id("Email")).sendKeys("twinklepatel491@gmail.com");
        driver.findElement(By.id("Company")).sendKeys("Appmixo");
        driver.findElement(By.id("Password")).sendKeys("Twinkle123@");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Twinkle123@");
        driver.findElement(By.id("register-button")).click();
    }

    @Test(priority = 3)
    void logIn() {
        System.out.println("Login Page");
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys("twinklepatel491@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Twinkle123@");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();

    }

    @Test(priority = 4)
    void logOut() {
        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();

    }

    @Test(priority = 5)
    void validateHomepage() {
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "nopCommerce demo store";
        if (ActualTitle.equals(ExpectedTitle)) {

            System.out.println("Test is pass");
        } else {
            System.out.println("Test is fail");
        }

    }

    @Test(priority = 6)
    void closeBrowser() {
        driver.close();
    }
}

