package com.aramework.learn.automation.firsttests;


import com.aramework.learn.automation.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class AllTestNgAnnotationsTest extends BaseTest {


//    @BeforeSuite // done in base test
//
//    The annotated method will be run only once before all tests in this suite have run.
//
//    @AfterSuite // done in base test
//
//    The annotated method will be run only once after all tests in this suite have run.
//
//    @BeforeClass //done in base test
//
//    The annotated method will be run only once before the first test method in the current class is invoked.
//
//    @AfterClass // done in base test
//
//    The annotated method will be run only once after all the test methods in the current class have run.
//
//    @BeforeTest
//
////    The annotated method will be run before any test method belonging to the classes inside the <test> tag is run.
//
//    @AfterTest
//
////    The annotated method will be run after all the test methods belonging to the classes inside the <test> tag have run.
//
//    @BeforeGroups
//
////    The list of groups that this configuration method will run before. This method is guaranteed to run shortly before the first test method that belongs to any of these groups is invoked.
//
//    @AfterGroups
//
////    The list of groups that this configuration method will run after. This method is guaranteed to run shortly after the last test method that belongs to any of these groups is invoked.
//
//    @BeforeMethod
//
////    The annotated method will be run before each test method.
//
//    @AfterMethod
//
////    The annotated method will be run after each test method.
//
//    @DataProvider

//    Marks a method as supplying data for a test method. The annotated method must return an Object[ ][ ], where each Object[ ] can be assigned the parameter list of the test method. The @Test method that wants to receive data from this DataProvider needs to use a dataProvider name equals to the name of this annotation.

//    @Factory

//    Marks a method as a factory that returns objects that will be used by TestNG as Test classes. The method must return Object[ ].

//    @Listeners

//    Defines listeners on a test class.

//    @Parameters

//    Describes how to pass parameters to a @Test method.

    private WebDriverWait wait = new WebDriverWait(driver, 5);
    private String addElement = "//button[contains(text(),'Add Element')]";
    private String delete = "//button[@class='added-manually']";
    private String header = "//h3[contains(text(),'Add/Remove Elements')]";

    @BeforeTest(description = "Open url")
    public void openUrl() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @BeforeGroups(description = "group of tests", groups = "group1")
    public void beforeGroupOfTests() {
        boolean isHeaderPresent = driver.findElements(By.xpath(header)).isEmpty();
        assertFalse(!isHeaderPresent);
    }

    @Test(description = "First Test", dependsOnGroups = "group1")
    public void testForAllAnnotations() {

        driver.findElement(By.xpath(addElement)).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(delete)))).isDisplayed();
        driver.findElement(By.xpath(delete)).click();
        boolean isPresent = driver.findElements(By.xpath(delete)).size() > 0;
        assertFalse(isPresent);
    }

    @AfterTest(description = "Delete all the elements")
    public void deleteElements() {
        if (driver.findElement(By.xpath(delete)).isDisplayed()) {
            driver.findElement(By.xpath(delete)).click();
        }
    }


}
