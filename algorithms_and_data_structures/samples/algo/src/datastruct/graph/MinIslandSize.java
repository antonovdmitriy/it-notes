package datastruct.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinIslandSize {

    private record Position(int r, int c) {
    }

    public static int minIslandSize(List<List<Character>> graph) {

        Set<Position> visited = new HashSet<>();

        int minSize = Integer.MAX_VALUE;

        for (int r = 0; r < graph.size(); r++) {

            for (int c = 0; c < graph.get(0).size(); c++) {

                int currentIsland = explore(graph, r, c, visited);
                if (currentIsland > 0 && currentIsland < minSize) {
                    minSize = currentIsland;
                }
            }
        }

        return minSize;
    }

    private static int explore(List<List<Character>> graph, int r, int c, Set<Position> visited) {

        if (r < 0 || r >= graph.size() || c < 0 || c >= graph.get(0).size()) {
            return 0;
        }

        if (graph.get(r).get(c).equals('W')) {
            return 0;
        }

        Position currentPosition = new Position(r, c);
        if (visited.contains(currentPosition)) {
            return 0;
        }

        visited.add(currentPosition);

        return 1
                + explore(graph, r - 1, c, visited)
                + explore(graph, r + 1, c, visited)
                + explore(graph, r, c - 1, visited)
                + explore(graph, r, c + 1, visited);
    }

    public static void main(String[] args) {

        List<List<Character>> graph = List.of(
                List.of('W', 'L', 'W', 'W', 'W'),
                List.of('W', 'L', 'W', 'W', 'W'),
                List.of('W', 'W', 'W', 'L', 'W'),
                List.of('W', 'W', 'L', 'L', 'W'),
                List.of('L', 'W', 'W', 'L', 'L'),
                List.of('L', 'L', 'W', 'W', 'W')
        );

        System.out.println(minIslandSize(graph)); // 2
    }

}
