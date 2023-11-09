package dynamic.memo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BestSum {


    public static int[] bestSumBrut(int targetSum, int[] numbers) {

        if (targetSum < 0) {
            return null;
        }

        if (targetSum == 0) {
            return new int[]{};
        }

        int[] shortestCombination = null;

        for (int number : numbers) {
            int[] sum = bestSumBrut(targetSum - number, numbers);
            if (sum != null) {
                int[] resultCombination = addToArray(sum, number);
                if (shortestCombination == null || shortestCombination.length > resultCombination.length) {
                    shortestCombination = resultCombination;
                }
            }
        }

        return shortestCombination;
    }


    public static int[] bestSum(int targetSum, int[] numbers, Map<Integer, int[]> memo) {

        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }

        if (targetSum < 0) {
            return null;
        }

        if (targetSum == 0) {
            return new int[]{};
        }

        int[] shortestCombination = null;

        for (int number : numbers) {
            int[] sum = bestSum(targetSum - number, numbers, memo);
            if (sum != null) {
                int[] resultCombination = addToArray(sum, number);
                if (shortestCombination == null || shortestCombination.length > resultCombination.length) {
                    shortestCombination = resultCombination;
                }
            }
        }

        memo.put(targetSum, shortestCombination);

        return shortestCombination;
    }

    public static int[] bestSum(int targetSum, int[] numbers) {
        return bestSum(targetSum, numbers, new HashMap<>());
    }

    private static int[] addToArray(int[] arrayToAdd, int number) {
        int[] result = Arrays.copyOf(arrayToAdd, arrayToAdd.length + 1);
        result[result.length - 1] = number;
        return result;
    }

    public static void main(String[] args) {


        // m = targetSum
        // n =  numbers.lengh

        // brut
        // time: 0(n ^ m * m)
        // space: 0(m ^ 2)

        // memo
        // time: 0(n * m^2)
        // time 0(m ^ 2)
        System.out.println(Arrays.toString(bestSum(7, new int[]{5, 3, 4, 7}))); // [7]
        System.out.println(Arrays.toString(bestSum(8, new int[]{2, 3, 5}))); // [3,5]
        System.out.println(Arrays.toString(bestSum(8, new int[]{1, 4, 5}))); // [4,4]
        System.out.println(Arrays.toString(bestSum(100, new int[]{1, 2, 5, 25}))); // [25,25,25,25]

    }
}
