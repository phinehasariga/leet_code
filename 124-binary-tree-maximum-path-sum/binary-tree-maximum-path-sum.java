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
    // public int maxPathSum(TreeNode root) {
    //     if(root == null){
    //         return 0;
    //     }
    //     int leftsum = maxPathSum(root.left);
    //     int rightsum = maxPathSum(root.right);
    //     int treesum = leftsum+rightsum+root.val;

    //     return treesum;
    // }
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) return 0;

        // Only take gains > 0; ignore negative paths
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // Current path price (if this node is root of the path)
        int currentPathSum = node.val + leftGain + rightGain;

        // Update global max if this path is better
        maxSum = Math.max(maxSum, currentPathSum);

        // Return max gain for parent path: either left or right + root
        return node.val + Math.max(leftGain, rightGain);
    }
}