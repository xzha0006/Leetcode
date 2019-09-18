/**
 * Dummy solution
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        List<List<Integer>> leftResult = levelOrderBottom(root.left);
        List<List<Integer>> rightResult = levelOrderBottom(root.right);
        int i = leftResult.size() - 1;
        int j = rightResult.size() - 1;
        while (i >= 0 || j >= 0) {
            List<Integer> element = new ArrayList<>();
            if (i >= 0) element.addAll(leftResult.get(i));
            --i;
            if (j >= 0) element.addAll(rightResult.get(j));
            --j;
            result.add(0, element);
        }
        result.add(Arrays.asList(root.val));
        return result;
        
    }
}
