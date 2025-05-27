package day11;
import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

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
//     int res =0;
//     public int diameterOfBinaryTree(TreeNode root) {
//         diameter(root);
//         return res;
//     }
//     public int diameter(TreeNode current){
//         if (current == null ) return 0;
//         int ld = diameter(current.left);
//         int rd = diameter(current.right);
//         res = Math.max(res,(ld+rd));
//         return Math.max(ld,rd)+1;
//     }
// }
public class DiameterOfTree {
    static int res=0;
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        Queue<Node> q = new LinkedList<>();
        int val = read.nextInt();
        Node root = new Node(val);
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            int l=read.nextInt();
            if(l!=-1){
                Node lNew = new Node(l);
                curr.left=lNew;
                q.add(lNew);
            }
            int r = read.nextInt();
            if(r!=-1){
                Node rNew = new Node(r);
                curr.right=rNew;
                q.add(rNew);
            }
        }
        System.out.println(diameterOfBinaryTree(root));
        read.close();
    }
    public static int diameterOfBinaryTree(Node root) {
        diameter(root);
        return res;
    }
    public static int diameter(Node current){
        if (current == null ) return 0;
        int ld = diameter(current.left);
        int rd = diameter(current.right);
        res = Math.max(res,(ld+rd));
        return Math.max(ld,rd)+1;
    }
}

class Node {
    int val;
    Node right;
    Node left;
    Node (int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}