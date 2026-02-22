package dsa;

/**
 * Circular queue implementation with resizing.
 */
public class QueueUsingArray {
    private int[] data = new int[4];
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public void offer(int value) {
        ensureCapacity();
        data[tail] = value;
        tail = (tail + 1) % data.length;
        size++;
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException("Queue is empty");
        int value = data[head];
        data[head] = 0;
        head = (head + 1) % data.length;
        size--;
        return value;
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException("Queue is empty");
        return data[head];
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size < data.length) return;
        int[] newData = new int[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(head + i) % data.length];
        }
        data = newData;
        head = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[(head + i) % data.length]);
            if (i + 1 < size) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
