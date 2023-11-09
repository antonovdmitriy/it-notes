package dynamic.memo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllConstruct {


    public static List<List<String>> allConstruct(String target, String[] wordBank, Map<String, List<List<String>>> memo) {

        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        if (target.isEmpty()) {
            return List.of(List.of());
        }

        List<List<String>> result = new ArrayList<>();

        for (String word : wordBank) {
            if (target.startsWith(word)) {

                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allConstruct(suffix, wordBank, memo);

                List<List<String>> suffixWaysWithAddedWord = suffixWays.stream().map(ways -> {
                    List<String> waysWithAddedWord = new ArrayList<>();
                    waysWithAddedWord.add(word);
                    waysWithAddedWord.addAll(ways);
                    return waysWithAddedWord;
                }).toList();

                result.addAll(suffixWaysWithAddedWord);
            }
        }
        memo.put(target, result);
        return result;
    }

    public static List<List<String>> allConstruct(String target, String[] wordBank) {
        return allConstruct(target, wordBank, new HashMap<>());
    }

    public static List<List<String>> allConstructBrut(String target, String[] wordBank) {

        if (target.isEmpty()) {
            return List.of(List.of());
        }

        List<List<String>> result = new ArrayList<>();

        for (String word : wordBank) {
            if (target.startsWith(word)) {

                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allConstructBrut(suffix, wordBank);

                List<List<String>> suffixWaysWithAddedWord = suffixWays.stream().map(ways -> {
                    List<String> waysWithAddedWord = new ArrayList<>();
                    waysWithAddedWord.add(word);
                    waysWithAddedWord.addAll(ways);
                    return waysWithAddedWord;
                }).toList();

                result.addAll(suffixWaysWithAddedWord);
            }
        }
        return result;
    }


    public static void main(String[] args) {

        System.out.println(allConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
        // [
        //  [ "purp", "le" ]
        //  [ "p", "ur", "p", "le" ]
        // ]
        System.out.println(allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"}));
        // [
        //  [ "ab", "cd", "ef" ]
        //  [ "ab", "c", "def" ]
        //  [ "abc", "def" ]
        //  [ "abcd", "ef" ]
        // ]
        System.out.println(allConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"})); // []
        System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeez", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"})); // []
    }
}
