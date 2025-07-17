package day21;

import java.util.*;

public class CountNumberOfCompleteComponent_2685 {
    static ArrayList<Integer> vertex = new ArrayList<>();

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        // Input: number of nodes and number of edges
        System.out.print("Enter number of nodes: ");
        int n = read.nextInt();

        System.out.print("Enter number of edges: ");
        int m = read.nextInt();

        int[][] edges = new int[m][2];

        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < m; i++) {
            edges[i][0] = read.nextInt();
            edges[i][1] = read.nextInt();
        }

        int result = CountNumberOfCompleteComponentSolution(n, edges);
        System.out.println("Number of complete components: " + result);

        read.close();
    }

    public static int CountNumberOfCompleteComponentSolution(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int count = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                vertex.clear();
                dfs(graph, vis, i);
                if (isComplete(graph)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int idx) {
        vis[idx] = true;
        vertex.add(idx);
        for (int neighbor : graph.get(idx)) {
            if (!vis[neighbor]) {
                dfs(graph, vis, neighbor);
            }
        }
    }

    public static boolean isComplete(ArrayList<ArrayList<Integer>> graph) {
        int size = vertex.size();
        for (int node : vertex) {
            if (graph.get(node).size() != size - 1) {
                return false;
            }
        }
        return true;
    }
}
