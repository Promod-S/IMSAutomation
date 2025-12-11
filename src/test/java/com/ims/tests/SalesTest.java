package com.ims.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class SalesTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://inventory-ui-virid-theta.vercel.app/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//a[text()='Sales']")).click();

        String salesText= driver.findElement(By.xpath("//a[text()='Sales']")).getText();
        Assert.assertEquals(salesText, "SALES");
        System.out.println(salesText);

        String billingText= driver.findElement(By.xpath("//h2[contains(text(),'Billing')]")).getText();
        Assert.assertEquals(billingText,"Multi-Product Sales / Billing");
        System.out.println(billingText);

        driver.findElement(By.xpath("//div[text()='Select Product']")).click();
        driver.findElement(By.xpath("//li[text()='Select Product']/following-sibling::li[1]")).click();
        driver.findElement(By.xpath("//span[text()='Qty']/parent::legend/parent::fieldset/preceding-sibling::input")).sendKeys("1");

//        driver.findElement(By.id("_r_2l_")).sendKeys("1");
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        Thread.sleep(3000);

        String productText= driver.findElement(By.xpath("//th[text()='Product']")).getText();
        Assert.assertEquals(productText, "Product");

        driver.findElement(By.xpath("//button[text()='Complete Sale']")).click();

        Thread.sleep(3000);
        String billText= driver.findElement(By.xpath("//h3[text()='Bill / Receipt']")).getText();
        Assert.assertEquals(billText, "Bill / Receipt");

        driver.quit();


    }
}
