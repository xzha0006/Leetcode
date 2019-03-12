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
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(min, getMinimumDifference(root.left));
            min = Math.min(min, Math.abs(root.val - getMostRight(root.left)));
        }
        if (root.right != null) {
            min = Math.min(min, getMinimumDifference(root.right));
            min = Math.min(min, Math.abs(root.val - getMostLeft(root.right)));
        }
        return min;
    }
    private int getMostLeft(TreeNode root) {
        if (root.left == null) return root.val;
        return getMostLeft(root.left);
    }
    private int getMostRight(TreeNode root) {
        if (root.right == null) return root.val;
        return getMostRight(root.right);
    }
}
