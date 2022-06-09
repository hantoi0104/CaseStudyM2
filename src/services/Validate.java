package services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static final String USER_REGEX = "^[a-z0-9]{5,10}";
    private static final String PASS_REGEX = "^[a-zA-Z0-9]{8,10}";
    private static final String PHONE_REGEX = "^[(](\\+84)[)][-][0-9]{9,}$";
    private static final String EMAIL_REGEX = "^[a-z][a-z0-9]{0,9}\\.[a-z0-9]{1,10}@[a-z]+\\.(com|vn)+$";

    private static final String AUTHOR_BOOK = "^[a-zA-Z]{3,}";;
    private static final String ID_BOOK = "[0-9]{1,5}";
    private static final String NAME_BOOK = "^[A-Z]{3,}";
    private static final String TYPE_BOOK = "^[a-zA-Z]{3,20}";
    private static final String QUANTITY_BOOK = "[0-9]{1,3}";
    private static final String YEAR_BOOK = "^[1][0-9]{3}";

    public Validate() {
    }

    public static boolean validateUserName(String regex) {
        Pattern pattern = Pattern.compile(USER_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validatePassword(String regex) {
        Pattern pattern = Pattern.compile(PASS_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateIdBook(String regex) {
        Pattern pattern = Pattern.compile(ID_BOOK);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateNameBook(String regex) {
        Pattern pattern = Pattern.compile(NAME_BOOK);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateAuthorBook(String regex) {
        Pattern pattern = Pattern.compile(AUTHOR_BOOK);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateYearBook(String regex) {
        Pattern pattern = Pattern.compile(YEAR_BOOK);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateTypeBook(String regex) {
        Pattern pattern = Pattern.compile(TYPE_BOOK);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateEmail(String regex) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateQuantityBook(String regex) {
        Pattern pattern = Pattern.compile(QUANTITY_BOOK);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}