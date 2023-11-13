package datastruct.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSum {

    private static class Node<T> {

        private final T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }
    }

    public static int sumBreadthFirst(Node<Integer> root) {

        Queue<Node<Integer>> memo = new LinkedList<>();

        memo.offer(root);

        int result = 0;
        while (!memo.isEmpty()) {
            Node<Integer> current = memo.poll();
            result += current.getValue();
            if (current.getLeft() != null) {
                memo.offer(current.getLeft());
            }
            if (current.getRight() != null) {
                memo.offer(current.getRight());
            }
        }
        return result;
    }


    public static void main(String[] args) {

        Node<Integer> a = new Node<>(3);
        Node<Integer> b = new Node<>(2);
        Node<Integer> c = new Node<>(7);
        Node<Integer> d = new Node<>(4);
        Node<Integer> e = new Node<>(-2);
        Node<Integer> f = new Node<>(5);

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setRight(f);

        System.out.println(sumBreadthFirst(a)); // 19
    }

}
