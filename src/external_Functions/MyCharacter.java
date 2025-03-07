package external_Functions;

public class MyCharacter {

    public static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static boolean isAlphabetic(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }

    public static boolean isUpperCase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    public static boolean isLowerCase(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    public static boolean isLetterOrDigit(char ch) {
        return isDigit(ch) || isAlphabetic(ch);
    }

}
