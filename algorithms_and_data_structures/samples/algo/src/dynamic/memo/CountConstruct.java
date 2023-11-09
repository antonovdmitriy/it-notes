package dynamic.memo;

import java.util.HashMap;
import java.util.Map;

public class CountConstruct {


    public static int countConstruct(String target, String[] wordBank) {
        return countConstruct(target, wordBank, new HashMap<>());
    }


    public static int countConstruct(String target, String[] wordBank, Map<String, Integer> memo) {

        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        if (target.isEmpty()) {
            return 1;
        }

        int result = 0;

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                result += countConstruct(suffix, wordBank, memo);
            }
        }

        memo.put(target, result);
        return result;
    }

    public static int countConstructBrut(String target, String[] wordBank) {

        if (target.isEmpty()) {
            return 1;
        }

        int result = 0;

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                result += countConstructBrut(suffix, wordBank);
            }
        }

        return result;
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

        System.out.println(countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"})); // 2
        System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"})); // 1
        System.out.println(countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"})); // 0
        System.out.println(countConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"})); // 4
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"})); // 0
    }
}
