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
    int min = Integer.MAX_VALUE;
    Integer prev = null;
    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return min;
    }
    
    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            if (prev != null) {
                min = Math.min(min, root.val - prev);
            }
            
            prev = root.val;
            inOrder(root.right);
        }
    }
}
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
    public int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;
        if (root != null) {
            if (root.left != null) {
                int minLeft = Math.min(minDiffInBST(root.left), root.val - max(root.left));
                min = Math.min(min, minLeft);
            }
            if (root.right != null) {
                int minRight = Math.min(minDiffInBST(root.right), min(root.right) - root.val);
                min = Math.min(min, minRight);
            }
        } 
        return min;
    }
    
    private int max(TreeNode root) {
        if (root.right == null) {
            return root.val;
        }
        return max(root.right);
    }
    
    private int min(TreeNode root) {
        if (root.left == null) {
            return root.val;
        }
        return min(root.left);
    }
}
