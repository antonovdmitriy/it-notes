package strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Unique {

    // Implement and algorithm to determine if a string has all unique characters.
    // What if you cannot use additional data structures?

    // O(nlogn)
    public boolean isUniqueSorting(String s) {
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        for(int i=1; i<s.length(); i++) {
            if(arr[i-1] == arr[i]) return false;
        }

        return true;
    }

    // O(n)
    public boolean isUnique(String s) {
        Set<Character> set = new HashSet<>();
        for(char c: s.toCharArray()){
            set.add(c);
        }

        return (s.length() == set.size());
    }


    public static void main(String[] args) {
        Unique main = new Unique();
        System.out.println(main.isUnique(""));
        System.out.println(main.isUnique("a"));
        System.out.println(main.isUnique("aba"));
    }
}