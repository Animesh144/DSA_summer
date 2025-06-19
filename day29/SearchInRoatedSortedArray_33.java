package day29;

public class SearchInRoatedSortedArray_33 {
    public static void main(String[] args){

    }
    public static int SearchInRoatedSortedArraySolution(int[] nums, int target){
        int l=0,h=nums.length-1;
        while(l<=h){
            int mid = (l+h)/2;
            if(nums[mid] == target) return mid;
            else if(nums[l]<=nums[mid]){//left part is sorted
                if(nums[l]<=target && nums[mid]>=target){//target is in left part
                    h = mid-1;
                }else {
                    l = mid+1;
                }
            }else {
                if(nums[mid]<=target && nums[h]>=target){//target is in left part
                    l = mid+1;
                }else {
                    h = mid-1;
                }
                
            }
        }
        return -1;
    }
    
}
