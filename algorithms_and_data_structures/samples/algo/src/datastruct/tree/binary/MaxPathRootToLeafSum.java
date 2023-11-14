package datastruct.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

public class MaxPathRootToLeafSum {

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

    public static int maxRootToLeafPathSum(Node<Integer> root) {

        if (root == null) {
            return Integer.MIN_VALUE;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            return root.getValue();
        }

        return root.getValue() + Math.max(maxRootToLeafPathSum(root.getLeft()), maxRootToLeafPathSum(root.getRight()));
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

        System.out.println(maxRootToLeafPathSum(a)); // 15
    }

}
