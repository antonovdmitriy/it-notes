package datastruct.graph;

import java.util.*;

public class BreadthFirstIterative {

    public static void breadthFirstPrint(Map<Character, List<Character>> graph, Character source) {

        Queue<Character> queue = new LinkedList<>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            Character current = queue.poll();

            System.out.println(current);
            List<Character> neighbours = graph.get(current);
            if (neighbours != null && !neighbours.isEmpty()) {
                neighbours.forEach(queue::offer);
            }
        }

    }

    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('a', List.of( 'b', 'c'));
        graph.put('b', List.of('d'));
        graph.put('c', List.of('e'));
        graph.put('d', List.of('f'));
        graph.put('e', List.of());
        graph.put('f', List.of());

        breadthFirstPrint(graph, 'a');
    }
}
