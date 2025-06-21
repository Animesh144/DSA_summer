package day12;
import java.util.*;


// class Solution {
//     TreeNode t = null;
//     public void flatten(TreeNode root) {
//         if(root == null ) return ;

//         flatten(root.right);
//         flatten(root.left);
//         root.right = t;
//         root.left = null ;
//         t = root;
        
//     }
// }

public class FlattenBinaryTreeIntoLinkedList_114 {
    TreeNode t = null;
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        read.close();
    }
    public void FlattenBinaryTreeIntoLinkedListSolution(TreeNode root){
        if(root == null) return;
        FlattenBinaryTreeIntoLinkedListSolution(root.right);
        FlattenBinaryTreeIntoLinkedListSolution(root.left);
        root.right = t;
        root.left = null;
        t = root;
    }

    public static void levelOrderInsertion(TreeNode root, Scanner read){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int l = read.nextInt();
            if(l!=-1){
                TreeNode ln = new TreeNode(l);
                curr.left = ln;
                q.add(ln);
            }
            int r = read.nextInt();
            if(r!=-1){
                TreeNode rn = new TreeNode(r);
                curr.right = rn ;
                q.add(rn);
            }
        }
    }
    
}
class TreeNode {
    int val;
    TreeNode right;
    TreeNode left;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}