package day12;

import java.util.Scanner;

// import javax.swing.tree.TreeNode;

// we have 2 methods to solve this problem 
// firstly we have to traverse the binary tree using preorder because we give more importance to current node in preorder
// then we have to convert this nodes to number 
// we have 2 methods for that 
// method 1 : convert the node to string then after reaching the leaf node convert the string to integer 
// method 3 : use mathematical o

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     int sum = 0;
//     public int sumNumbers(TreeNode root) {
//         int num = 0;
//         dfs(root,num);
//         return sum;
//     }
//     public void dfs(TreeNode root, int num){
//         if(root == null ) return ;
//         num=num*10+root.val;
//         if(root.left == null && root.right == null ){
//             sum+=num;
//         }
//         dfs(root.left,num);
//         dfs(root.right,num);

//     }
    
// }

public class SumRootToLeafNode {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);

        read.close();
    }
    
}
class Node {
    int val;
    Node left;
    Node right;
    Node (int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}