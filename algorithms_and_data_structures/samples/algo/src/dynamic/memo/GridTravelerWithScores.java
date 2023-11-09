package dynamic.memo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridTravelerWithScores {

    public static double findMaxScoresPathBrut(int r, int c, List<List<Integer>> grid) {

        if (r == grid.size() || c == grid.get(0).size()) {
            return Double.NEGATIVE_INFINITY;
        }

        if (r == grid.size() - 1 && c == grid.get(0).size() - 1) {
            return grid.get(r).get(c);
        }

        return grid.get(r).get(c) + Math.max(findMaxScoresPathBrut(r + 1, c, grid), findMaxScoresPathBrut(r, c + 1, grid));
    }

    public static double findMaxScoresPath(int r, int c, List<List<Integer>> grid, Map<List<Integer>, Double> memo) {

        if (r == grid.size() || c == grid.get(0).size()) {
            return Double.NEGATIVE_INFINITY;
        }

        if (r == grid.size() - 1 && c == grid.get(0).size() - 1) {
            return grid.get(r).get(c);
        }

        List<Integer> pos = List.of(r, c);

        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }

        double result = grid.get(r).get(c) + Math.max(findMaxScoresPath(r + 1, c, grid, memo), findMaxScoresPath(r, c + 1, grid, memo));
        memo.put(pos, result);

        return result;
    }


    public static double findMaxScoresPath(int r, int c, List<List<Integer>> grid) {
        return findMaxScoresPath(r, c, grid, new HashMap<>());
    }

    public static void main(String[] args) {
        List<List<Integer>> grid = List.of(
                List.of(1, 2, 1),
                List.of(1, 2, 1),
                List.of(1, 2, 1));

        System.out.println(findMaxScoresPath(0, 0, grid));

    }

}
