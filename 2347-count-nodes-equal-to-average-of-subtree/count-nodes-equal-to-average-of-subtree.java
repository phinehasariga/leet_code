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
    private int nodeCount;
    public int averageOfSubtree(TreeNode root) {
        nodeCount = 0;
        dfs(root);
        return nodeCount;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] leftSubtree = dfs(root.left);
      
        int[] rightSubtree = dfs(root.right);
        int subtreeSum = leftSubtree[0] + rightSubtree[0] + root.val;
        int subtreeNodeCount = leftSubtree[1] + rightSubtree[1] + 1;
        if (subtreeSum / subtreeNodeCount == root.val) {
            nodeCount++;
        }
        return new int[]{subtreeSum, subtreeNodeCount};
    }

}