package datastruct.graph;

import java.util.*;

public class DepthFirstIterative {

    public static void depthFirstPrint(Map<Character, List<Character>> graph, Character source) {

        Deque<Character> stack = new LinkedList<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            Character current = stack.pop();

            System.out.println(current);
            List<Character> neighbours = graph.get(current);
            if (neighbours != null && !neighbours.isEmpty()) {
                neighbours.forEach(stack::push);
            }
        }

    }

    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('a', List.of( 'c', 'b'));
        graph.put('b', List.of('d'));
        graph.put('c', List.of('e'));
        graph.put('d', List.of('f'));
        graph.put('e', List.of());
        graph.put('f', List.of());

        depthFirstPrint(graph, 'a');
    }
}
