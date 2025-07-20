package day22;

import java.util.*;

public class FindIfPathExistsInGraph_1971 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

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

        System.out.print("Enter source node: ");
        int source = read.nextInt();

        System.out.print("Enter destination node: ");
        int destination = read.nextInt();

        FindIfPathExistsInGraph_1971 obj = new FindIfPathExistsInGraph_1971();
        boolean result = obj.FindIfPathExistsInGraphSolution(n, edges, source, destination);

        System.out.println("Path exists: " + result);

        read.close();
    }

    public boolean FindIfPathExistsInGraphSolution(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        dfs(graph, vis, source);
        if (vis[destination])
            return true;
        else
            return false;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int idx) {
        vis[idx] = true;
        for (int i = 0; i < graph.get(idx).size(); i++) {
            if (!vis[graph.get(idx).get(i)]) {
                dfs(graph, vis, graph.get(idx).get(i));
            }
        }
    }
}
