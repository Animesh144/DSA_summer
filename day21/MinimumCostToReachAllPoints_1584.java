package day21;

import java.util.*;

public class MinimumCostToReachAllPoints_1584 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = read.nextInt();
            points[i][1] = read.nextInt();
        }
        read.close();
        System.out.println(MinimumCostToReachAllPointsSolution(points));
    }

    public static int MinimumCostToReachAllPointsSolution(int[][] points) {
        int n = points.length;
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            }
        }
        return prims(graph, n);
    }

    public static int prims(int[][] graph, int v) {
        int sum = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[v];
        pq.add(new Edge(0, 0, 0)); // starting from node 0

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (!vis[e.d]) {
                sum += e.w;
                vis[e.d] = true;

                for (int i = 0; i < v; i++) {
                    if (!vis[i]) {
                        pq.add(new Edge(e.d, i, graph[e.d][i]));
                    }
                }
            }
        }
        return sum;
    }
}

class Edge implements Comparable<Edge> {
    int s, d, w;

    Edge(int s, int d, int w) {
        this.s = s;
        this.d = d;
        this.w = w;
    }

    public int compareTo(Edge that) {
        return this.w - that.w;
    }
}
