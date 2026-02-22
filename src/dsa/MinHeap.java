package dsa;

import java.util.ArrayList;
import java.util.List;

/**
 * Min-heap implementation using array representation of complete binary tree.
 */
public class MinHeap {
    private final List<Integer> heap = new ArrayList<>();

    public void add(int value) {
        heap.add(value);
        siftUp(heap.size() - 1);
    }

    public int peek() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    public int poll() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            siftDown(0);
        }
        return min;
    }

    private void siftUp(int idx) {
        while (idx > 0) {
            int parent = (idx - 1) / 2;
            if (heap.get(parent) <= heap.get(idx)) break;
            swap(parent, idx);
            idx = parent;
        }
    }

    private void siftDown(int idx) {
        int n = heap.size();
        while (true) {
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;
            int smallest = idx;

            if (left < n && heap.get(left) < heap.get(smallest)) smallest = left;
            if (right < n && heap.get(right) < heap.get(smallest)) smallest = right;
            if (smallest == idx) break;

            swap(idx, smallest);
            idx = smallest;
        }
    }

    private void swap(int i, int j) {
        int tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
