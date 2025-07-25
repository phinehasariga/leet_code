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
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftdiameter = diameterOfBinaryTree(root.left);
        int leftheight = height(root.left);
        int rightdiameter = diameterOfBinaryTree(root.right);
        int rightheight = height(root.right);

        int selfdiameter = leftheight + rightheight;

        int treedia = Math.max(selfdiameter,Math.max(leftdiameter,rightdiameter));

        return treedia;
    }
    public static int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh)+1;
    }
}