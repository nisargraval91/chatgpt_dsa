package dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Basic hash table using separate chaining.
 */
public class HashTable {
    private static class Entry {
        String key;
        int value;

        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final List<Entry>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        buckets = new List[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void put(String key, int value) {
        int idx = index(key);
        for (Entry e : buckets[idx]) {
            if (e.key.equals(key)) {
                e.value = value;
                return;
            }
        }
        buckets[idx].add(new Entry(key, value));
        size++;
    }

    public Integer get(String key) {
        int idx = index(key);
        for (Entry e : buckets[idx]) {
            if (e.key.equals(key)) return e.value;
        }
        return null;
    }

    public boolean containsKey(String key) {
        return get(key) != null;
    }

    public boolean remove(String key) {
        int idx = index(key);
        boolean removed = buckets[idx].removeIf(e -> e.key.equals(key));
        if (removed) size--;
        return removed;
    }

    public int size() {
        return size;
    }

    public List<String> keys() {
        List<String> result = new ArrayList<>();
        for (List<Entry> bucket : buckets) {
            for (Entry e : bucket) result.add(e.key);
        }
        return result;
    }

    private int index(String key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }
}
