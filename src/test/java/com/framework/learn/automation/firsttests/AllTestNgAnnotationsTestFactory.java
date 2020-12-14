package com.framework.learn.automation.firsttests;


import org.testng.annotations.Factory;

import static com.framework.learn.automation.BaseTest.LOGGER;

public class AllTestNgAnnotationsTestFactory {

    @Factory
    public Object[] factoryAnnotation() {
        LOGGER.info("_____@Factory___________");
        return new Object[]{
                new AllTestNgAnnotationsTest("___First test run from Factory____"),
                new AllTestNgAnnotationsTest("___Second test run from Factory___"),
                new AllTestNgAnnotationsTest("___Third test run from Factory___")
        };
    }
}
