package dsa;

import java.util.Arrays;

/**
 * Dynamic array implementation similar to ArrayList for primitive int values.
 *
 * Practical operations included:
 * - append (add)
 * - insert at index
 * - get/set
 * - remove by index / removeLast
 * - search (contains, indexOf)
 *
 * Time complexity summary:
 * - add: Amortized O(1)
 * - insert/removeAt: O(n)
 * - get/set: O(1)
 * - contains/indexOf: O(n)
 */
public class DynamicArray {
    private int[] data;
    private int size;

    public DynamicArray() {
        data = new int[4];
        size = 0;
    }

    /** Append value to the end. */
    public void add(int value) {
        ensureCapacity();
        data[size++] = value;
    }

    /** Insert value at a specific index, shifting remaining elements right. */
    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        ensureCapacity();
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }

    public int get(int index) {
        checkIndex(index);
        return data[index];
    }

    public void set(int index, int value) {
        checkIndex(index);
        data[index] = value;
    }

    /** Remove element at index and return removed value. */
    public int removeAt(int index) {
        checkIndex(index);
        int removed = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = 0;
        return removed;
    }

    public int removeLast() {
        if (size == 0) throw new IllegalStateException("Array is empty");
        int value = data[--size];
        data[size] = 0;
        return value;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) return i;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    @Override
    public String toString() {
        int[] snapshot = Arrays.copyOf(data, size);
        return Arrays.toString(snapshot);
    }
}
