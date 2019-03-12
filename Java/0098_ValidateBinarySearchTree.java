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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Integer min = rightLeaf(root.left);
        Integer max = leftLeaf(root.right);
        return (min == null || (isValidBST(root.left) && min < root.val)) && (max == null || (isValidBST(root.right) && max > root.val));
    }
    
    private Integer leftLeaf(TreeNode root) {
        if (root == null) return null;
        if (root.left == null) {
            // System.out.println("min value is " + root.val);
            return root.val;
        }
        return leftLeaf(root.left);
    }
    
    private Integer rightLeaf(TreeNode root) {
        if (root == null) return null;
        if (root.right == null) {
            // System.out.println("max value is " + root.val);
            return root.val;
        }
        return rightLeaf(root.right);
    }
}
