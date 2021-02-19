package test;

import org.testng.annotations.Test;

public class TestiTest extends BaseTest {

    @Test(priority = 1, description = "y")
    public void openUrl() {
        driver.get("www.i.ua");
        driver.get("google.com");

    }
}
