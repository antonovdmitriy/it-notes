package dynamic.tab;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BestSum {

    public static int[] bestSum(int targetSum, int[] numbers) {

        int[][] tab = new int[targetSum + 1][];
        tab[0] = new int[0];

        for (int i = 0; i < tab.length; i++) {
            int[] currentItem = tab[i];
            if (currentItem != null) {

                for (int number : numbers) {
                    int positionToAdd = i + number;
                    if (positionToAdd < tab.length) {
                        int[] candidate = addToArray(currentItem, number);
                        int[] valueOnPosition = tab[positionToAdd];
                        if (valueOnPosition == null || candidate.length < valueOnPosition.length) {
                            tab[positionToAdd] = candidate;
                        }
                    }
                }
            }
        }

        return tab[targetSum];
    }

    private static int[] addToArray(int[] arrayToAdd, int number) {
        int[] result = Arrays.copyOf(arrayToAdd, arrayToAdd.length + 1);
        result[result.length - 1] = number;
        return result;
    }

    public static void main(String[] args) {

        // m = targetSum
        // n =  numbers.lengh

        System.out.println(Arrays.toString(bestSum(7, new int[]{5, 3, 4, 7}))); // [7]
        System.out.println(Arrays.toString(bestSum(8, new int[]{2, 3, 5}))); // [3,5]
        System.out.println(Arrays.toString(bestSum(8, new int[]{1, 4, 5}))); // [4,4]
        System.out.println(Arrays.toString(bestSum(100, new int[]{1, 2, 5, 25}))); // [25,25,25,25]

    }
}
