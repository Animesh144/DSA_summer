package day29;
import java.util.*;
public class pr {
    public static void main(String[] args) {
        // Scanner read = new Scanner(System.in);
        int[] arr = {1,1,2};
        int n = removeDuplicates(arr);
        System.out.println(n);
    }
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int count = 0;
        int k = 0;
        int[] expectedNums = new int[nums.length];
        for(int i=0;i<n-1;i++){
            int el = nums[i];
            int j = i;
            count++;
            while(el == nums[j]){
                j++;
            }
            expectedNums[k] = nums[i];
            k++;
            i=j-1;

            
        }
        System.out.println("count : "+count);
        for(int i=0;i<count;i++){
            nums[i] = expectedNums[i];
        }
        System.out.println("nums : "+nums);
        return count;
        
    }
}
