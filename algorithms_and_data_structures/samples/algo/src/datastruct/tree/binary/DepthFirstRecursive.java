package datastruct.tree.binary;

import java.util.Deque;
import java.util.LinkedList;

public class DepthFirstRecursive {

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

        if (root == null) {
            return;
        }

        System.out.println(root.getValue());
        depthFirstPrint(root.getLeft());
        depthFirstPrint(root.getRight());
    }

    public static boolean containsDepthFirst(Node root, Object value) {
        if (root == null) {
            return false;
        }

        if(root.getValue().equals(value)){
            return true;
        }

        return containsDepthFirst(root.getLeft(), value) || containsDepthFirst(root.getRight(), value);
    }

    public static void preOrder(Node root) {
        // self left right
        // TIME O(n)
        // SPACE O(n)

        if (root == null) {
            return;
        }

        System.out.println(root.getValue());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }


    public static void postOrder(Node root) {
        // left right self
        // TIME O(n)
        // SPACE O(n)

        if (root == null) {
            return;
        }

        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.println(root.getValue()); // print before
    }


    public static void inOrder(Node root) {
        // left self right
        // TIME O(n)
        // SPACE O(n)

        if (root == null) {
            return;
        }

        inOrder(root.getLeft());
        System.out.println(root.getValue()); // print before
        inOrder(root.getRight());
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
        preOrder(a);
        System.out.println("--");
        postOrder(a);
        System.out.println("--");
        inOrder(a);
    }

}
