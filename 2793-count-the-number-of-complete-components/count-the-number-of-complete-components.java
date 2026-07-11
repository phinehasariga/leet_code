import java.util.*;

class Solution {
    private List<Integer>[] graph;
    private boolean[] visited;
    private int nodes;
    private int degreeSum;

    public int countCompleteComponents(int n, int[][] edges) {
        graph = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int complete = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                nodes = 0;
                degreeSum = 0;
                dfs(i);

                int edgeCount = degreeSum / 2;
                if (edgeCount == nodes * (nodes - 1) / 2) {
                    complete++;
                }
            }
        }

        return complete;
    }

    private void dfs(int node) {
        visited[node] = true;
        nodes++;
        degreeSum += graph[node].size();

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}