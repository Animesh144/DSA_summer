package algorithms;

import java.util.*;

public class kruskalAlgorithm {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int v = sc.nextInt();
      int e = sc.nextInt();
      ArrayList<Edge> graph = new ArrayList<>();
      for(int i=0;i<e;i++){
        int s = sc.nextInt();
        int d = sc.nextInt();
        int w = sc.nextInt();
        
        //Edge list graph
        graph.add(new Edge(s,d,w));
      }
      int res = kruskal(graph, v,e);
      System.out.print(res);
      sc.close();
  }
  public static int kruskal(ArrayList<Edge> graph, int v,int e){
    int sum = 0;
    graph.sort(Comparator.comparingInt(ed->ed.w));
    int[] vertex = new int[v];
    for(int i=0;i<v;i++){
      vertex[i] = i;
    }
    
    for(Edge edge: graph){
      int s = findEndNode(vertex, edge.s);
      int d = findEndNode(vertex,edge.d);
      
      if(s!=d){
        sum+=edge.w;
        vertex[s]=d;
      }
    }
    return sum;
  }
  public static int findEndNode(int[] vertex, int index){
    if(vertex[index]==index){
      return index;
    }
    return findEndNode(vertex, vertex[index]);
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



