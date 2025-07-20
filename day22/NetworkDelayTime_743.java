package day22;

import java.util.*;

public class NetworkDelayTime_743 {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        // Sample input
        int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int n = 4; // number of nodes
        int k = 2; // starting node

        int result = NetworkDelayTimeSolution(times, n, k);
        System.out.println("Network Delay Time: " + result); // Expected output: 2

        read.close();
    }

    public static int NetworkDelayTimeSolution(int[][] times, int n, int k) {
        ArrayList<ArrayList<edge>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<edge>());
        }

        for (int[] time : times) {
            int s = time[0];
            int d = time[1];
            int w = time[2];
            graph.get(s).add(new edge(s, d, w));
        }

        return dij(graph, n, k);
    }

    public static int dij(ArrayList<ArrayList<edge>> graph, int v, int k) {
        PriorityQueue<edge> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[v + 1];
        int[] cost = new int[v + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[k] = 0;

        pq.add(new edge(k, k, 0)); // Source to source with 0 weight

        while (!pq.isEmpty()) {
            edge E = pq.poll();
            if (!vis[E.d]) {
                vis[E.d] = true; // Mark node as visited
                int weight = E.w;
                for (edge des : graph.get(E.d)) {
                    if (weight + des.w < cost[des.d]) {
                        cost[des.d] = weight + des.w;
                        pq.add(new edge(E.d, des.d, cost[des.d]));
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= v; i++) {
            if (cost[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, cost[i]);
        }

        return max;
    }
}

class edge implements Comparable<edge> {
    int s, d, w;

    edge(int s, int d, int w) {
        this.s = s;
        this.d = d;
        this.w = w;
    }

    public int compareTo(edge that) {
        return this.w - that.w;
    }
}
