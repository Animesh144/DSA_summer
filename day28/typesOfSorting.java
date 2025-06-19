package day28;
import java.util.*;
public class typesOfSorting {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        read.close();
    }
    public static void mergeSort(int[] arr, int n){
        
    }
    public static void BubbleSort(int[] arr, int n){
        for (int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void ModifiedBubbleSort(int[] arr, int n){
        for (int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j+1]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }
    public static void selectionSort(int[] arr, int n){
        
    }
}
