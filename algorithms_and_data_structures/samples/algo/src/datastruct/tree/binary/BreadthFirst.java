package datastruct.tree.binary;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirst {

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

    public static void breadthFirstPrint(Node root) {

        Queue<Node> memo = new LinkedList<>();

        memo.offer(root);

        while (!memo.isEmpty()) {
            Node current = memo.poll();
            System.out.println(current.getValue());
            if (current.getLeft() != null) {
                memo.offer(current.getLeft());
            }
            if (current.getRight() != null) {
                memo.offer(current.getRight());
            }
        }
    }

    public static boolean containsBreadthFirst(Node root, Object value) {

        Queue<Node> memo = new LinkedList<>();

        memo.offer(root);

        while (!memo.isEmpty()) {
            Node current = memo.poll();
            Object currentValue = current.getValue();
            if (currentValue.equals(value)) {
                return true;
            }
            if (current.getLeft() != null) {
                memo.offer(current.getLeft());
            }
            if (current.getRight() != null) {
                memo.offer(current.getRight());
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

        breadthFirstPrint(a);
        System.out.println(containsBreadthFirst(a, "d"));
        System.out.println(containsBreadthFirst(a, "t"));
    }

}
