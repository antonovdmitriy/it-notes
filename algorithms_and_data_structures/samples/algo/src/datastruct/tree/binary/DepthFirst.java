package datastruct.tree.binary;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DepthFirst {

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

    public static void depthFirstPrint(Node root) {

        // TIME O(n)
        // SPACE O(n)

        Deque<Node> memo = new LinkedList<>();

        memo.push(root);

        while (!memo.isEmpty()) {
            Node current = memo.pop();
            System.out.println(current.getValue());
            if (current.getRight() != null) {
                memo.push(current.getRight());
            }
            if (current.getLeft() != null) {
                memo.push(current.getLeft());
            }
        }
    }

    public static boolean containsDepthFirst(Node root, Object value) {


        Deque<Node> memo = new LinkedList<>();

        memo.push(root);

        while (!memo.isEmpty()) {
            Node current = memo.pop();
            if (current.getValue().equals(value)) {
                return true;
            }
            if (current.getRight() != null) {
                memo.push(current.getRight());
            }
            if (current.getLeft() != null) {
                memo.push(current.getLeft());
            }
        }

        return false;
    }


    public static void main(String[] args) {

        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");

        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setRight(f);

        depthFirstPrint(a);
        System.out.println(containsDepthFirst(a, "d"));
        System.out.println(containsDepthFirst(a, "t"));
    }

}
