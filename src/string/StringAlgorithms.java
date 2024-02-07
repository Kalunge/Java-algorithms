package string;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringAlgorithms {

    public static boolean isUpperCase(String str) {
        return str.chars().allMatch(Character::isUpperCase);
    }

    public static boolean isLower(String str) {
        return str.chars().allMatch(Character::isLowerCase);
    }

    public static boolean isPasswordComplex(String str) {
//        .chars method returns a stream of characters
        return str.chars().anyMatch(Character::isUpperCase) && str.chars().anyMatch(Character::isLowerCase) && str.chars().anyMatch(Character::isDigit);
    }

    public static String normalizeString(String str) {
        return str.toLowerCase().trim().replace(",", "");
    }

    public static void parseContents(String str) {
        for (char c : str.toCharArray()) {
            System.out.print(c);
        }

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            System.out.print(c);
        }
    }


    public static boolean isAtEvenIndex(String s, char item) {
        if (s == null || s.isEmpty()) {
            return false;
        }
//        for (int i = 0; i <= s.length() / 2; i = i + 2) {
//            if (s.charAt(i) == item) {
//                return true;
//            }
//        }
//        return false;

        return s.indexOf(item) % 2 == 0;
    }

    public static String reverse(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder reversed = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }
        return reversed.toString();

    }

    public static String reverseTwo(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static String reverseSentence(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        String[] words = sentence.split(" ");

        for (String word : words) {
            result.append(reverse(word));
            result.append(" ");
        }

        result.trimToSize();

        return result.toString();


    }


    public static void main(String[] args) {
        System.out.println(reverseSentence("Ia am ad boy"));

    }
}
