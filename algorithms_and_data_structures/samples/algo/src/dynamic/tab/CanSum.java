package dynamic.tab;

public class CanSum {

    public static boolean canSum(int targetSum, int[] numbers) {

        boolean[] tab = new boolean[targetSum + 1];
        tab[0] = true;

        for (int i = 0; i < tab.length; i++) {

            if (tab[i]) {
                for (int number : numbers) {
                    int positionToTrue = i + number;
                    if (positionToTrue < tab.length) {
                        tab[positionToTrue] = true;
                    }
                }
            }
        }


        return tab[targetSum];
    }

    public static void main(String[] args) {

        // m = targetSum
        // n = numbers.length

        // TIME 0 (nm)
        // SPACE 0(m)

        System.out.println(canSum(0, new int[]{2, 3})); // true
        System.out.println(canSum(7, new int[]{5, 3, 4, 7})); // true
        System.out.println(canSum(7, new int[]{2, 4})); // false
        System.out.println(canSum(8, new int[]{2, 3, 5})); // true
        System.out.println(canSum(300, new int[]{7, 14})); // false

    }

}
