package algorithms;

import java.util.*;

public class floyd_Warshall_Algorithm_graph {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int e = sc.nextInt();
      
      int[][] d = new int[n][n];
      for(int i=0;i<n;i++){
        Arrays.fill(d[i],Integer.MAX_VALUE);
        d[i][i] = 0;
      }
      for(int i=0;i<e;i++){
        int u = sc.nextInt();
        int v = sc.nextInt();
        int w = sc.nextInt();
        d[u][v] = w;
      }
      sc.close();
      floydWarshall(d,n);
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
          System.out.print(d[i][j]+" ");
        }System.out.println();
      }
  }

  public static void floydWarshall(int[][] d, int n){
    //outermost loop is for source
    for(int src=0;src<n;src++){
      //two inner for loops for iterating graph
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
          if(d[i][src]!=Integer.MAX_VALUE && d[src][j]!=Integer.MAX_VALUE && d[i][j]>d[i][src]+d[src][j]){
            d[i][j]=d[i][src]+d[src][j];
          }
        }
      }
    }
  }
}











