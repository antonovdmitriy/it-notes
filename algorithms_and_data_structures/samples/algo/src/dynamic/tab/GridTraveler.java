package dynamic.tab;

public class GridTraveler {

    public static int gridTraveler(int m, int n) {

        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] tab = new int[m + 1][n + 1];
        tab[1][1] = 1;

        for (int i = 0; i <= m; i++) {

            for (int j = 0; j <= n; j++) {

                int currentValue = tab[i][j];
                if (j + 1 <= n) {
                    tab[i][j + 1] += currentValue;
                }
                if (i + 1 <= m) {
                    tab[i + 1][j] += currentValue;
                }
            }
        }

        return tab[m][n];
    }


    public static void main(String[] args) {
        System.out.println(gridTraveler(8, 0)); // 1
        System.out.println(gridTraveler(1, 1)); // 1
        System.out.println(gridTraveler(3, 2)); // 3
        System.out.println(gridTraveler(30, 30)); // 51542064
    }

}
