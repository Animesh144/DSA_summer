package day12;
import java.util.*;

public class BinaryTreeZigzagLevelOrdertraversal_103 {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        int val = read.nextInt();
        TreeNode root = new TreeNode(val);
        levelOrderInsertion(root,read);
        BinaryTreeZigzagLevelOrdertraversalSolution(root);
        read.close();
    }
    public static void BinaryTreeZigzagLevelOrdertraversalSolution(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        q.add(root);
        boolean flag = false;
        while(!q.isEmpty()){
            List<Integer> l1 = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(flag == false){
                    l1.add(curr.val);
                }else{
                    s.push(curr.val);
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            if(flag == true){
                int sz = s.size();
                for(int i=0;i<sz;i++){
                    int el = s.pop();
                    l1.add(el);
                }
            }
            list.add(l1);
            flag = !flag;
        }
        System.out.println(list);
    }
    public static void levelOrderInsertion(TreeNode root,Scanner read){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            int l = read.nextInt();
            if(l != -1){
                TreeNode ln = new TreeNode(l);
                curr.left = ln;
                q.add(ln);
            }
            int r = read.nextInt();
            if(r != -1){
                TreeNode rn = new TreeNode(r);
                curr.right = rn;
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
