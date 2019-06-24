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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        if (root.val == target.val) {
            result = findNodesDistanceWithinK(root, K);
            return result;
        } 
        int leftDepth = findNode(root.left, target);
        int rightDepth = findNode(root.right, target);
        if (leftDepth != -1) {
            result = distanceK(root.left, target, K);
            root.left = null;
            result.addAll(findNodesDistanceWithinK(root, K - leftDepth - 1));
        } else {
            result = distanceK(root.right, target, K);
            root.right = null;
            result.addAll(findNodesDistanceWithinK(root, K - rightDepth - 1));
        }
        return result;
    }
    
    private int findNode(TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root.val == target.val) return 0;
        int left = findNode(root.left, target);
        int right = findNode(root.right, target);
        if (left != -1) return left + 1;
        else if (right != -1) return right + 1;
        else return -1;
    }
    
    private List<Integer> findNodesDistanceWithinK(TreeNode root, int K) {
        List<Integer> result = new ArrayList<>();
        if (root == null || K < 0) {
            return result;
        }
        if (K == 0) {
            result.add(root.val);
        }
        if (root.left != null) {
            result.addAll(findNodesDistanceWithinK(root.left, K - 1));
        }
        if (root.right != null) {
            result.addAll(findNodesDistanceWithinK(root.right, K - 1));
        }
        return result;
    }
}
