package day29;
// import java.util.*;

public class Searching {
    public static void main(String[] args){
        // Scanner read = new Scanner(System.in);
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int k = 7;
        linearSearch(arr, k);
    }
    public static void linearSearch(int[] arr, int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == key) {
                System.out.println("Found");
                return;
            }
        }
        System.out.println("Not Found");
    }
    public static int BinarySearch(int arr[], int x)
    {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }

        // If we reach here, then element was
        // not present
        return -1;
    }
}
