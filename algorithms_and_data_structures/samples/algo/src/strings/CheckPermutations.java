package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckPermutations {

    // Given two strings, write a method to decide if one is permutation of other.

    // O(nlogn)
    public boolean isPermutationSort(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        if(s1.length() == 0) return true;

        char arr1[] = s1.toCharArray();
        char arr2[] = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int i=0; i<arr1.length; i++) {
            if(arr1[i] != arr2[i]) return false;
        }

        return true;
    }

    // O(n)
    public boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.length() == 0) return true;

        Map<Character, Integer> map = new HashMap<>();
        int len = s1.length();

        for (int i = 0; i < len; i++) {
            char c = s1.charAt(i);
            if (map.get(c) != null)
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        for (int i = 0; i < len; i++) {
            char c = s2.charAt(i);
            if (map.get(c) == null || map.get(c) == 0)
                return false;
            map.put(c, map.get(c) - 1);
        }

        return true;

    }

    public static void main(String[] args) {
        CheckPermutations main = new CheckPermutations();
        System.out.println(main.isPermutation("", ""));
        System.out.println(main.isPermutation("a", "b"));
        System.out.println(main.isPermutation("aaa", "b"));
        System.out.println(main.isPermutation("abab", "babb"));
        System.out.println(main.isPermutation("abab", "baba"));
    }

}
