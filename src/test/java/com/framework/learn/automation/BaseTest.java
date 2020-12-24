package com.framework.learn.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public static final Logger LOGGER = LogManager.getLogger(BaseTest.class);

    private String newMessage = "";

    @BeforeSuite(description = "Clean up")
    public void cleanCookie() {
        LOGGER.info(newMessage);
        LOGGER.info(" ______@BeforeSuite______");
    }

    @BeforeClass(description = "set ub driver")
    public void setUp() {
        LOGGER.info(newMessage);
        LOGGER.info(" ______@BeforeClass______");
    }

    @AfterClass(description = "After class")
    public void tearDown() {
        LOGGER.info(newMessage);
        LOGGER.info(" ______@AfterClass______");
    }

    @AfterSuite(description = "Clean up", enabled = true)
    public void cleanCookieAfter() {
        LOGGER.info(newMessage);
        LOGGER.info(" ______@AfterSuite______");
    }

}

