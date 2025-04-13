package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HerokuAlertAutomate {

    private RemoteWebDriver driver;
    private String Status = "failed";

    @BeforeMethod
    public void setup(Method m, ITestContext ctx) throws MalformedURLException {
        String username = "agarwalayush647";
        String authkey = "Vx4bdkkrJbVe5cAlptlQEx8cm4C13gbF4Cvq8Dk2TgOgxxhyYC";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "Windows 11");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "latest");
        caps.setCapability("build", "Heroku Alert Automate");
        caps.setCapability("name", "LambdaTest QA Hackathon");
        caps.setCapability("plugin", "git-testng");
        caps.setCapability("credentials_enable_service","false");
//        caps.setCapability("headless", "true");

        String[] Tags = new String[] { "Feature", "Tag", "Moderate" };
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    @Test
    public void alertTest() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        Thread.sleep(200);

        WebElement element1 = driver.findElementByXPath("//*[@id=\"content\"]/div/ul/li[1]/button");
        element1.click();

        Thread.sleep(100);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        Thread.sleep(100);
        alert.accept();

        Thread.sleep(200);

        WebElement element2 = driver.findElementByXPath("//*[@id=\"content\"]/div/ul/li[2]/button");
        element2.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(200);
        alert = driver.switchTo().alert();
        System.out.println("Alert says: " + alert.getText());
        alert.accept();

        Thread.sleep(300);

        WebElement element3 = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button"));
        element3.click();
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        System.out.println("Prompt says: " + alert.getText());
        Thread.sleep(100);
        alert.sendKeys("Hello LambdaTest Team");
        Thread.sleep(300);
        alert.accept();
        Thread.sleep(500);

        Status = "passed";

        System.out.println("TestFinished");

    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}