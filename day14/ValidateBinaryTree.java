package day14;

// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         if(root.left == null && root.right == null ){
//             return true;
//         }
//         if((root.left == null && root.right.val>root.val) ||(root.right == null && root.left.val < root.val)){
//             return true;
//         }
//         if(root.left.val>=root.val || root.right.val=root.val){
//             return false;
//         }
//         boolean flag1 = isValidBST(root.left);
//         boolean flag2 = isValidBST(root.right);
//         if(flag1 == true && flag2 == true ){
//             return true ;
//         }
//         else {
//             return false;
//         }
//     }
// }

public class ValidateBinaryTree {
    
}
