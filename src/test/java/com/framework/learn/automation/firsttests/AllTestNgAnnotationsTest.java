package com.framework.learn.automation.firsttests;


import com.framework.learn.automation.BaseTest;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @BeforeSuite // done in base test
 * The annotated method will be run only once before all tests in this suite have run.
 * @AfterSuite // done in base test
 * The annotated method will be run only once after all tests in this suite have run.
 * @BeforeClass //done in base test
 * The annotated method will be run only once before the first test method in the current class is invoked.
 * @AfterClass // done in base test
 * The annotated method will be run only once after all the test methods in the current class have run.
 * @BeforeTest // done in test
 * The annotated method will be run before any test method belonging to the classes inside the <test> tag is run.
 * @AfterTest // done in test
 * The annotated method will be run after all the test methods belonging to the classes inside the <test> tag have run.
 * @BeforeGroups The list of groups that this configuration method will run before. This method is guaranteed to run shortly before the first test method that belongs to any of these groups is invoked.
 * @AfterGroups // done in test
 * The list of groups that this configuration method will run after. This method is guaranteed to run shortly after the last test method that belongs to any of these groups is invoked.
 * @BeforeMethod //done in test
 * The annotated method will be run before each test method.
 * @AfterMethod // done in test
 * The annotated method will be run after each test method.
 * @DataProvider // done in test
 * Marks a method as supplying data for a test method. The annotated method must return an Object[ ][ ], where each Object[ ] can be assigned the parameter list of the test method. The @Test method that wants to receive data from this DataProvider needs to use a dataProvider name equals to the name of this annotation.
 * @Factory //done in factory
 * Marks a method as a factory that returns objects that will be used by TestNG as Test classes. The method must return Object[ ].
 * @Parameters /done in Suite.xml
 * Describes how to pass parameters to a @Test method.
 */

public class AllTestNgAnnotationsTest extends BaseTest {

    private String newMessage = "";

    public AllTestNgAnnotationsTest(String newMessage) {
        this.newMessage = newMessage;
    }

    @BeforeTest(description = "Open url")
    public void openUrl() {
        LOGGER.info(newMessage);
        LOGGER.info(" ______@BeforeTest______");
    }

    @BeforeGroups(description = "group of tests", groups = "group")
    public void beforeGroupOfTests() {
        LOGGER.info(newMessage);
        LOGGER.info(" ______@BeforeGroup______");
    }

    @Test(description = "First Test", priority = 1, groups = "group", dataProvider = "Buttons")
    public void testForAllAnnotations(String element) {
        LOGGER.info(newMessage);
        LOGGER.info(element);
    }

    @Test(description = "Second test", priority = 2, dependsOnMethods = "testForAllAnnotations", dataProvider = "secondDataProvider")
    public void secondTest(String name, Integer number, Integer secondNumber) {
        LOGGER.info(newMessage);
        LOGGER.info(name + number.toString() + secondNumber.toString());
    }

    @Parameters({"parameterFromXml"})
    @Test(description = "Third Test", priority = 3, dependsOnGroups = "group")
    public void testForAllAnnotationsWithParameters(@Optional("optionalParameter") String parameterFromXml) {
        LOGGER.info(newMessage);
        LOGGER.info(parameterFromXml);
    }

    @AfterGroups(description = "after group of tests", groups = "group")
    public void beforeGroupRun() {
        LOGGER.info(newMessage);
        LOGGER.info(" ______@AfterGroup______");
    }

    @DataProvider(name = "Buttons")
    public Iterator<Object[]> buttonProvider() {
        LOGGER.info(newMessage);
        LOGGER.info(" ______@DataProvider______");

        List<Object[]> provider = new ArrayList<>();
        provider.add(new Object[]{"______@First Test from Data provider______"});
        provider.add(new Object[]{"______@Second Test from Data provider______"});
        return provider.iterator();
    }

    @DataProvider(name = "secondDataProvider")
    public Object[][] secondProvider() {
        return new Object[][]{
                {"firstString", 36, 11},
                {"secondString", 35, 12},
                {"thirdString", 34, 13},
        };
    }


    @BeforeMethod(description = "before each test method")
    public void beforeMethods() {
        LOGGER.info(newMessage);
        LOGGER.info(" ______@BeforeMethod______");

    }

    @AfterMethod(description = "Delete all the elements")
    public void deleteElements() {
        LOGGER.info(newMessage);
        LOGGER.info(" ______@AfterMethod______");
    }

    @AfterTest(description = "After tests")
    public void afterTest() {
        LOGGER.info(newMessage);
        LOGGER.info("_____@AfterTest___________");
    }
}
