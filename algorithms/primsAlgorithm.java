package algorithms;
import java.util.Scanner;
import java.util.PriorityQueue;

public class primsAlgorithm {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int v = sc.nextInt();
      int e = sc.nextInt();
      int[][] graph = new int[v][v];
      for(int i=0;i<v;i++){
        for(int j=0;j<v;j++){
          graph[i][j] = Integer.MAX_VALUE;
        }
      }
      for(int i=0;i<e;i++){
        int s = sc.nextInt();
        int d = sc.nextInt();
        int w = sc.nextInt();
        
        graph[s][d] = w;
        graph[d][s] = w;
      }
      int cost = prims(graph,v,e);
      System.out.print("Cost of MST:"+cost);
      sc.close();
  }
  public static int prims(int[][] graph, int v, int e){
    int sum = 0;
    boolean[] vis = new boolean[v];
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    pq.add(new Edge(0,0,0));
    while(!pq.isEmpty()){
      Edge temp = pq.poll();
      if(!vis[temp.d]){
        vis[temp.d] = true;
        sum+=temp.w;
        for(int i=0;i<v;i++){
          int weight = graph[temp.d][i];
          if(!vis[i] && graph[temp.d][i] != Integer.MAX_VALUE){
            pq.add(new Edge(temp.d,i,weight));
          }
        }
      }
    }
    return sum;
  }
}

class Edge implements Comparable<Edge>{
  int s,d,w;
  Edge(int s,int d, int w){
    this.s = s;
    this.d = d;
    this.w = w;
  }
  public int compareTo(Edge that){
    return this.w-that.w;
  }
}





















