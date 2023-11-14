package datastruct.graph;

import java.util.*;

public class HasPathIterative {

    public static boolean hasPath(Map<Character, List<Character>> graph, Character source, Character dest) {

        Queue<Character> queue = new LinkedList<>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            Character current = queue.poll();

            if (current.equals(dest)) {
                return true;
            }

            List<Character> neighbours = graph.get(current);
            if (neighbours != null && !neighbours.isEmpty()) {
                neighbours.forEach(queue::offer);
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
