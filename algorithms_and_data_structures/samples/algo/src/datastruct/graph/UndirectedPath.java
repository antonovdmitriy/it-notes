package datastruct.graph;

import java.util.*;

public class UndirectedPath {

    public static boolean undirectedPath(List<List<Character>> edges, Character source, Character target) {

        Map<Character, List<Character>> graph = buildGraph(edges);
        return hasPath(graph, source, target, new HashSet<>());
    }

    private static boolean hasPath(Map<Character,
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
            if (hasPath(graph, neighbour, target, visited)) {
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
                List.of('i', 'j'),
                List.of('k', 'i'),
                List.of('m', 'k'),
                List.of('k', 'l'),
                List.of('o', 'n'));
        System.out.println(undirectedPath(graph, 'j', 'm'));
    }

}
