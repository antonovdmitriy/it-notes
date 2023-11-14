package datastruct.graph;

import java.util.*;

public class DepthFirstRecursive {

    public static void depthFirstPrint(Map<Character, List<Character>> graph, Character source) {

        System.out.println(source);

        graph.get(source).forEach(e -> depthFirstPrint(graph, e));
    }

    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('a', List.of('b', 'c'));
        graph.put('b', List.of('d'));
        graph.put('c', List.of('e'));
        graph.put('d', List.of('f'));
        graph.put('e', List.of());
        graph.put('f', List.of());

        depthFirstPrint(graph, 'a');
    }
}
