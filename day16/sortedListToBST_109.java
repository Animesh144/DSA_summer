package day16;
import java.util.*;

public class sortedListToBST_109 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter sorted list elements (-1 to end):");

        // Create the linked list from input
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (true) {
            int val = read.nextInt();
            if (val == -1)
                break;
            temp.next = new ListNode(val);
            temp = temp.next;
        }
        read.close();

        ListNode head = dummy.next;

        // Convert sorted linked list to BST
        sortedListToBST_109 obj = new sortedListToBST_109();
        TreeNode root = obj.sortedListToBST(head);

        // In-order print of constructed BST
        System.out.println("Inorder traversal of constructed BST:");
        inorder(root);
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);
        // find middle node;
        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        prev.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
    
    public static void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
    public static TreeNode insertionInBST(TreeNode root, int val){
        if(root == null) return new TreeNode(val);
        if(val < root.val) root.left = insertionInBST(root.left, val);
        else root.right = insertionInBST(root.right, val);
        return root;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}