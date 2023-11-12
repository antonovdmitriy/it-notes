package datastruct.linkedlist;

import java.util.Objects;

public class LinkedListRecursive<T> {

    public static final String TO_STRING_PATTERN = "[%s]";
    private Node head;

    public void add(T value) {
        if (head == null) {
            head = new Node(value);
            return;
        }

        Node lastNode = getTail(head);
        lastNode.setNext(new Node(value));
    }

    private boolean nodeContains(T value, Node node) {

        if (node == null) {
            return false;
        }

        if (Objects.equals(value, node.getValue())) {
            return true;
        }

        return nodeContains(value, node.getNext());
    }

    public boolean contains(T value) {
        if (head == null) {
            return false;
        }

        return nodeContains(value, head);
    }


    public T get(int index) {
        if (head == null) {
            throw new IllegalArgumentException("list bound violation ");
        }

        Node foundNode = getNodeByIndex(index, head);
        if (foundNode == null) {
            return null;
        }

        return foundNode.getValue();
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

    public boolean remove(T value) {

        if (head == null) {
            return false;
        }

        if (head.getValue().equals(value)) {
            head = head.getNext();
            return true;
        }

        return removeHelper(value, head.getNext(), head);
    }

    public Node remove(T value, Node head) {

        if (head.getValue().equals(value)) {
            return head.getNext();
        }

        removeHelper(value, head.getNext(), head);

        return head;
    }

    private boolean removeHelper(T value, Node current, Node previous) {

        if (current == null) {
            return false;
        }

        if (current.getValue().equals(value)) {
            previous.setNext(current.getNext());
            return true;
        }

        return removeHelper(value, current.getNext(), current);
    }

    @Override
    public String toString() {

        if (head == null) {
            return "";
        }

        return TO_STRING_PATTERN.formatted(head);
    }


    private Node getNodeByIndex(int index, Node currentNode) {

        if (currentNode == null) {
            return null;
        }

        if (index == 0) {
            return currentNode;
        }

        return getNodeByIndex(index - 1, currentNode.getNext());
    }

    private Node getTail(Node firstNode) {

        if (firstNode.getNext() == null) {
            return firstNode;
        }

        return getTail(firstNode.getNext());
    }

    private class Node {
        private final T value;
        private Node next;

        public Node(T value) {
            this.value = value;
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

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        LinkedListRecursive<Integer> things = new LinkedListRecursive<>();
        things.add(4);
        things.add(5);
        things.print();
        System.out.println(things.get(1));
        System.out.println(things.contains(10));
        System.out.println(things.contains(4));
        things.add(7);
        things.add(8);
        things.print();
        things.remove(8);
        things.print();
        things.remove(4);
        things.print();

    }
}
