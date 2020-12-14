package helpedfunctions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static helpedfunctions.StringiusUtils.isEmailValid;

public class StringUtilsMain {
    private static final Logger LOGGER = LogManager.getLogger(StringUtilsMain.class);

    public static void main(String[] args) {
        String email = "contribute@org.goo";

        if (isEmailValid(email)) {
            LOGGER.info("Email valid");
        } else {
            LOGGER.warn("Email invalid due to OWASP \n");
        }
    }
}
