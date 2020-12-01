package com.framework.learn.automation.firsttests;


import com.framework.learn.automation.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
//    @BeforeTest // done in test
//
////    The annotated method will be run before any test method belonging to the classes inside the <test> tag is run.
//
//    @AfterTest // done in test
//
////    The annotated method will be run after all the test methods belonging to the classes inside the <test> tag have run.
//
//    @BeforeGroups
//
////    The list of groups that this configuration method will run before. This method is guaranteed to run shortly before the first test method that belongs to any of these groups is invoked.
//
//    @AfterGroups // done in test
//
////    The list of groups that this configuration method will run after. This method is guaranteed to run shortly after the last test method that belongs to any of these groups is invoked.
//
//    @BeforeMethod //done in test
//
////    The annotated method will be run before each test method.
//
//    @AfterMethod // done in test
//
////    The annotated method will be run after each test method.
//
//    @DataProvider // done in test

//    Marks a method as supplying data for a test method. The annotated method must return an Object[ ][ ], where each Object[ ] can be assigned the parameter list of the test method. The @Test method that wants to receive data from this DataProvider needs to use a dataProvider name equals to the name of this annotation.

//    @Factory

//    Marks a method as a factory that returns objects that will be used by TestNG as Test classes. The method must return Object[ ].

//    @Parameters

//    Describes how to pass parameters to a @Test method.

    private String delete = "//button[@class='added-manually']";
    private static final Logger LOGGER = LogManager.getLogger(AllTestNgAnnotationsTest.class);
    private String header = "//h3[contains(text(),'Add/Remove Elements')]";
    private String addElement = "//button[contains(text(),'Add Element')]";
    private String baseUrl = "http://the-internet.herokuapp.com/add_remove_elements/";

    @BeforeTest(description = "Open url")
    public void openUrl() {
        LOGGER.info(" ______@BeforeTest______");
    }

    @BeforeGroups(description = "group of tests", groups = "group")
    public void beforeGroupOfTests() {
        LOGGER.info(" ______@BeforeGroup______");
    }

    @Test(description = "First Test", priority = 1, groups = "group", dataProvider = "Buttons")
    public void testForAllAnnotations(String element) {
        LOGGER.info(" ______@Test______");
        driver.get(baseUrl);

        driver.findElement(By.xpath(addElement)).click();
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(delete)))).isDisplayed();
        driver.findElement(By.xpath(delete)).click();
        boolean isPresent = driver.findElements(By.xpath(delete)).size() > 0;
        assertFalse(isPresent);
        driver.findElement(By.xpath(element)).click();
    }

    @AfterGroups(description = "after group of tests", groups = "group")
    public void beforeGroupRun() {
        LOGGER.info(" ______@AfterGroup______");
    }

    @DataProvider(name = "Buttons")
    public Iterator<Object[]> buttonProvider() {
        LOGGER.info(" ______@DataProvider______");

        List<Object[]> provider = new ArrayList<>();
        provider.add(new Object[]{delete});
        provider.add(new Object[]{addElement});
        return provider.iterator();
    }

    @BeforeMethod(description = "before each test method")
    public void beforeMethods() {
        LOGGER.info(" ______@BeforeMethod______");

    }

    @AfterMethod(description = "Delete all the elements")
    public void deleteElements() {
        LOGGER.info(" ______@AfterMethod______");
        if (driver.findElement(By.xpath(delete)).isDisplayed()) {
            driver.findElement(By.xpath(delete)).click();
        }
    }
}
