package datastruct;

public class Zipper {

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

    public static Node zipper(Node head1, Node head2) {

        Node tail = head1;
        Node current1 = head1.getNext();
        Node current2 = head2;
        int count = 0;

        while (current1 != null && current2 != null) {
            if (count % 2 == 0) {
                tail.setNext(current2);
                current2 = current2.getNext();
            } else {
                tail.setNext(current1);
                current1 = current1.getNext();
            }
            tail = tail.getNext();
            count++;
        }

        if (current1 != null) {
            tail.setNext(current1);
        }

        if (current2 != null) {
            tail.setNext(current2);
        }

        return head1;
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

        Node<String> first = new Node<>("A", new Node<>("C", new Node<>("E", new Node<>("F", null))));
        Node<String> second = new Node<>("B", new Node<>("D", null));
        print(zipper(first, second));
    }
}
