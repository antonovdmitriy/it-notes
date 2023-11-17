package datastruct.graph;

import java.util.HashSet;
import java.util.Set;

public class MinIslandSize {

    private record Position(int r, int c) {
    }

    public static int minIslandSize(Character[][] graph) {

        Set<Position> visited = new HashSet<>();

        int minSize = Integer.MAX_VALUE;

        for (int r = 0; r < graph.length; r++) {

            for (int c = 0; c < graph[0].length; c++) {

                int currentIsland = explore(graph, r, c, visited);
                if (currentIsland > 0 && currentIsland < minSize) {
                    minSize = currentIsland;
                }
            }
        }

        return minSize;
    }

    private static int explore(Character[][] graph, int r, int c, Set<Position> visited) {

        if (r < 0 || r >= graph.length || c < 0 || c >= graph[0].length) {
            return 0;
        }

        if (graph[r][c].equals('W')) {
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

        Character[][] graph = {
                {'W', 'L', 'W', 'W', 'W'},
                {'W', 'L', 'W', 'W', 'W'},
                {'W', 'W', 'W', 'L', 'W'},
                {'W', 'W', 'L', 'L', 'W'},
                {'L', 'W', 'W', 'L', 'L'},
                {'L', 'L', 'W', 'W', 'W'}
        };

        System.out.println(minIslandSize(graph)); // 2
    }

}
