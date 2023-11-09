package dynamic.memo;

import java.util.HashMap;
import java.util.Map;

public class Fib {

    public static long fib(long n, Map<Long, Long> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        if (n == 0) {
            return 0;
        }

        if (n <= 2) return 1;

        memo.put(n, fib(n - 1, memo) + fib(n - 2, memo));
        return memo.get(n);
    }

    public static long fib(long n) {
        return fib(n, new HashMap<>());
    }

    public static long fibBrut(long n) {

        if (n == 0) {
            return 0;
        }

        if (n <= 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(1));
        System.out.println(fib(9)); // 34
        System.out.println(fib(30)); // 832040
    }
}
