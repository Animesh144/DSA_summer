package day20;

import java.util.*;

public class AllPathFromSourceToTarget_797 {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        // Read number of nodes
        int n = read.nextInt();
        int[][] graph = new int[n][];

        // Read adjacency list for each node
        for (int i = 0; i < n; i++) {
            int m = read.nextInt(); // number of neighbors for node i
            graph[i] = new int[m];
            for (int j = 0; j < m; j++) {
                graph[i][j] = read.nextInt();
            }
        }

        // Get all paths and print
        List<List<Integer>> allPaths = allPathsSourceTarget(graph);
        for (List<Integer> path : allPaths) {
            System.out.println(path);
        }

        read.close();
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(graph, 0, graph.length - 1, path, res);
        return res;
    }

    private static void dfs(int[][] graph, int current, int target, List<Integer> path, List<List<Integer>> res) {
        path.add(current);
        if (current == target) {
            res.add(new ArrayList<>(path));
        } else {
            for (int next : graph[current]) {
                dfs(graph, next, target, path, res);
            }
        }
        path.remove(path.size() - 1); // backtrack
    }
}
