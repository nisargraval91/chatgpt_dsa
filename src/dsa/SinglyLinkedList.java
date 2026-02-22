package dsa;

/**
 * Singly linked list with head/tail pointers for O(1) append.
 *
 * Practical operations:
 * - addFirst, addLast
 * - remove by value, removeFirst, removeLast
 * - contains, get(index)
 */
public class SinglyLinkedList {
    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addLast(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void addFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        if (tail == null) tail = node;
        size++;
    }

    public boolean remove(int value) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            if (curr.value == value) {
                unlink(prev, curr);
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    public int removeFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        int val = head.value;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return val;
    }

    public int removeLast() {
        if (head == null) throw new IllegalStateException("List is empty");
        if (head == tail) {
            int v = head.value;
            head = tail = null;
            size = 0;
            return v;
        }
        Node prev = null;
        Node curr = head;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        tail = prev;
        size--;
        return curr.value;
    }

    public boolean contains(int value) {
        Node curr = head;
        while (curr != null) {
            if (curr.value == value) return true;
            curr = curr.next;
        }
        return false;
    }

    public int get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index: " + index);
        Node curr = head;
        for (int i = 0; i < index; i++) curr = curr.next;
        return curr.value;
    }

    public int size() {
        return size;
    }

    private void unlink(Node prev, Node curr) {
        if (prev == null) head = curr.next;
        else prev.next = curr.next;
        if (curr == tail) tail = prev;
        size--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node curr = head;
        while (curr != null) {
            sb.append(curr.value);
            if (curr.next != null) sb.append(", ");
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
