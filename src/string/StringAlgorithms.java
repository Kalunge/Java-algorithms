package string;

public class StringAlgorithms {

    public static boolean isUpperCase(String str) {
        return str.chars().allMatch(Character::isUpperCase);
    }

    public static boolean isLower(String str) {
        return str.chars().allMatch(Character::isLowerCase);
    }

    public static void main(String[] args) {
        System.out.println(isUpperCase("MUTHOMI"));
        System.out.println(isUpperCase("kalunge"));
        System.out.println(isLower("titus"));
    }
}
