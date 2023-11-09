package dynamic.memo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridTravelerWithWalls {

    public static int countToRightBottomCorner(int startRow, int startColumn, List<List<String>> grid, Map<String, Integer> memo) {
        String preparedMemoKey = "%s,%s".formatted(startRow, startColumn);

        if (memo.containsKey(preparedMemoKey)) {
            return memo.get(preparedMemoKey);
        }


        if (startRow == grid.size() || startColumn == grid.get(0).size()) {
            return 0;
        }

        boolean isItWall = grid.get(startRow).get(startColumn).equals("X");
        if (isItWall) {
            return 0;
        }

        if (startRow == grid.size() - 1 && startColumn == grid.get(0).size() - 1) {
            return 1;
        }

        int result = countToRightBottomCorner(startRow + 1, startColumn, grid, memo) + countToRightBottomCorner(startRow, startColumn + 1, grid, memo);
        memo.put(preparedMemoKey, result);
        return result;
    }

    public static int countToRightBottomCorner(int startRow, int startColumn, List<List<String>> grid) {

        return countToRightBottomCorner(startRow, startColumn, grid, new HashMap<>());
    }

    public static int countToRightBottomCornerBrut(int startRow, int startColumn, List<List<String>> grid) {

        if (startRow == grid.size() || startColumn == grid.get(0).size()) {
            return 0;
        }

        boolean isItWall = grid.get(startRow).get(startColumn).equals("X");
        if (isItWall) {
            return 0;
        }

        if (startRow == grid.size() - 1 && startColumn == grid.get(0).size() - 1) {
            return 1;
        }


        return countToRightBottomCornerBrut(startRow + 1, startColumn, grid) + countToRightBottomCornerBrut(startRow, startColumn + 1, grid);
    }

    public static void main(String[] args) {

        List<List<String>> grid = new ArrayList<>();
        grid.add(List.of("", "", "X"));
        grid.add(List.of("", "", ""));
        grid.add(List.of("", "", ""));

        System.out.println(countToRightBottomCorner(0, 0, grid)); // 5
    }
}
