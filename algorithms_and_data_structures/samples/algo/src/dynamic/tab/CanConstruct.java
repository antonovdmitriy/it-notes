package dynamic.tab;

public class CanConstruct {

    public static boolean canConstruct(String target, String[] wordBank) {

        boolean[] tab = new boolean[target.length() + 1];
        tab[0] = true;

        for (int i = 0; i < tab.length; i++) {
            if (tab[i]) {
                for (String word : wordBank) {
                    if (i + word.length() < tab.length) {
                        String targetOnPosition = target.substring(i, i + word.length());
                        if (targetOnPosition.equals(word)) {
                            tab[i + word.length()] = true;
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


        System.out.println(canConstruct("abc", new String[]{"abc"})); // true
        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"})); // true
        System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"})); // false
        System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"})); // true
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"})); // false
    }
}
