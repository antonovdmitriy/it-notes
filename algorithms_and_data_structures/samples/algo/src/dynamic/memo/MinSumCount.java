package dynamic.memo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinSumCount {

    public static int minSumCountBrut(int targetSum, int[] numbers) {

        if (targetSum < 0) {
            return -1;
        }

        if (targetSum == 0) {
            return 0;
        }

        int shortestCombination = -1;

        for (int number : numbers) {
            int sum = minSumCountBrut(targetSum - number, numbers);
            if (sum != -1) {
                sum++;
                if (shortestCombination == -1 || shortestCombination > sum) {
                    shortestCombination = sum;
                }
            }
        }

        return shortestCombination;
    }


    public static int minSumCount(int targetSum, int[] numbers, Map<Integer, Integer> memo) {

        if (targetSum < 0) {
            return -1;
        }

        if (targetSum == 0) {
            return 0;
        }


        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }

        int shortestCombination = -1;

        for (int number : numbers) {
            int sum = minSumCount(targetSum - number, numbers, memo);
            if (sum != -1) {
                sum++;
                if (shortestCombination == -1 || shortestCombination > sum) {
                    shortestCombination = sum;
                }
            }
        }

        memo.put(targetSum, shortestCombination);

        return shortestCombination;
    }

    public static int minSumCount(int targetSum, int[] numbers) {
        return minSumCount(targetSum, numbers, new HashMap<>());
    }

    public static void main(String[] args) {

        System.out.println(minSumCount(7, new int[]{7})); // 1
        System.out.println(minSumCount(7, new int[]{5, 3, 4, 7})); // 1
        System.out.println(minSumCount(8, new int[]{2, 3, 5})); // 2
        System.out.println(minSumCount(8, new int[]{1, 4, 5})); // 2
        System.out.println(minSumCount(100, new int[]{1, 2, 5, 25})); // 4

    }
}
