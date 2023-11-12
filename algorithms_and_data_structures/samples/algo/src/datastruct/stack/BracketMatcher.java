package datastruct.stack;

import java.util.LinkedList;

public class BracketMatcher {

    private static LinkedList<Integer> memo = new LinkedList<>();


    private static int match(String input) {

        for (char c : input.toCharArray()) {

            if (c == ')') {
                if (memo.isEmpty()) {
                    return 0;
                } else {
                    memo.pop();
                }
            }

            if (c == '(') {
                memo.push(1);
            }
        }

        return memo.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(match("(hello)"));
        System.out.println(match("(()hello)"));
        System.out.println(match("()hello)"));

    }

}
