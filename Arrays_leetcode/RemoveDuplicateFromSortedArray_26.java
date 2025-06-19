package Arrays_leetcode;
import java.util.*;

public class RemoveDuplicateFromSortedArray_26 {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        read.close();
    }
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 1;  // points to next unique spot
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
        
    }
}
