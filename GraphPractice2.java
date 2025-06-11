import java.util.*;

import day23.bellmanFordAlgorithm;
// sample input for Dijkstra - op = 19
// 6 8
// 0 1 7
// 0 2 12
// 1 2 2
// 1 3 9
// 2 4 10
// 3 5 1
// 4 3 4
// 4 5 5
// 0
// sample input for kruskals and prims op = 99
// 7 9
// 0 1 28
// 0 5 10 
// 1 2 16
// 1 6 14
// 2 3 12 
// 3 4 22
// 3 6 18 
// 4 5 25
// 4 6 24
// sample input for bellman ford op = 0 3 5 2 5 
// 5 7
// 0 1 6
// 0 2 5
// 1 3 -1
// 2 4 3
// 2 1 -2
// 2 3 4
// 3 4 3
public class GraphPractice2 {
    public static void main(String[] args){
        Scanner read = new Scanner (System.in);
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(); // adjecency list representation of graph
        int v = read.nextInt();
        int e = read.nextInt();
        int[][] graphMatrix = new int [v][v]; // adjcency matrix representation of graph
        ArrayList<EdgeList> graphEdgeList = new ArrayList<>(); // Edge list representation of graph
        // WeightedAdjMatrix(graphMatrix, v, e, read);
        // WeightedAdjList(graph, v, e, read);
        WeightedEdgeList(graphEdgeList,v,e,read);
        // int res = primsAlgoUsingAdjMatrix(graphMatrix,v,e);
        // int resKruskal = kruskalsAlgorithm(graphEdgeList, v, res);
        // System.out.println(resKruskal);
        // System.out.println(res);
        // int resDijkstra = DijkstraAlgorithm(graph,v,e,0);
        // System.out.println(resDijkstra);
        int[] resBellmanFord = BellmanFordAlgorithm(graphEdgeList, v, e, 0);
        read.close();
    }
    public static int[] BellmanFordAlgorithm(ArrayList<EdgeList> graph , int v, int e, int k){
        int[] d = new int[v];
        Arrays.fill(d,Integer.MAX_VALUE);
        d[k] = 0;
        for(int i=0;i<v-1;i++){
            for(EdgeList edge : graph ){
                if(d[edge.s]!=Integer.MAX_VALUE && d[edge.s]+edge.w<d[edge.d]){
                    d[edge.d] = d[edge.s]+edge.w;
                }
            }
        }
        System.out.println("Cost to reach all vertex from "+k);
        for(int i=0;i<v;i++){
        System.out.println("From "+k+" to "+i+" is:"+d[i]);
        }
        return d;
    }
    public static int DijkstraAlgorithm(ArrayList<ArrayList<Edge>> graph , int v, int e, int k){  // uses adjcency list representation 
        int sum = 0;
        boolean[] vis = new boolean[v];
        int[] path = new int[v];
        for(int i=0;i<v;i++) path[i] = Integer.MAX_VALUE;
        path[k] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(k,k,0));
        while(!pq.isEmpty()){
            Edge E = pq.poll();
            if(vis[E.d]) continue;
            vis[E.d] = true;
            for(int i=0;i<graph.get(E.d).size();i++){
                int weight = E.w;
                Edge des = graph.get(E.d).get(i);
                if((weight + des.w)<path[des.d]){
                    path[des.d] = weight + des.w;
                    pq.add(new Edge(E.d,des.d,path[des.d]));
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
    public static int primsAlgoUsingAdjMatrix(int[][] graph, int v, int e){
        int sum = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[v];
        pq.add(new Edge(0,0,0));
        while(!pq.isEmpty()){
            Edge temp = pq.poll();
            if(!vis[temp.d]){
                sum += temp.w;
                vis[temp.d] = true;
                for(int i=0;i<v;i++){
                    int weight = graph[temp.d][i];
                    if(!vis[i] && weight!=Integer.MAX_VALUE){
                        pq.add(new Edge(temp.d,i,weight));
                    }
                }
            }
        }
        return sum;
    }
    public static int kruskalsAlgorithm(ArrayList<EdgeList> graph, int v, int e){
        int sum = 0;
        graph.sort(Comparator.comparingInt(ed->ed.w));
        int[] vertex = new int[v];
        for(int i=0;i<v;i++){
            vertex[i] = i;
        }
        for(EdgeList edge : graph){
            int s = FindEndNode(vertex,edge.s);
            int d = FindEndNode(vertex,edge.d);

            if(s!=d){
                sum += edge.w;
                vertex[s] = d;
            }
        }
        return sum;
    }
    public static int FindEndNode(int[] vertex, int index){
        if(vertex[index] == index ) return index;
        return FindEndNode(vertex, vertex[index]);
    }
    // Creation Of Edge List Graph 
    public static void WeightedEdgeList(ArrayList<EdgeList> graph, int v,int e,Scanner read){
        for(int i=0;i<e;i++){
            int s = read.nextInt();
            int d = read.nextInt();
            int w = read.nextInt();
            graph.add(new EdgeList(s, d, w));
        }
    }
    // Creation of Adjcency List graph
    public static void WeightedAdjList(ArrayList<ArrayList<Edge>> graph, int v, int e, Scanner read){
        for(int i=0;i<v;i++){
            graph.add(new ArrayList<Edge>());
        }
        for(int i=0;i<e;i++){
            int s = read.nextInt();
            int d = read.nextInt();
            int w = read.nextInt();
            Edge unit1 = new Edge(s, d, w);
            graph.get(s).add(unit1);
            Edge unit2 = new Edge(d, s, w);
            graph.get(d).add(unit2);
        }
        for(int i=0;i<v;i++){
            System.out.print("Source "+i+" : ");
            for(int j=0;j<graph.get(i).size();j++){
                System.out.print("Dest->"+graph.get(i).get(j).d+" Weight->"+graph.get(i).get(j).w+"|");            
            }System.out.println();
        }
    }
    // Creation of Weighted Adjcency Matrix Gragh
    public static void WeightedAdjMatrix(int[][] graph, int v, int e, Scanner read){
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                graph[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<e;i++){
            int s = read.nextInt();
            int d = read.nextInt();
            int w = read.nextInt();

            graph[s][d] = w;
            graph[d][s] = w;
        }
        // for(int i=0;i<v;i++){
        //     for(int j=0;j<v;j++){
        //         System.out.print(graph[i][j]+" ");
        //     }
        //     System.out.println();
        // }
    }
    
}
// Class for Edge list Graph
class EdgeList {
    int s,d,w;
    EdgeList(int s,int d,int w){
        this.s = s;
        this.d = d;
        this.w = w;
    }
}
// class for Adjececy List Graph
class Edge implements Comparable<Edge>{
    int s,d,w;
    Edge(int s,int d,int w){
        this.s = s;
        this.d = d;
        this.w = w;
    }
    public int compareTo(Edge that){
        return this.w-that.w;
    }
}