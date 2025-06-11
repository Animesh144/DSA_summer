package algorithms;


import java.util.*;

public class BellmanFord_Algorithm {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int v = sc.nextInt();
    int e = sc.nextInt();
    
    ArrayList<Edge> graph = new ArrayList<>();
    for(int i=0;i<e;i++){
      int s = sc.nextInt();
      int d = sc.nextInt();
      int w = sc.nextInt();
      graph.add(new Edge(s,d,w));
    }
    int src = sc.nextInt();
    sc.close();
    
    int res[] = bellmanFord(v,graph,src);
    System.out.println("Cost to reach all vertex from "+src);
    for(int i=0;i<v;i++){
      System.out.println("From "+src+" to "+i+" is:"+res[i]);
    }
  }
  
  public static int[] bellmanFord(int v, ArrayList<Edge> graph, int src){
    int[] d = new int[v];
    // for(int i=0;i<v;i++){
    //   d[i] = Integer.MAX_VALUE;
    // }
    Arrays.fill(d,Integer.MAX_VALUE);
    d[src] = 0;
    
    for(int i=0;i<v-1;i++){
      for(Edge edge: graph){
        if(d[edge.s]!=Integer.MAX_VALUE && d[edge.s]+edge.w<d[edge.d]){
          d[edge.d] = d[edge.s]+edge.w;
        }
      }
    }
    return d;
  }
}

class Edge{
  int s,d,w;
  Edge(int s, int d, int w){
    this.s = s;
    this.d = d;
    this.w = w;
  }
}