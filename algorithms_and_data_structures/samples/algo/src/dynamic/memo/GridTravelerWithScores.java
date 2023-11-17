package dynamic.memo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridTravelerWithScores {

    public static double findMaxScoresPathBrut(int r, int c, Integer[][] grid) {

        if (r == grid.length || c == grid[0].length) {
            return Double.NEGATIVE_INFINITY;
        }

        if (r == grid.length - 1 && c == grid[0].length - 1) {
            return grid[r][c];
        }

        return grid[r][c] + Math.max(findMaxScoresPathBrut(r + 1, c, grid), findMaxScoresPathBrut(r, c + 1, grid));
    }

    public static double findMaxScoresPath(int r, int c, Integer[][] grid, Map<List<Integer>, Double> memo) {

        if (r == grid.length || c == grid[0].length) {
            return Double.NEGATIVE_INFINITY;
        }

        if (r == grid.length - 1 && c == grid[0].length - 1) {
            return grid[r][c];
        }

        List<Integer> pos = List.of(r, c);

        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }

        double result = grid[r][c] + Math.max(findMaxScoresPath(r + 1, c, grid, memo), findMaxScoresPath(r, c + 1, grid, memo));
        memo.put(pos, result);

        return result;
    }


    public static double findMaxScoresPath(int r, int c, Integer[][] grid) {
        return findMaxScoresPath(r, c, grid, new HashMap<>());
    }

    public static void main(String[] args) {
        Integer[][] grid = {
                {1, 2, 1},
                {1, 2, 1},
                {1, 2, 1}
        };
        System.out.println(findMaxScoresPath(0, 0, grid));

    }

}
