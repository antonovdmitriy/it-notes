package datastruct.graph;

import java.util.*;

public class ComponentsCount {

    public static int connectedComponentsCount(Map<Integer, List<Integer>> graph) {

        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for (Integer node : graph.keySet()) {

            if(explore(graph, node, visited)){
                count++;
            }
        }

        return count;
    }

    private static boolean explore(Map<Integer, List<Integer>> graph, Integer current, Set<Integer> visited) {

        if (visited.contains(current)) {
            return false;
        }

        visited.add(current);

        for(Integer neighbour : graph.get(current)){
            explore(graph, neighbour, visited);
        }

        return true;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, List.of(8, 1, 5 ));
        graph.put(1, List.of(0));
        graph.put(5, List.of(0, 8));
        graph.put(8, List.of(0, 5));
        graph.put(2, List.of(3, 4));
        graph.put(3, List.of(2, 4));
        graph.put(4, List.of(3, 2));

        System.out.println(connectedComponentsCount(graph)); // 2
    }
}
