package datastruct.queue;

import datastruct.stack.LinkedListStack;

public class Queue<T> {

    private Node head = null;
    private Node tail = null;

    private void enqueue(T value) {
        Node nodeToAdd = new Node(value, null);
        if (head == null) {
            head = nodeToAdd;
            tail = nodeToAdd;
        } else {
            tail.setNext(nodeToAdd);
            tail = nodeToAdd;
        }
    }

    private T dequeue() {

        if (head == null) {
            return null;
        }

        T result = head.getValue();

        head = head.getNext();

        if (head == null) {
            tail = null;
        }

        return result;

    }


    private String printNode(Node node) {

        if (node == null) {
            return "";
        }

        return node.getValue() + "->" + printNode(node.getNext());
    }

    public void print() {
        System.out.println(printNode(head));
    }


    public class Node {
        private final T value;
        private Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Queue<String> stack = new Queue<>();
        stack.enqueue("a");
        stack.enqueue("b");
        stack.enqueue("c");
        stack.print();

        stack.dequeue();
        stack.print();
        stack.dequeue();
        stack.print();
        stack.dequeue();
        stack.print();

        stack.enqueue("a");
        stack.enqueue("b");
        stack.enqueue("c");
        stack.print();

    }

}
