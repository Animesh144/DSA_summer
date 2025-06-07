package day22;

public class NetworkDelayTime_743 {
    
}
// class Solution {
//     public int networkDelayTime(int[][] times, int n, int k) {
//         ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
//         int v = n;
//         int e = times.length;
//         for(int i=0;i<=v;i++){
//             graph.add(new ArrayList<Edge>());
//         }
//         for(int i=0;i<e;i++){
//             int s = times[i][0];
//             int d = times[i][1];
//             int w = times[i][2];
//             graph.get(s).add(new Edge(s, d, w));
//         }

//         return dij(graph,v,e,k);
//     }
//     public static int dij(ArrayList<ArrayList<Edge>> graph, int v, int e,int k){
//         PriorityQueue<Edge> pq = new PriorityQueue<>();
//         boolean[] vis = new boolean[v+1];
//         int[] cost = new int[v+1];
//         for(int i=0;i<=v;i++){
//             cost[i] = Integer.MAX_VALUE;
//         }
//         cost[k] = 0;
//         pq.add(new Edge(k,k,0));
//         while(!pq.isEmpty()){
//             Edge E = pq.poll();
//             if(!vis[E.d]){
//                 vis[E.d] = true;
//                 for(int i=0;i<graph.get(E.d).size();i++){
//                     int weight = E.w;
//                     Edge des = graph.get(E.d).get(i);
//                     if(weight+des.w<cost[des.d]){
//                         cost[des.d] = weight+des.w;
//                         pq.add(new Edge(E.d,des.d,cost[des.d]));
//                     }
//                 }
//             }
//         }
//         int max = 0;
//         for(int i:cost){
//             max = (i>max)?i:max;
//         }
//         if(max==Integer.MAX_VALUE) return -1;
//         else return max;
//     }
// }
// class Edge implements Comparable<Edge>{
//     int s,d,w;
//     Edge(int s, int d, int w){
//         this.d= d;
//         this.s = s;
//         this.w = w;
//     }
//     public int compareTo(Edge a){
//         return this.w-a.w;
//     }
// }