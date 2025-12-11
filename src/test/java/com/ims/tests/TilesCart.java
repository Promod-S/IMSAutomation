package com.ims.tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static dev.failsafe.internal.util.Assert.*;

public class TilesCart {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://inventory-ui-virid-theta.vercel.app/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[contains(text(),'Add Item')]")).click();
//                Thread.sleep(3000);

////        WebElement category;
        driver.findElement(By.xpath("//input[contains(@name,'name')]")).sendKeys("Red Tiles");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver1 -> driver1.findElement(By.xpath("//div[@role='combobox']")));
////
        WebElement dropDown= driver.findElement(By.xpath("//div[@role='combobox']"));
        dropDown.click();
        wait.until(driver1 -> driver1.findElement(By.xpath("//li[text()='Tiles']")));
        driver.findElement(By.xpath("//li[text()='Tiles']")).click();

        driver.findElement(By.xpath("//input[@name='purchasePrice']")).sendKeys("100");
        driver.findElement(By.xpath("//input[@name='sellingPrice']")).sendKeys("150");
        driver.findElement(By.xpath("//input[@name='stock']")).sendKeys("200");
        driver.findElement(By.xpath("//button[text()='Add Product']")).click();

        Thread.sleep(5000);

        Alert alert = driver.switchTo().alert();
        String alertMessage= driver.switchTo().alert().getText();
        System.out.println("Alert message: " + alertMessage);
        alert.accept();


        Assert.assertEquals(alertMessage, "Item added successfully");

        driver.quit();





    }

}


