import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class seleniumTest {
    public static void main(String[] args){
        System.setProperty("webdriver.gecko.driver","D:\\Ethoca\\geckodriver\\geckodriver.exe");

        //STEP 1: Go to http://store.demoqa.com/
        WebDriver driver=new FirefoxDriver();
        driver.get("http://store.demoqa.com/");

        //STEP 2: Go to Product category and select Accessories
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.id("menu-item-33"))).perform();
        driver.findElement(By.id("menu-item-34")).click();

        //STEP 3: Click on “Add to Cart” for just Magic Mouse
        driver.findElements(By.className("wpsc_buy_button")).get(0).click();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

        //STEP 4: Click on “Checkout” and confirm you have 1 Magic Mouse in your Check-Out Page
        WebElement button=driver.findElement(By.className("cart_icon"));
        button.click();

        //Assert.assertEquals("1", driver.findElement(By.name("quantity")).getText());
        //Assert.assertEquals("Magic Mouse", driver.findElement(By.className("wpsc_product_name wpsc_product_name_0")).getText());

        //STEP 5: After confirming, click on Continue
        WebElement continueButton =driver.findElement(By.className("step2"));
        continueButton.click();

        //STEP 6: Enter test (dummy) data needed for email, billing/contact details and click Purchase
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wpsc_checkout_form_9")));
        driver.findElement(By.id("wpsc_checkout_form_9")).sendKeys("123@gmail.com");
        driver.findElement(By.id("wpsc_checkout_form_2")).sendKeys("firstname");
        driver.findElement(By.id("wpsc_checkout_form_3")).sendKeys("lastname");
        driver.findElement(By.id("wpsc_checkout_form_4")).sendKeys("Dummy address");
        driver.findElement(By.id("wpsc_checkout_form_5")).sendKeys("Toronto");
        driver.findElement(By.id("wpsc_checkout_form_6")).sendKeys("ON");
        driver.findElement(By.id("wpsc_checkout_form_18")).sendKeys("647123456");
        WebElement mySelectElement = driver.findElement(By.id("wpsc_checkout_form_7"));
        Select dropdown= new Select(mySelectElement);
        dropdown.selectByVisibleText("Canada");

        driver.findElement(By.className("input-button-buy")).click();






        //WebElement element=driver.findElement(By.xpath("//input[@name='emailid']"));
        //element.sendKeys("abc@gmail.com");
        //WebElement button=driver.findElement(By.xpath("//input[@name='btnLogin']"));
        //button.click();
    }
}
