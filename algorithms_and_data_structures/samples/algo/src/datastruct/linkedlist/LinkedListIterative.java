package datastruct.linkedlist;

public class LinkedListIterative<T> {

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

    public T get(int index) {
        if (head == null) {
            throw new IllegalArgumentException("list bound violation ");
        }

        if (index == 0) {
            return head.getValue();
        }

        return getNodeByIndex(index).getValue();
    }

    public boolean remove(T value) {

        if(head == null){
            return false;
        }

        if (head.getValue().equals(value)) {
            head = head.getNext();
            return true;
        }

        Node previous = head;
        Node current = head.getNext();
        while (current != null) {
            if (current.getValue().equals(value)) {
                previous.setNext(current.getNext());
                return true;
            }

            previous = current;
            current = current.getNext();
        }

        return false;
    }

    public Node remove(T value, Node head) {

        if (head.getValue().equals(value)) {
            return head.getNext();
        }

        Node previous = head;
        Node current = head.getNext();
        while (current != null) {
            if (current.getValue().equals(value)) {
                previous.setNext(current.getNext());
                break;
            }

            previous = current;
            current = current.getNext();
        }

        return head;
    }

    public boolean contains(T value) {
        if (head == null) {
            return false;
        }

        Node current = head;
        boolean result = false;
        while (current != null) {
            if (current.getValue().equals(value)) {
                result = true;
                break;
            }
            current = current.getNext();
        }

        return result;
    }

    public void print() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.append(current.getValue());
            result.append("->");
            current = current.getNext();
        }
        System.out.println(result);
    }

    public void print(Node head) {
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.append(current.getValue());
            result.append("->");
            current = current.getNext();
        }
        System.out.println(result);
    }

    @Override
    public String toString() {

        if (head == null) {
            return "";
        }

        return TO_STRING_PATTERN.formatted(head);
    }

    private Node getNodeByIndex(int index) {
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            if (currentNode.getNext() == null) {
                throw new IllegalArgumentException("list bound violation ");
            }
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    private Node getTail(Node firstNode) {

        while (firstNode.getNext() != null) {
            firstNode = firstNode.getNext();
        }

        return firstNode;
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
        LinkedListIterative<Integer> things = new LinkedListIterative<>();
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
