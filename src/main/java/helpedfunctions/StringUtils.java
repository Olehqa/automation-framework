package helpedfunctions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class StringUtils {

    private static final Logger logger = LogManager.getLogger(StringUtils.class);

    public static boolean isEmailValid(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        } else if (email.length() > 256) {
            logger.info("The email contains more then 256 characters");
            return false;
        } else if (getEmailDomain(email).length() > 255) {
            logger.info("The email domain contains more then 255 characters");
            return false;
        } else if (getLocalPart(email).length() > 64) {
            logger.info("The email`s local part contains more then 64 characters");
            return false;
        } else if (getLocalPart(email).length() <= 1) {
            logger.info("The email local part contains less then 1 character");
            return false;
        } else if (getEmailDomain(email).substring(getEmailDomain(email).indexOf('.'), email.lastIndexOf(email)).length() > 7) {
            logger.info("The email domain contains more then 7 characters after point");
            return false;
        } else if (!email.contains("@")) {
            logger.info("The email do not contains '@' character");
            return false;
        } else if (getLocalPart(email).indexOf('0') != '.') {
            logger.info("The email start from '.");
            return false;
        } else return email.lastIndexOf(getLocalPart(email)) == '.';
    }

    public static String getLocalPart(String email) {
        return email.substring(0, email.indexOf('@'));
    }

    public static String getEmailDomain(String email) {
        return email.substring(email.lastIndexOf('@') + 1);
    }

    public static void main(String[] args) {
        String email = "contribute@org.";
        if (isEmailValid(email)) {
            System.out.print("Email valid");
        } else {
            System.out.print("Email invalid due to OWASP \n");
        }
    }

}
