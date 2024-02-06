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

    public static void main(String[] args) {
//        System.out.println(isUpperCase("MUTHOMI"));
//        System.out.println(isUpperCase("kalunge"));
//        System.out.println(isLower("titus"));
//        System.out.println(isPasswordComplex("Muthomiz2"));
//        System.out.println(isPasswordComplex("Muthomiz"));
        System.out.println(normalizeString(" Hello There BUDDY , "));
    }
}
