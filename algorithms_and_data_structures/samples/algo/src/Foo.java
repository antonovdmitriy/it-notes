import java.util.*;

public class Foo {

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

    public record Position(int r, int c) {
    }

    private static int countIsland(List<List<Character>> graph) {

        int count = 0;
        Set<Position> visited = new HashSet<>();
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

        Position position = new Position(r, c);
        if (visited.contains(position)) {
            return false;
        }

        visited.add(position);

        if (r > graph.size() - 1 || r < 0|| c > graph.get(0).size() - 1 || c < 0) {
            return false;
        }

        if (graph.get(r).get(c).equals('W')) {
            return false;
        }

        explore(graph, r + 1, c, visited);
        explore(graph, r, c + 1, visited);
        explore(graph, r - 1, c, visited);
        explore(graph, r, c - 1, visited);

        return true;
    }
}
