package day22;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class dijkstraAlgorithm {
    public static void main(String[] args){
        Scanner read = new Scanner (System.in);
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        int v = read.nextInt();
        int e = read.nextInt();
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<Edge>());
        }
        for(int i=0;i<e;i++){
            int s = read.nextInt();
            int d = read.nextInt();
            int w = read.nextInt();
            graph.get(s).add(new Edge(s, d, w));
        }
        int k = read.nextInt();
        read.close();;
        dij(graph,v,e,k);
    }
    public static void dij(ArrayList<ArrayList<Edge>> graph, int v, int e ,int k){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[v];
        int[] cost = new int[v];
        for(int i=0;i<v;i++){
            cost[i] = Integer.MAX_VALUE;
        }
        cost[k] = 0;
        pq.add(new Edge(k,k,0));
        while(!pq.isEmpty()){
            Edge E = pq.poll();
            if(!vis[E.d]){
                for(int i=0;i<graph.get(E.d).size();i++){
                    int weight = E.w;
                    Edge des = graph.get(E.d).get(i);
                    if(weight+des.w<cost[des.d]){
                        cost[des.d] = weight+des.w;
                        pq.add(new Edge(E.d,des.d,cost[des.d]));
                    }
                }
            }
        }
        for(int i=0;i<v;i++){
            System.out.print(cost[i]+" ");
        }
    }
    
}
class Edge implements Comparable<Edge>{
    int s,d,w;
    Edge(int s, int d, int w){
        this.d= d;
        this.s = s;
        this.w = w;
    }
    public int compareTo(Edge a){
        return this.w-a.w;
    }
}