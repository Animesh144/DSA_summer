package algorithms;


import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class dijkstra_Algorithm {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<e;i++){
            int s = sc.nextInt();
            int d = sc.nextInt();
            int w = sc.nextInt();
             graph.get(s).add(new Edge(s,d,w));
        }
        int k = sc.nextInt();
        sc.close();
        int res = dijkstras(graph,v,e,k);
        System.out.print(res);
    }
    public static int dijkstras(ArrayList<ArrayList<Edge>> graph, int v, int e, int k){
        int sum = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] path = new int[v];
        boolean[] vis = new boolean[v];
        for(int i=0;i<v;i++){
            path[i] = Integer.MAX_VALUE;
        }
        path[k] = 0;
        pq.add(new Edge(k,k,0));
        while(!pq.isEmpty()){
            Edge E = pq.poll();
            if(vis[E.d]) continue;
            vis[E.d] = true;
            for(int i=0;i<graph.get(E.d).size();i++){
                int weight = E.w;
                Edge des = graph.get(E.d).get(i);
                if((weight+des.w)<path[des.d]){
                    path[des.d] = weight+des.w;
                    pq.add(new Edge(E.d, des.d, path[des.d]));;
                }

            }
        }
        for(int i=0;i<v;i++){
            System.out.print(path[i]+" ");
            if(path[i]>sum)sum = path[i];
        }
        System.out.println();
        if(sum==Integer.MAX_VALUE) return -1;
        return sum;
    }
}

class Edge implements Comparable<Edge>{
    int s,d,w;
    Edge(int s, int d, int w){
        this.s = s;
        this.d = d;
        this.w = w;
    }
    public int compareTo(Edge that){
        return this.w-that.w;
    }
}