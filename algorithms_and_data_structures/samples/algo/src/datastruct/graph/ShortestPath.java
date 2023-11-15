package datastruct.graph;

import java.util.*;

public class ShortestPath {

    public record Entry(Character value, Integer count) {
    }

    public static int shortestPath(List<List<Character>> edges, Character source, Character target) {

        Map<Character, List<Character>> graph = buildGraph(edges);

        Set<Character> visited = new HashSet<>();
        Queue<Entry> queue = new LinkedList<>();
        Entry entry = new Entry(source, 0);

        queue.offer(entry);
        visited.add(source);

        while (!queue.isEmpty()) {

            Entry current = queue.poll();
            if (current.value().equals(target)) {
                return current.count();
            }

            for (Character neighbour : graph.get(current.value)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.offer(new Entry(neighbour, current.count + 1));
                }
            }
        }

        return -1;
    }

    private static boolean shortestPath(Map<Character,
            List<Character>> graph,
                                        Character source,
                                        Character target,
                                        Set<Character> visited) {

        if (source.equals(target)) {
            return true;
        }

        if (visited.contains(source)) {
            return false;
        }

        visited.add(source);

        List<Character> neighbours = graph.get(source);
        for (char neighbour : neighbours) {
            if (shortestPath(graph, neighbour, target, visited)) {
                return true;
            }
        }

        return false;
    }

    private static Map<Character, List<Character>> buildGraph(List<List<Character>> edges) {

        Map<Character, List<Character>> result = new HashMap<>();

        for (List<Character> edge : edges) {

            Character source = edge.get(0);
            Character target = edge.get(1);

            if (!result.containsKey(source)) {
                result.put(source, new ArrayList<>());
            }

            if (!result.containsKey(target)) {
                result.put(target, new ArrayList<>());
            }

            result.get(source).add(target);
            result.get(target).add(source);
        }

        return result;
    }

    public static void main(String[] args) {

        List<List<Character>> graph = List.of(
                List.of('w', 'x'),
                List.of('x', 'y'),
                List.of('z', 'y'),
                List.of('z', 'v'),
                List.of('w', 'v'));
        System.out.println(shortestPath(graph, 'w', 'z'));
    }

}
