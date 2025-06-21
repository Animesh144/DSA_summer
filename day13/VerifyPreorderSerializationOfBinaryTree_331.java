package day13;

import java.util.*;

public class VerifyPreorderSerializationOfBinaryTree_331 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Enter the preorder serialization (comma separated):");
        String preorder = read.nextLine();

        boolean isValid = verifyPreorderSerialization(preorder);
        System.out.println("Is valid serialization? " + isValid);

        /*
         * System.out.println("Enter root node value:");
         * int rootVal = read.nextInt();
         * TreeNode root = new TreeNode(rootVal);
         * System.out.println("Enter level order child nodes (-1 for null):");
         * levelOrderInsertion(root, read); 
         * 9,3,4,#,#,1,#,#,2,#,6,#,# - sample input
         * 
         */

        read.close();
    }

    public static boolean verifyPreorderSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0)
            return false;

        String[] nodes = preorder.split(",");
        int slot = 1;

        for (String node : nodes) {
            if (slot == 0)
                return false;

            if (node.equals("#")) {
                slot--;
            } else {
                slot--;
                slot += 2;
            }
        }

        return slot == 0;
    }

    public static void levelOrderInsertion(TreeNode root, Scanner read) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            int leftVal = read.nextInt();
            if (leftVal != -1) {
                TreeNode leftNode = new TreeNode(leftVal);
                curr.left = leftNode;
                q.add(leftNode);
            }

            int rightVal = read.nextInt();
            if (rightVal != -1) {
                TreeNode rightNode = new TreeNode(rightVal);
                curr.right = rightNode;
                q.add(rightNode);
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
