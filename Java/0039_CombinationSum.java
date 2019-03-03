class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> combination = new ArrayList<>();
        dfs(candidates, combination, 0, target, ans);
        return ans;
    }
    
    private void dfs(int[] candidates, ArrayList<Integer> combination, int currentLength, int target, List<List<Integer>> ans) {
        int sum = combination.stream().mapToInt(Integer::intValue).sum();
        if (sum == target) {
            ans.add((ArrayList) combination.clone());
            return;
        } else if (sum > target) {
            return;
        }
        for (int i = currentLength; i < candidates.length; i++) {           
            combination.add(candidates[i]);
            dfs(candidates, combination, i, target, ans);
            combination.remove(new Integer(candidates[i]));
        }
    }
}
