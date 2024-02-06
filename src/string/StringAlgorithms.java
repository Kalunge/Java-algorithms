package string;

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


    public static void main(String[] args) {
        System.out.println(isAtEvenIndex("makena", 'e'));
    }
}
