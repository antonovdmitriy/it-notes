package datastruct.graph;

import java.util.*;

public class LargestComponent {

    public static int largestComponentSize(Map<Integer, List<Integer>> graph) {

        int largest = 0;
        Set<Integer> visited = new HashSet<>();
        for (Integer node : graph.keySet()) {
            int componentLength = explore(graph, node, visited);
            if (componentLength > largest) {
                largest = componentLength;
            }
        }

        return largest;
    }

    private static int explore(Map<Integer, List<Integer>> graph, Integer current, Set<Integer> visited) {

        if (visited.contains(current)) {
            return 0;
        }

        visited.add(current);

        int size = 1;
        for (Integer neighbour : graph.get(current)) {
            size += explore(graph, neighbour, visited);
        }

        return size;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, List.of(8, 1, 5));
        graph.put(1, List.of(0));
        graph.put(5, List.of(0, 8));
        graph.put(8, List.of(0, 5));
        graph.put(2, List.of(3, 4));
        graph.put(3, List.of(2, 4));
        graph.put(4, List.of(3, 2));

        System.out.println(largestComponentSize(graph)); // 4
    }
}
