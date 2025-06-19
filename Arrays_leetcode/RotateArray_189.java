package Arrays_leetcode;

import java.util.Scanner;

public class RotateArray_189 {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        read.close();
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        int[] arr = new int[n-k];
        for(int i=0;i<n-k;i++){
            arr[i] = nums[i];
        }
        for(int i=0;i<k;i++){
            nums[i] = nums[n-k+i];
        }
        for(int i=k;i<n;i++){
            nums[i] = arr[i-k];
        }
    }
    
}
