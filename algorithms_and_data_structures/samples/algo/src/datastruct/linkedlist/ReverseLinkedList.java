package datastruct.linkedlist;

public class ReverseLinkedList {

    public static class Node<T> {

        private final T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }


    public static Node reverseLinkedListIterativeMutable(Node head) {

        if (head.getNext() == null) {
            return head;
        }

        Node current = head;
        Node newHead = null;

        while (current != null) {
            Node next = current.getNext();
            current.setNext(newHead);
            newHead = current;
            current = next;
        }

        return newHead;
    }

    public static Node reverseLinkedListIterative(Node head) {

        if (head.getNext() == null) {
            return head;
        }

        Node current = head;
        Node newHead = null;

        while (current != null) {
            newHead = new Node(current.getValue(), newHead);
            current = current.getNext();
        }

        return newHead;
    }

    public static Node reverseLinkedListRecursive(Node current) {

        return reverseLinkedListRecursive(current, null);
    }

    public static Node reverseLinkedListRecursive(Node current, Node head) {

        if (current == null) {
            return head;
        }

        return reverseLinkedListRecursive(current.getNext(), new Node(current.getValue(), head));
    }


    public static Node reverseLinkedListRecursiveMutable(Node head) {

        if (head.getNext() == null) {
            return head;
        }

        return reverseLinkedListRecursiveMutableHelper(head, null);
    }

    public static Node reverseLinkedListRecursiveMutableHelper(Node current, Node newHead) {

        if (current == null) {
            return newHead;
        }

        Node next = current.getNext();
        current.setNext(newHead);
        return reverseLinkedListRecursiveMutableHelper(next, current);
    }

    public static void print(Node<?> node) {

        StringBuilder sb = new StringBuilder();
        Node<?> current = node;
        while (current != null) {
            sb.append(current.getValue());
            sb.append("->");
            current = current.getNext();
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {

        Node<String> head = new Node<>("A", new Node<>("B", new Node<>("C", new Node<>("D", null))));
        print(reverseLinkedListIterativeMutable(head));
        head = new Node<>("A", new Node<>("B", new Node<>("C", new Node<>("D", null))));
        print(reverseLinkedListRecursiveMutable(head));
        head = new Node<>("A", new Node<>("B", new Node<>("C", new Node<>("D", null))));
        print(reverseLinkedListIterative(head));
        print(reverseLinkedListRecursive(head));

    }

}
