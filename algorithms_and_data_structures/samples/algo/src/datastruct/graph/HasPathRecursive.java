package datastruct.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HasPathRecursive {

    public static boolean hasPath(Map<Character, List<Character>> graph, Character source, Character dest) {

        if (source.equals(dest)) {
            return true;
        }

        List<Character> neighbours = graph.get(source);

        for (Character neighbour : neighbours) {
            if (hasPath(graph, neighbour, dest)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('f', List.of('g', 'i'));
        graph.put('g', List.of('h'));
        graph.put('h', List.of());
        graph.put('i', List.of('g', 'k'));
        graph.put('j', List.of('i'));
        graph.put('k', List.of());

        System.out.println(hasPath(graph, 'f', 'k'));
    }
}
