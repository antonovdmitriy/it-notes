package dynamic.memo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOfUniqueCombinationCoins {

    public static int countingChangeBrut(int targetSum, int[] coins) {
        return countingChangeBrut(targetSum, 0, coins);
    }

    public static int countingChangeBrut(int targetSum, int coinIndex, int[] coins) {

        if (targetSum == 0) {
            return 1;
        }

        if (coinIndex >= coins.length) {
            return 0;
        }

        int value = coins[coinIndex];

        int totalWays = 0;
        for (int qty = 0; qty * value <= targetSum; qty++) {
            int subSum = targetSum - (qty * value);
            totalWays += countingChangeBrut(subSum, coinIndex + 1, coins);
        }
        return totalWays;
    }


    public static int countingChange(int targetSum, int[] coins) {
        return countingChange(targetSum, 0, coins, new HashMap<>());
    }

    public static int countingChange(int targetSum, int coinIndex, int[] coins, Map<List<Integer>, Integer> memo) {

        if (targetSum == 0) {
            return 1;
        }

        if (coinIndex >= coins.length) {
            return 0;
        }

        List<Integer> key = List.of(targetSum, coinIndex);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int value = coins[coinIndex];

        int totalWays = 0;
        for (int qty = 0; qty * value <= targetSum; qty++) {
            int subSum = targetSum - (qty * value);
            totalWays += countingChange(subSum, coinIndex + 1, coins, memo);
        }

        memo.put(key, totalWays);

        return totalWays;
    }

    public static void main(String[] args) {

        System.out.println(countingChangeBrut(4, new int[]{1, 2, 3})); // 4
        System.out.println(countingChangeBrut(8, new int[]{1, 2, 3})); // 10
        System.out.println(countingChangeBrut(24, new int[]{5, 7, 3})); // 5
        System.out.println(countingChangeBrut(13, new int[]{2, 6, 12, 10})); // 0
        System.out.println(countingChangeBrut(512, new int[]{1, 5, 10, 25})); // 20119
        System.out.println(countingChangeBrut(1000, new int[]{1, 5, 10, 25})); // 142511
        System.out.println(countingChangeBrut(240, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})); // 1525987916
    }
}
