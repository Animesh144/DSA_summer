package Arrays_leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContainDuplicates_217 {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        read.close();
    }
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(s.contains(nums[i])){
                return true;
            }
            else {
                s.add(nums[i]);
            }
        }
        return false;
        
    }
}
