package com.example.prm_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppTest {
    WebDriver driver;

    @Test
    public void AppiumTestCase() throws MalformedURLException {
//        WebElement LoginButton = driver.findElement(By.id("com.example.prm_project:id/idBtnLogin"));
//        LoginButton.click();
//        Assert.isTrue(true, LoginButton.getText());
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName","android");
        cap.setCapability("deviceName", "01e73a64");
        cap.setCapability("appPackage", "com.oneplus.calculator");
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");
        cap.setCapability("automationName", "UIAutomator2");
        cap.setCapability("ignoreHiddenApiPolicyError" , true);
        cap.setCapability("appWaitForLaunch" , false);
        cap.setCapability("autoGrantPermissions", true);
//        cap.setCapability("app","C:\\Users\\Admin\\AndroidStudioProjects\\PRM_Project\\app\\build\\outputs\\apk\\androidTest\\debug\\app-debug-androidTest.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement firstNum = driver.findElement(By.id("com.oneplus.calculator:id/digit_9"));
        WebElement secondNum = driver.findElement(By.id("com.oneplus.calculator:id/digit_6"));
        WebElement opAdd = driver.findElement(By.id("com.oneplus.calculator:id/op_add"));
        WebElement opEqual = driver.findElement(By.id("com.oneplus.calculator:id/eq"));
        WebElement resNum = driver.findElement(By.id("com.oneplus.calculator:id/result"));

        firstNum.click();
        opAdd.click();
        secondNum.click();
        opEqual.click();

        assertEquals("15", resNum.getText());
    }


}
