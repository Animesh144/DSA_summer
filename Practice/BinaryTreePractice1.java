import java.util.*;
import java.util.LinkedList;


public class BinaryTreePractice1 {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        int val = read.nextInt();
        BinaryTree root = new BinaryTree(val);
        levelOrderInsertion(root, read);
        System.out.print("Preorder Traversal : ");
        preorderTraversal(root);
        System.out.println();
        System.out.print("Inorder Traversal : ");
        inorderTraversal(root);
        System.out.println();
        System.out.print("Postorder Traversal : ");
        postorderTraversal(root);
        System.out.println();
        System.out.print("Levelorder Traversal : ");
        levelOrderTravesal(root);
        System.out.println();
        read.close();;
    }
    public static void levelOrderInsertion(BinaryTree root, Scanner read){
        Queue<BinaryTree> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryTree curr = q.poll();
            int l = read.nextInt();
            if(l!=-1){
                BinaryTree leftNOde = new BinaryTree(l);
                curr.left = leftNOde;
                q.add(leftNOde);
            }
            int r = read.nextInt();
            if(r!=-1){
                BinaryTree rightNode = new BinaryTree(r);
                curr.right = rightNode;
                q.add(rightNode);
            }
        }
    }
    public static void preorderTraversal(BinaryTree root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
    public static void inorderTraversal(BinaryTree root){
        if(root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }
    public static void postorderTraversal(BinaryTree root){
        if(root == null) return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data + " ");
    }
    public static void levelOrderTravesal(BinaryTree root){
        Queue<BinaryTree> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryTree curr = q.poll();
            System.out.print(curr.data + " ");
            if(curr.left != null ){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
    }
}
class BinaryTree{
    int data;
    BinaryTree left ;
    BinaryTree right ;
    BinaryTree(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}