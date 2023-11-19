package dynamic.memo;

import java.util.HashMap;
import java.util.Map;

public class Palidrome {

    public static boolean isPalidndrome(String s) {

        for (int i = 0, j = s.length() - 1; i < s.length() && j >= 0; i++, j--) {

            if (s.length() % 2 != 0 && i == j) {
                return true;
            }

            if (s.length() % 2 == 0 && i >= s.length() / 2) {
                return true;
            }

            char left = s.charAt(i);
            char right = s.charAt(j);
            if (left != right) {
                return false;
            }
        }

        return false;
    }

    public static String longestPalindrome(String s) {

        if (s.isEmpty() || s.length() == 1 || isPalidndrome(s)) {
            return s;
        }

        Map<String, Boolean> memo = new HashMap<>();
        String longest = "";

        for (int i = 0; i < s.length(); i++) {

            String suffix = s.substring(i);
            for (int j = suffix.length(); j >= 0; j--) {
                String currentSuffix = suffix.substring(0, j);

                boolean isPalidrome;
                if (memo.containsKey(currentSuffix)) {
                    isPalidrome = memo.get(currentSuffix);
                } else {
                    isPalidrome = isPalidndrome(currentSuffix);
                    memo.put(currentSuffix, isPalidrome);
                }

                if (isPalidrome && (longest.isEmpty() || currentSuffix.length() > longest.length())) {
                    longest = currentSuffix;
                }
            }
        }
        return longest;
    }


    public static void main(String[] args) {

        System.out.println(isPalidndrome("abbaa"));

//
//        System.out.println(longestPalindrome("abba"));
//        System.out.println(longestPalindrome("bab"));
//        System.out.println(longestPalindrome("abcdb"));
//
//        System.out.println(longestPalindrome("babad")); // "bab"
//
//        System.out.println(longestPalindrome("cbbd")); // "bab"
    }
}
