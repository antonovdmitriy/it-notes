import java.util.*;

public class Foo {


    public static void main(String[] args) {

        List<List<Character>> graph = List.of(
                List.of('w', 'x'),
                List.of('x', 'y'),
                List.of('z', 'y'),
                List.of('z', 'v'),
                List.of('w', 'v'));
        System.out.println(shortestPath(graph, 'w', 'z'));
    }

    public record Entry(Character value, int count) {
    }


    private static int shortestPath(List<List<Character>> edges, char start, char finish) {

        // breadh first
        // resolved cycles. -> revisitedSet Entry( Character, int) -> record
        // O(m * n) time
        // optimizing variables

        Map<Character, List<Character>> graph = buildGraph(edges);

        Queue<Entry> queue = new LinkedList<>();
        Set<Character> visited = new HashSet<>();
        queue.offer(new Entry(start, 0));
        visited.add(start);

        while (!queue.isEmpty()) {

            Entry current = queue.poll();

            if (current.value().equals(finish)) {
                return current.count();
            }

            for (Character neighbour : graph.get(current.value())) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.offer(new Entry(neighbour, current.count + 1));
                }
            }
        }

        return -1;
    }

    private static Map<Character, List<Character>> buildGraph(List<List<Character>> edges) {

        Map<Character, List<Character>> result = new HashMap<>();

        for (List<Character> edge : edges) {

            Character left = edge.get(0);
            Character right = edge.get(1);

            if (!result.containsKey(left)) {
                result.put(left, new ArrayList<>());
            }

            if (!result.containsKey(right)) {
                result.put(right, new ArrayList<>());
            }

            result.get(left).add(right);
            result.get(right).add(left);
        }

        return result;
    }

}