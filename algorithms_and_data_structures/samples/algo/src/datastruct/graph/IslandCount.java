package datastruct.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IslandCount {

    private record Position(int r, int c) {
    }

    public static int countIsland(List<List<Character>> graph) {

        Set<Position> visited = new HashSet<>();

        int count = 0;

        for (int r = 0; r < graph.size(); r++) {

            for (int c = 0; c < graph.get(0).size(); c++) {

                if (explore(graph, r, c, visited)) {
                    count++;
                }

            }
        }

        return count;
    }

    private static boolean explore(List<List<Character>> graph, int r, int c, Set<Position> visited) {

        if (r < 0 || r >= graph.size() || c < 0 || c >= graph.get(0).size()) {
            return false;
        }

        if (graph.get(r).get(c).equals('W')) {
            return false;
        }

        Position currentPosition = new Position(r, c);
        if (visited.contains(currentPosition)) {
            return false;
        }

        visited.add(currentPosition);

        explore(graph, r - 1, c, visited);
        explore(graph, r + 1, c, visited);
        explore(graph, r, c - 1, visited);
        explore(graph, r, c + 1, visited);

        return true;
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

        System.out.println(countIsland(graph)); // 3
    }

}
