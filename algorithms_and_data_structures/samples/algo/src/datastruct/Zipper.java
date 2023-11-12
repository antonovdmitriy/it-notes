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

    public static Node zipper(Node first, Node second) {


        Node head = first;



        while (first != null && second != null) {

        }

        return head;
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
