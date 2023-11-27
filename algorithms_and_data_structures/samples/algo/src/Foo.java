import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Foo {


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


    private static int[] bestSum(int targetSum, int[] numbers) {
        return bestSum(targetSum, numbers, new HashMap<>());
    }

    private static int[] bestSum(int targetSum, int[] numbers, Map<Integer, int[]> memo) {

        if(memo.containsKey(targetSum)){
            return memo.get(targetSum);
        }

        if (targetSum < 0) {
            return null;
        }

        if (targetSum == 0) {
            return new int[]{};
        }

        int[] bestSum = null;

        for (int number : numbers) {

            int[] sumForNumber = bestSum(targetSum - number, numbers, memo);
            if (sumForNumber != null) {
                int[] possibleBestSum = extendArray(number, sumForNumber);
                if (bestSum == null || bestSum.length > possibleBestSum.length) {
                    bestSum = possibleBestSum;
                }
            }
        }

        memo.put(targetSum, bestSum);

        return bestSum;
    }

    private static int[] extendArray(int number, int[] sumForNumber) {
        int[] result = new int[sumForNumber.length + 1];
        result[0] = number;
        System.arraycopy(sumForNumber, 0, result, 1, sumForNumber.length);
        return result;
    }
}