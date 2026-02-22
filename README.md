# Data Structures in Java: Zero to Pro (Practical Guide)

This README is conflict-resolved and unified to keep both:
- **practical method coverage** (what is implemented), and
- **real-world explanations** (why/where to use each DSA).

## Quick start

```bash
javac src/dsa/*.java
java -cp src dsa.Main
```

## Data structures implemented

1. DynamicArray
2. SinglyLinkedList
3. StackUsingArray
4. QueueUsingArray
5. HashTable
6. BinarySearchTree
7. MinHeap
8. Graph (BFS/DFS)
9. Trie
10. DisjointSetUnion

## Practical coverage + real-world use

### 1) DynamicArray
- **Implemented methods:** `add`, `insert`, `get`, `set`, `removeAt`, `removeLast`, `contains`, `indexOf`
- **Use in real world:** indexed in-memory buffers, temporary batch aggregation, cached paginated lists

### 2) SinglyLinkedList
- **Implemented methods:** `addFirst`, `addLast`, `remove`, `removeFirst`, `removeLast`, `contains`, `get`
- **Use in real world:** low-overhead chaining, free-lists, append/remove-heavy pipelines

### 3) StackUsingArray
- **Implemented methods:** `push`, `pop`, `peek`, `size`
- **Use in real world:** undo/redo workflows, expression parsing, DFS/backtracking stacks

### 4) QueueUsingArray
- **Implemented methods:** `offer`, `poll`, `peek`, `size`
- **Use in real world:** producer-consumer processing, request buffering, BFS traversal

### 5) HashTable
- **Implemented methods:** `put`, `get`, `remove`, `containsKey`, `keys`, `size`
- **Use in real world:** session/token caches, fast config lookups, dedup/frequency counting

### 6) BinarySearchTree
- **Implemented methods:** `insert`, `contains`, `delete`, `inorder`, `height`
- **Use in real world:** ordered sets/maps, range-like queries, sorted dynamic collections

### 7) MinHeap
- **Implemented methods:** `add`, `peek`, `poll`
- **Use in real world:** priority schedulers, shortest-path internals, top-k streaming logic

### 8) Graph
- **Implemented methods:** `addEdge`, `bfs`, `dfs`
- **Use in real world:** dependency graphs, network topology, recommendation/path traversal

### 9) Trie
- **Implemented methods:** `insert`, `search`, `startsWith`, `delete`
- **Use in real world:** autocomplete, prefix filtering, dictionary and command matching

### 10) DisjointSetUnion (Union-Find)
- **Implemented methods:** `find`, `union`, `connected`
- **Use in real world:** dynamic connectivity, cluster merging, Kruskal MST

## Learning path (fast track)

- Week 1: Array, LinkedList, Stack, Queue
- Week 2: HashTable
- Week 3: BST + Heap
- Week 4: Graph + Trie + DSU
- Week 5+: Mixed problem solving with complexity optimization
