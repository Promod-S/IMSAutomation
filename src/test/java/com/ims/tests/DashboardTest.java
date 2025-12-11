package com.ims.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DashboardTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://inventory-ui-virid-theta.vercel.app/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));


        driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();

//        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        String dashboardText= driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).getText();
        Assert.assertEquals(dashboardText, "DASHBOARD");

        String totalItemsText= driver.findElement(By.xpath("//p[text()='Total Items']")).getText();
        Assert.assertEquals(totalItemsText, "Total Items");

        String lowCostText= driver.findElement(By.xpath("//p[text()='Low Stock']")).getText();
        Assert.assertEquals(lowCostText, "Low Stock");
        String categoryText= driver.findElement(By.xpath("//p[text()='Categories']")).getText();
        Assert.assertEquals(categoryText, "Categories");

        driver.quit();


    }


}
