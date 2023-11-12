package datastruct.stack;

public class LinkedListStack<T> {

    private Node top = null;

    private void push(T value) {
        top = new Node(value, top);
    }

    private T pop() {

        if (top == null) {
            return null;
        }

        T resut = top.getValue();
        top = top.getNext();
        return resut;
    }


    private String printNode(Node node) {

        if (node == null) {
            return "";
        }

        return node.getValue() + "->" + printNode(node.getNext());
    }

    public void print() {
        System.out.println(printNode(top));
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
        LinkedListStack<String> stack = new LinkedListStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.print();

        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
    }
}
