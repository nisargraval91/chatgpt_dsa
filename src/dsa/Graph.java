package dsa;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Undirected graph using adjacency list representation.
 */
public class Graph {
    private final Map<Integer, List<Integer>> adj = new HashMap<>();

    public void addEdge(int u, int v) {
        adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    public List<Integer> bfs(int start) {
        List<Integer> order = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(start);
        visited.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            order.add(node);
            for (int nei : adj.getOrDefault(node, List.of())) {
                if (visited.add(nei)) {
                    q.offer(nei);
                }
            }
        }
        return order;
    }

    public List<Integer> dfs(int start) {
        List<Integer> order = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfs(start, visited, order);
        return order;
    }

    private void dfs(int node, Set<Integer> visited, List<Integer> order) {
        if (!visited.add(node)) return;
        order.add(node);
        for (int nei : adj.getOrDefault(node, List.of())) {
            dfs(nei, visited, order);
        }
    }
}
