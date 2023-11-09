package dynamic.memo;

import java.util.HashMap;
import java.util.Map;

public class GridTraveler {

    public static int gridTraveler(int m, int n, Map<String, Integer> memo) {
        String preparedMemoKey = "%s,%s".formatted(m, n);
        if (memo.containsKey(preparedMemoKey)) {
            return memo.get(preparedMemoKey);
        }
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }

        memo.put(preparedMemoKey, gridTraveler(m - 1, n, memo) + gridTraveler(m, n - 1, memo));
        return memo.get(preparedMemoKey);
    }

    public static int gridTraveler(int m, int n) {

        return gridTraveler(m, n, new HashMap<>());
    }

    public static int gridTravelerBrut(int m, int n) {

        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }
        return gridTravelerBrut(m - 1, n) + gridTravelerBrut(m, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(gridTraveler(8, 0)); // 1
        System.out.println(gridTraveler(1, 1)); // 1
        System.out.println(gridTraveler(3, 2)); // 3
        System.out.println(gridTraveler(30, 30)); // 51542064
    }
}
