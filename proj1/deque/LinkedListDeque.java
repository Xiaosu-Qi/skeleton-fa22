package deque;

public class LinkedListDeque<T> {
    public class Node<T> {
        public Node prev;
        public T item;
        public Node next;

        public Node(T i, Node p, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }
    private int size;
    private Node sentinel;

    public LinkedListDeque() {
        sentinel = new Node<T>(null, sentinel, sentinel);
        size = 0;
    }

    public LinkedListDeque(T x) {
        sentinel = new Node<T>(null, sentinel, sentinel);
        sentinel.next = new Node (x, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size += 1;
    }

    public void addFirst(T item) {
        sentinel.next.prev = new Node<T>(item, sentinel, sentinel.next);
        sentinel.next = sentinel.next.prev;
        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev.next = new Node<T>(item, sentinel.prev, sentinel);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item);
            System.out.print(" ");
            p = p.next;
        }
    }

    public T removeFirst() {
        Node removed = sentinel.next;
        this.sentinel.next = sentinel.next.next;
        this.sentinel.next.prev = sentinel;
        return (T) removed.item;
    }

    public T removeLast() {
        Node removed = sentinel.prev;
        this.sentinel.prev = sentinel.prev.prev;
        this.sentinel.prev.next = sentinel;
        return (T) removed.item;
    }

    public T get(int index) {
        int i = 0;
        Node p = sentinel;
        while (i <= index) {
            p = p.next;
            i += 1;
        }
        return (T) p.item;
    }

    public boolean equals(Object o) {
        return true;
    }

    public T getRecursive(int index) {
        return (T) getRecursiveHelper(sentinel.next, index);
    }

    private T getRecursiveHelper(Node p, int index) {
        if (index == 0) {
            return (T) p.item;
        }
        return (T) getRecursiveHelper(p.next, index-1);
    }

    public void checkSentinel() {
        System.out.println(sentinel.prev.item); /** the prev of the sentinel is always the last */
        System.out.println(sentinel.item); /** the item of the sentinel is always null */
        System.out.println(sentinel.next.item); /** the next of the sentinel is always the first */
    }


    public static void main(String[] args){
        LinkedListDeque t = new LinkedListDeque(89);

        System.out.println("Manual Tests");
        System.out.println("addFirst, addLast, get Test");
        t.addFirst(88);
        t.addFirst(87);
        t.addLast(90);
        System.out.println(t.get(0));
        System.out.println(t.getRecursive(0));
        System.out.println(t.get(1));
        System.out.println(t.getRecursive(1));
        System.out.println(t.get(2));
        System.out.println(t.getRecursive(2));
        System.out.println(t.get(3));
        System.out.println(t.getRecursive(3));

        System.out.println("Sentinel check");
        t.checkSentinel();

        System.out.println("isEmpty check");
        System.out.println(t.isEmpty());

        System.out.println("size check");
        System.out.println(t.size());

        System.out.println("printDeque check");
        t.printDeque();

        System.out.println("removeFirst check");
        System.out.print("remove first item: ");
        System.out.println(t.removeFirst());
        System.out.print("the rest items: ");
        t.printDeque();


        System.out.println("removeLast check");
        System.out.print("remove last item: ");
        System.out.println(t.removeLast());
        System.out.print("the rest items: ");
        t.printDeque();


    }


}