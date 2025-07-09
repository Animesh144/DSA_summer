package day19;

import java.util.Scanner;

public class NumberOfProvinces_547 {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        int n = read.nextInt(); // Number of cities (nodes)

        int[][] isConnected = new int[n][n];
        // Read adjacency matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                isConnected[i][j] = read.nextInt();
            }
        }

        NumberOfProvinces_547 obj = new NumberOfProvinces_547();
        int result = obj.findCircleNum(isConnected);

        System.out.println("Number of Provinces: " + result);

        read.close();
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int pr = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                pr++;
                dfs(isConnected, i, n, vis);
            }
        }
        return pr;
    }

    public static void dfs(int[][] graph, int s, int n, boolean[] vis) {
        vis[s] = true;
        for (int i = 0; i < n; i++) {
            if (graph[s][i] == 1 && !vis[i]) {
                dfs(graph, i, n, vis);
            }
        }
    }
}
