package dynamic.memo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HowSum {

    public static int[] howSumBrut(int targetSum, int[] numbers) {

        if (targetSum < 0) {
            return null;
        }

        if (targetSum == 0) {
            return new int[]{};
        }

        for (int number : numbers) {
            int[] sum = howSumBrut(targetSum - number, numbers);
            if (sum != null) {
                return addToArray(sum, number);
            }
        }

        return null;
    }


    public static int[] howSum(int targetSum, int[] numbers, Map<Integer, int[]> memo) {

        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }

        if (targetSum < 0) {
            return null;
        }

        if (targetSum == 0) {
            return new int[]{};
        }

        for (int number : numbers) {
            int[] sum = howSum(targetSum - number, numbers, memo);
            if (sum != null) {
                int[] result = addToArray(sum, number);
                memo.put(targetSum, result);
                return result;
            }
        }

        memo.put(targetSum, null);
        return null;
    }

    public static int[] howSum(int targetSum, int[] numbers) {
        return howSum(targetSum, numbers, new HashMap<>());
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
        // space: 0(m)

        // memo
        // time: 0(n * m^2)
        // time 0(m ^ 2)
        System.out.println(Arrays.toString(howSum(7, new int[]{2, 3}))); // [3, 2, 2]
        System.out.println(Arrays.toString(howSum(7, new int[]{5, 3, 4, 7}))); // [4, 3]
        System.out.println(Arrays.toString(howSum(7, new int[]{2, 4}))); // null
        System.out.println(Arrays.toString(howSum(8, new int[]{2, 3, 5}))); // [2,2,2,2]
        System.out.println(Arrays.toString(howSum(300, new int[]{7, 14}))); // null

    }
}
