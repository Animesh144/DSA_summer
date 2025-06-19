package day14;
import java.util.*;

// class Solution {
//     public TreeNode searchBST(TreeNode root, int val) {
//         if(root == null || root.val == val ) return root;
//         if(val>root.val){
//             return searchBST(root.right,val);
//         }else {
//             return searchBST(root.left,val);
//         }
//     }
// }

public class SearchInBST_700 {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        read.close();
    }
    public static TreeNode insertionInBST(TreeNode root, int val){
        if(root == null) return new TreeNode(val);
        if(val < root.val){
            root.left = insertionInBST(root.left, val);
        }else{
            root.right = insertionInBST(root.right, val);
        }
        return root;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}