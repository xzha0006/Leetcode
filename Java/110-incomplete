/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int depthLeft = depth(root.left);
        int depthRight = depth(root.right);
        return Math.abs(depthLeft - depthRight) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int depth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
