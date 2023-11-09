package dynamic.memo;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {

    public static boolean canConstructBrut(String target, String[] wordBank) {

        if (target.isEmpty()) {
            return true;
        }

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                if (canConstructBrut(suffix, wordBank)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean canConstruct(String target, String[] wordBank) {
        return canConstruct(target, wordBank, new HashMap<>());
    }


    public static boolean canConstruct(String target, String[] wordBank, Map<String, Boolean> memo) {

        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        if (target.isEmpty()) {
            return true;
        }

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String suffix = target.substring(word.length());
                if (canConstruct(suffix, wordBank, memo)) {
                    memo.put(target, true);
                    return true;
                }
            }
        }

        memo.put(target, false);
        return false;
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

        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"})); // true
        System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"})); // false
        System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"})); // true
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"})); // false
    }
}
