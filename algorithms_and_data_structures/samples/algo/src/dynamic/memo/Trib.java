package dynamic.memo;

import java.util.HashMap;
import java.util.Map;

public class Trib {

    public static long fib(long n, Map<Long, Long> memo) {

        if (n == 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        memo.put(n, fib(n - 1, memo) + fib(n - 2, memo) + fib(n - 3));
        return memo.get(n);
    }

    public static long fib(long n) {
        return fib(n, new HashMap<>());
    }

    public static long fibBrut(long n) {

        if (n == 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        if (n <= 2) return 1;
        return fib(n - 1) + fib(n - 2) + fib(n - 3);
    }

    public static void main(String[] args) {
        System.out.println(fib(1));
        System.out.println(fib(8)); // 24
        System.out.println(fib(30)); // 15902591
    }
}
