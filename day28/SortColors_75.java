package day28;
import java.util.*;

public class SortColors_75 {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);

        read.close();
    }
    public static int[] SortColorSolution(int[] nums){
        int l = 0;
        int r = nums.length-1;
        int i = 0;
        while(i<=r){
            if(nums[i] == 0){
                int temp = nums[l];
                nums[l] = nums[i];
                nums[i] = temp;
                l++;
                i++;
                
            }else if(nums[i] == 2){
                int temp = nums[r];
                nums[r] = nums[i];
                nums[i] = temp;
                r--;

            }else if(nums[i] == 1){
                i++;
            }
        }
        return nums;
    }
}
