package dynamic.tab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllConstruct {


    public static List<List<String>> allConstruct(String target, String[] wordBank) {

        List<List<String>>[] tab = new List[target.length() + 1];
        Arrays.fill(tab, List.of());
        tab[0] = List.of(List.of());

        for (int i = 0; i < tab.length; i++) {
            List<List<String>> currentValue = tab[i];

            if (!currentValue.isEmpty()) {

                for (String word : wordBank) {

                    if (i + word.length() < tab.length) {

                        String suffix = target.substring(i, i + word.length());
                        if (suffix.equals(word)) {

                            List<List<String>> newValueAtPosition = new ArrayList<>();
                            newValueAtPosition.addAll(tab[i + word.length()]);
                            newValueAtPosition.addAll(currentValue.stream().map(o -> {
                                List<String> resultWithCurrentWord = new ArrayList<>(o);
                                resultWithCurrentWord.add(word);
                                return resultWithCurrentWord;
                            }).toList());

                            tab[i + word.length()] = newValueAtPosition;
                        }
                    }
                }
            }
        }
        return tab[target.length()];
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
