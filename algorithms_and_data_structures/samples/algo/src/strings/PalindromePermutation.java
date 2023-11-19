package strings;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

    // Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or
    // phrase that is the same forwards and backwards. A permutation is rearrangement of letters. The palindrome
    // does not need to be limited to just dictionary words.

    // A string can form a palindrome if at most one character occurs odd number of times
    // and all other characters occur even number of times
    public static boolean isPermutationPalindrome(String phrase) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        int countOdd = 0;

        // Normalize the string: convert to lowercase and ignore non-letter characters
        for (char c : phrase.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);

                // If the count of the character is odd, increment countOdd, else decrement
                if (charCountMap.get(c) % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }

        // For a string to be a permutation of a palindrome, countOdd should be 0 or 1
        return countOdd <= 1;
    }


    public static void main(String[] args) {
        PalindromePermutation main = new PalindromePermutation();
        System.out.println(main.isPermutationPalindrome(""));
        System.out.println(main.isPermutationPalindrome("aaff"));
        System.out.println(main.isPermutationPalindrome("a"));
        System.out.println(main.isPermutationPalindrome("faf"));
        System.out.println(main.isPermutationPalindrome("fafa"));
        System.out.println(main.isPermutationPalindrome("bcded"));
        System.out.println(main.isPermutationPalindrome("aff"));
        System.out.println(main.isPermutationPalindrome("f af"));
        System.out.println(main.isPermutationPalindrome("fa a&*&*f"));
    }
}
