class Solution {
	public  List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(candidates);
        dfs(candidates, target, new ArrayList<Integer>(), 0, ans);
        return ans;
    }
    private void dfs(int[] candidates, int target, List<Integer> currentCombination, int currentLength, List<List<Integer>> ans) {
        if (0 == target) {
            ans.add(new ArrayList<>(currentCombination));
        } else if (target < 0) {
            return;
        }
        int i;
        for (i = currentLength; i < candidates.length; i++) {
            if (i > currentLength && candidates[i-1] == candidates[i]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            currentCombination.add(candidates[i]);
            dfs(candidates, target - candidates[i], currentCombination, i + 1, ans);
            currentCombination.remove(currentCombination.size() - 1);
        }

    }
}

