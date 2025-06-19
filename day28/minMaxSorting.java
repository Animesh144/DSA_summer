package day28;
import java.util.*;


public class minMaxSorting {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        read.close();

    }
    public static void minMaxSortingSolution(int[] arr,int n){
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(i%2 == 0){
                    if(arr[i]>arr[j]){
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }else{
                   if(arr[i]<arr[j]){
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                    
                }
            }
        }
    }

}
