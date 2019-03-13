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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        helper(root, val);
        return root;
        
    }
    
    private void helper(TreeNode root, int val) {
        if (root == null) root = new TreeNode(val);;
        // if (root.left == null && root.right == null) {
        //     if (root.val > val) root.left = new TreeNode(val);
        //     if (root.val < val) root.right = new TreeNode(val);
        // }
        if (root.val > val) {
            if (root.left != null) {
                helper(root.left, val);
            } else {
                root.left = new TreeNode(val);
            }
            
        }
        if (root.val < val) {
            if (root.right != null) {
                helper(root.right, val);
            } else {
                root.right = new TreeNode(val);
            }
        }
    }
}
