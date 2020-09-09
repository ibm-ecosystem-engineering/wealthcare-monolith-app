package com.gan.wcare.common;

public class StringUtil {

    public static String getLastChar(String text, int charCount) {
        String result = "";
        if (text != null && text.length() >= charCount) {
            result = text.substring(text.length() - charCount);
        }
        return result;
    }

    public static void main (String[] chars) {
        System.out.println(getLastChar("", 2));
        System.out.println(getLastChar("a", 2));
        System.out.println(getLastChar("ab", 2));
        System.out.println(getLastChar("abc", 2));
        System.out.println(getLastChar("abcd", 2));
        System.out.println(getLastChar("abcde", 2));
        System.out.println(getLastChar("abcdefghi", 4));
    }

    public static boolean isEqualsIgnoreCase(String text1, String text2) {
        boolean result = false;
        if (text1 == null && text2 == null) {
            result = true;
        } else if (text1 == null || text2 == null ){
            result = false;
        } else if (text1.equalsIgnoreCase(text2)){
            result = true;
        }
        return result;
    }
}
