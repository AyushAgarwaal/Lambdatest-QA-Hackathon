package com.lambdatest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HerokuLoginAutomate {

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
        caps.setCapability("build", "Heroku Login Automate");
        caps.setCapability("name", "LambdaTest QA Hackathon");
        caps.setCapability("plugin", "git-testng");
        caps.setCapability("credentials_enable_service","false");
//        caps.setCapability("headless", "true");

        String[] Tags = new String[] { "Feature", "Tag", "Moderate" };
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    @Test
    public void loginTest() throws InterruptedException {
        String spanText;
        System.out.println("Loading Url");
        Thread.sleep(100);
        driver.get("https://the-internet.herokuapp.com/login");

        Thread.sleep(200);

        WebElement element1 = driver.findElementByXPath("//*[@id=\"username\"]");
        element1.click();
        element1.sendKeys("tomsmith");

        Thread.sleep(100);

        WebElement element2 = driver.findElementByXPath("//*[@id=\"password\"]");
        element2.click();
        element2.sendKeys("SuperSecretPassword!");


        WebElement element3 = driver.findElementByXPath("//*[@id=\"login\"]/button");
        element3.click();

//        Thread.sleep(500);
        Status = "passed";
        Thread.sleep(800);

        System.out.println("TestFinished");

    }

    @AfterMethod
    public void tearDown() {
        driver.executeScript("lambda-status=" + Status);
        driver.quit();
    }

}