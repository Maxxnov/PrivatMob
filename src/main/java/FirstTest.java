import org.asynchttpclient.util.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {


    @Test
    public void firstTest() {

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        By phone = By.xpath("//input[@data-qa-node='phone-number']");
        By sum = By.xpath("//input[@data-qa-node='amount']");
        By card = By.xpath("//input[@data-qa-node='numberdebitSource']");
        By data = By.xpath("//input[@data-qa-node='expiredebitSource']");
        By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
        By name = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
        By lastname = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
        By submit = By.xpath("//button[@data-qa-node='submit']");
        By terms = By.xpath("//a[starts-with(@href, 'https://privatbank.ua/terms')]");
        By expected = By.xpath("//button[@data-qa-node='details']");


        driver.get("https://next.privat24.ua/mobile");

        driver.findElement(phone).sendKeys("675655290");
        driver.findElement(sum).sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
        driver.findElement(sum).sendKeys("5");
        driver.findElement(card).sendKeys("4004159115449003");
        driver.findElement(data).sendKeys("1223");
        driver.findElement(cvv).sendKeys("111");
        driver.findElement(name).sendKeys("Jon");
        driver.findElement(lastname).sendKeys("Testovich");
        driver.findElement(terms).click();
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Умови та правила"));
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
        driver.findElement(submit).click();




    }

}