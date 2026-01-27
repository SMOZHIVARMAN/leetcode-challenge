/*
Title: Minimum Cost to Reach Destination Using Modified Dijkstra

Approach:
1. Represent the graph using an adjacency list:
   - Each node stores a list of edges as (neighbor, weight).
2. Edge construction rule:
   - For an edge (u → v) with cost w:
       a) u → v has cost w
       b) v → u has cost 2 * w
3. Use Dijkstra’s algorithm to find the shortest path from node 0 to node n-1:
   - Initialize distance array with INF.
   - Set distance of source node (0) to 0.
   - Use a priority queue (min-heap) to always expand the node
     with the smallest current distance.
4. For each extracted node:
   - Relax all adjacent edges.
   - Update distances if a shorter path is found.
5. If the destination node is unreachable, return -1.
   Otherwise, return the minimum cost to reach node n-1.

Time Complexity:
- O((n + m) log n)
  where:
  - n = number of nodes
  - m = number of edges
  Each edge relaxation and priority queue operation costs log n.

Space Complexity:
- O(n + m)
  - Adjacency list stores all edges.
  - Distance array, visited array, and priority queue use extra space.
*/

import java.util.*;

class Solution {
    private List<List<int[]>> G;

    private int dijkstra(int n) {
        final int INF = 1_000_000_000;
        int[] dist = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0}); // {distance, node}

        while (!pq.isEmpty()) {
            int u = pq.poll()[1];

            if (vis[u]) continue;
            vis[u] = true;

            for (int[] e : G.get(u)) {
                int v = e[0];
                int w = e[1];

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        return dist[n - 1] == INF ? -1 : dist[n - 1];
    }

    public int minCost(int n, int[][] edges) {
        G = new ArrayList<>(n);
        for (int i = 0; i < n; i++) G.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            G.get(u).add(new int[]{v, w});
            G.get(v).add(new int[]{u, 2 * w});
        }

        return dijkstra(n);
    }
}
