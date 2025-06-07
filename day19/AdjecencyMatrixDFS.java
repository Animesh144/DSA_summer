package day19;
import java.util.*;


public class AdjecencyMatrixDFS {
    public static void main(String[] args){
        Scanner read = new Scanner (System.in);
        int v = read.nextInt();
        int e = read.nextInt();

        int[][] graph = new int[v][v];
        for(int i=0;i<e;i++){
            int s = read.nextInt();
            int d = read.nextInt();
            graph[s][d] = 1;
            graph[d][s] = 1;
        }
        boolean[] vis = new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(graph,vis,i,v,e);
            }
        }
        read.close();
    }
    public static void dfs(int[][] graph,boolean[] vis,int s,int v,int e){
        vis[s] = true;
        System.out.print(s+" ");
        for(int i=0;i<v;i++){
            if(graph[s][i]==1 && !vis[i]){
                dfs(graph,vis,i,v,e);
            }
        }
    }
    
}
