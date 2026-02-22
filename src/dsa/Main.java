package dsa;

public class Main {
    public static void main(String[] args) {
        // 1) Dynamic Array practicals
        DynamicArray arr = new DynamicArray();
        arr.add(10);
        arr.add(30);
        arr.insert(1, 20);
        arr.set(2, 40);
        int removedAt = arr.removeAt(1);
        System.out.println("DynamicArray: " + arr + ", removedAt=" + removedAt + ", contains40=" + arr.contains(40));

        // 2) Singly Linked List practicals
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(2);
        list.addLast(3);
        list.addFirst(1);
        int removedFirst = list.removeFirst();
        list.addLast(4);
        int removedLast = list.removeLast();
        System.out.println("SinglyLinkedList: " + list + ", removedFirst=" + removedFirst + ", removedLast=" + removedLast);

        // 3) Stack practicals
        StackUsingArray stack = new StackUsingArray();
        stack.push(5);
        stack.push(7);
        stack.push(9);
        System.out.println("Stack peek=" + stack.peek() + ", popped=" + stack.pop() + ", now=" + stack);

        // 4) Queue practicals
        QueueUsingArray queue = new QueueUsingArray();
        queue.offer(100);
        queue.offer(200);
        queue.offer(300);
        System.out.println("Queue peek=" + queue.peek() + ", polled=" + queue.poll() + ", now=" + queue);

        // 5) Hash Table practicals
        HashTable map = new HashTable(8);
        map.put("apple", 3);
        map.put("banana", 7);
        map.put("apple", 5);
        map.remove("banana");
        System.out.println("HashTable size=" + map.size() + ", get(apple)=" + map.get("apple") + ", keys=" + map.keys());

        // 6) BST practicals
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.delete(30);
        System.out.println("BST contains 30? " + bst.contains(30) + ", inorder=" + bst.inorder() + ", height=" + bst.height());

        // 7) Min Heap practicals
        MinHeap heap = new MinHeap();
        heap.add(8);
        heap.add(3);
        heap.add(10);
        heap.add(1);
        System.out.println("MinHeap peek=" + heap.peek() + ", poll=" + heap.poll() + ", now=" + heap);

        // 8) Graph BFS / DFS practicals
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        System.out.println("Graph BFS from 1: " + graph.bfs(1));
        System.out.println("Graph DFS from 1: " + graph.dfs(1));

        // 9) Trie practicals
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("car");
        trie.delete("car");
        System.out.println("Trie search(cat): " + trie.search("cat") + ", search(car): " + trie.search("car"));

        // 10) Disjoint Set Union practicals
        DisjointSetUnion dsu = new DisjointSetUnion(6);
        dsu.union(0, 1);
        dsu.union(1, 2);
        dsu.union(3, 4);
        System.out.println("DSU connected(0,2): " + dsu.connected(0, 2));
        System.out.println("DSU connected(2,4): " + dsu.connected(2, 4));
    }
}
