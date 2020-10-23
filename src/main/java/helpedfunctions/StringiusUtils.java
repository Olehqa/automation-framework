package helpedfunctions;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringiusUtils {
    private static final Logger LOGGER = LogManager.getLogger(StringiusUtils.class);

    public static boolean isEmailValid(String email) {
        return !isEmailEmpty(email) && isEmailContainEt(email) && isEmailIsNotStartsFromDot(email) && isEmailDomainLengthValid(email)
                && isEmailDomainFromDotLengthValid(email) && isEmailLastCharValid(email) && isEmailLengthValid(email)
                && isEmailLocalPartLengthValid(email);
    }

    private static String getLocalPart(String email) {
        if (isEmailEmpty(email)) {
            return null;
        }
        return email.substring(0, email.indexOf('@'));
    }

    private static String getEmailDomain(String email) {
        if (isEmailEmpty(email)) {
            return null;
        }
        return email.substring(email.lastIndexOf('@') + 1);
    }

    private static String getEmailDomainFromPoint(String email) {
        if (isEmailEmpty(email)) {
            return null;
        }
        return email.substring(email.indexOf(".") + 1);
    }

    public static boolean isEmailEmpty(String email) {
        if (email == null || email.isEmpty()) {
            LOGGER.warn("Email is empty");
            return true;
        }
        return false;
    }

    public static boolean isEmailContainEt(String email) {
        if (isEmailEmpty(email)) {
            return false;
        } else if (!email.contains("@")) {
            LOGGER.warn("The email do not contains '@' character");
            return false;
        }
        return true;
    }

    public static boolean isEmailIsNotStartsFromDot(String email) {
        if (isEmailEmpty(email)) {
            return false;
        } else if (email.indexOf(0) == '.') {
            LOGGER.warn("The email start from '.");
            return false;
        }
        return true;
    }

    public static boolean isEmailLengthValid(String email) {
        if (isEmailEmpty(email)) {
            return false;
        } else if (email.length() > 256) {
            LOGGER.warn("The email contains more then 256 characters");
            return false;
        }
        return true;
    }

    public static boolean isEmailDomainLengthValid(String email) {
        if (isEmailEmpty(email)) {
            return false;
        } else if (getEmailDomain(email).length() > 255) {
            LOGGER.warn("The email domain contains more then 255 characters");
            return false;
        }
        return true;
    }

    public static boolean isEmailLocalPartLengthValid(String email) {
        if (isEmailEmpty(email)) {
            return false;
        } else if (getLocalPart(email).length() > 64) {
            LOGGER.warn("The email`s local part contains more then 64 characters");
            return false;
        } else if (getLocalPart(email).length() <= 1) {
            LOGGER.info("The email local part contains less then 1 character");
            return false;
        }
        return true;
    }

    public static boolean isEmailDomainFromDotLengthValid(String email) {
        if (isEmailEmpty(email)) {
            return false;
        } else if (getEmailDomainFromPoint(email).length() > 7) {
            LOGGER.warn("The email domain contains more then 7 characters after dot");
            return false;
        }
        return true;
    }

    public static boolean isEmailLastCharValid(String email) {
        if (isEmailEmpty(email)) {
            return false;
        } else if (email.charAt(email.length() - 1) == '.') {
            LOGGER.warn("The email`s last char is '.'");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String email = "contribute@org.goo";
        if (isEmailValid(email)) {
            LOGGER.info("Email valid");
        } else {
            LOGGER.warn("Email invalid due to OWASP \n");
        }
    }
}
