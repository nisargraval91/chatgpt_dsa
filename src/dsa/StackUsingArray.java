package dsa;

/**
 * Stack (LIFO) built on top of DynamicArray.
 */
public class StackUsingArray {
    private final DynamicArray arr = new DynamicArray();

    public void push(int value) {
        arr.add(value);
    }

    public int pop() {
        return arr.removeLast();
    }

    public int peek() {
        return arr.get(arr.size() - 1);
    }

    public int size() {
        return arr.size();
    }

    @Override
    public String toString() {
        return arr.toString();
    }
}
