package dynamic.tab;

import java.util.Arrays;

public class HowSum {

    public static int[] howSum(int targetSum, int[] numbers) {

        int[][] tab = new int[targetSum + 1][];
        tab[0] = new int[0];

        for (int i = 0; i < tab.length; i++) {

            int[] currentItem = tab[i];
            if (currentItem != null) {
                for (int number : numbers) {
                    int positionToAdd = i + number;
                    if (positionToAdd < tab.length) {
                        tab[positionToAdd] = addToArray(currentItem, number);
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
        // n =  numbers.length

        System.out.println(Arrays.toString(howSum(7, new int[]{2, 3}))); // [3, 2, 2]
        System.out.println(Arrays.toString(howSum(7, new int[]{5, 3, 4, 7}))); // [4, 3]
        System.out.println(Arrays.toString(howSum(7, new int[]{2, 4}))); // null
        System.out.println(Arrays.toString(howSum(8, new int[]{2, 3, 5}))); // [2,2,2,2]
        System.out.println(Arrays.toString(howSum(300, new int[]{7, 14}))); // null

    }
}
