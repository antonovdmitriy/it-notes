package dynamic.tab;

import java.util.HashMap;
import java.util.Map;

public class CountConstruct {


    public static int countConstruct(String target, String[] wordBank) {

        int[] tab = new int[target.length() + 1];
        tab[0] = 1;

        for (int i = 0; i < tab.length; i++) {

            int currentValue = tab[i];
            if (currentValue != 0) {
                for (String word : wordBank) {
                    if (i + word.length() < tab.length) {
                        String currentSuffix = target.substring(i, i + word.length());
                        if (currentSuffix.equals(word)) {
                            tab[i + word.length()] += currentValue;
                        }
                    }
                }
            }
        }
        return tab[target.length()];
    }


    public static void main(String[] args) {

        // m length
        // n wordBank length

        // brut
        // time: 0( n ^ m * m)
        // space: 0 (m ^ 2)

        // memo
        // time: 0( n * m ^ 2)
        // space: 0( m ^ 2)


        System.out.println(countConstruct("purple", new String[]{"purple"})); // 1
        System.out.println(countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"})); // 2
        System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"})); // 1
        System.out.println(countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"})); // 0
        System.out.println(countConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"})); // 4
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"})); // 0
    }
}
