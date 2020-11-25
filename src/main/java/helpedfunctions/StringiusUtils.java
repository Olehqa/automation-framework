package helpedfunctions;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringiusUtils {
    private static final Logger LOGGER = LogManager.getLogger(StringiusUtils.class);
    private static final int MAX_DOMAIN_LENGTH = 256;
    private static final int MAX_LOCAL_LENGTH = 64;
    private static final int MAX_DOMAIN_LENGTH_FROM_POINT = 7;

    static boolean isEmailValid(String email) {
        return isEmailIsNotStartsFromDot(email) && isEmailDomainLengthValid(email)
                && isEmailDomainFromDotLengthValid(email) && isEmailLastCharValid(email) && isEmailLengthValid(email)
                && isEmailLocalPartLengthValid(email);
    }

    private static String getLocalPart(String email) {
        if (!isEmailContainEt(email)) {
            return null;
        }
        return email.substring(0, email.indexOf('@'));
    }

    private static String getEmailDomain(String email) {
        if (!isEmailContainEt(email)) {
            return null;
        }
        return email.substring(email.lastIndexOf('@') + 1);
    }

    private static boolean isEmailDomainContainsPoint(String email) {
        if (!getEmailDomain(email).contains(".")) {
            LOGGER.warn("The domain do not contains '.' character");
            return false;
        }
        return true;
    }

    private static String getEmailDomainFromPoint(String email) {
        if (isEmailEmpty(email) && !isEmailDomainContainsPoint(email)) {
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

    private static boolean isEmailContainEt(String email) {
        if (isEmailEmpty(email)) {
            return false;
        } else if (!email.contains("@")) {
            LOGGER.warn("The email do not contains '@' character");
            return false;
        }
        return true;
    }

    private static boolean isEmailIsNotStartsFromDot(String email) {
        if (isEmailEmpty(email)) {
            return false;
        } else if (email.indexOf(0) == '.') {
            LOGGER.warn("The email start from '.");
            return false;
        }
        return true;
    }

    private static boolean isEmailLengthValid(String email) {
        if (isEmailEmpty(email)) {
            return false;
        } else if (email.length() > MAX_DOMAIN_LENGTH) {
            LOGGER.warn("The email contains more then 256 characters");
            return false;
        }
        return true;
    }

    private static boolean isEmailDomainLengthValid(String email) {
        if (isEmailEmpty(email)) {
            return false;
        } else if (getEmailDomain(email).length() > MAX_DOMAIN_LENGTH - 1) {
            LOGGER.warn("The email domain contains more then 255 characters");
            return false;
        }
        return true;
    }

    private static boolean isEmailLocalPartLengthValid(String email) {
        if (isEmailEmpty(email)) {
            return false;
        } else if (getLocalPart(email).length() > MAX_LOCAL_LENGTH) {
            LOGGER.warn("The email`s local part contains more then 64 characters");
            return false;
        } else if (getLocalPart(email).length() <= 1) {
            LOGGER.info("The email local part contains less then 1 character");
            return false;
        }
        return true;
    }

    private static boolean isEmailDomainFromDotLengthValid(String email) {
        if (isEmailEmpty(email)) {
            return false;
        } else if (getEmailDomainFromPoint(email).length() > MAX_DOMAIN_LENGTH_FROM_POINT) {
            LOGGER.warn("The email domain contains more then 7 characters after dot");
            return false;
        }
        return true;
    }

    private static boolean isEmailLastCharValid(String email) {
        if (isEmailEmpty(email)) {
            return false;
        } else if (email.charAt(email.length() - 1) == '.') {
            LOGGER.warn("The email`s last char is '.'");
            return false;
        }
        return true;
    }


}
