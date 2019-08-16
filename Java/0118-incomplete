class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) return result;
        result.add(new ArrayList<>());
        result.get(0).add(1);
        for (int m = 1; m < numRows; ++m) {
            List<Integer> line = new ArrayList<>();
            List<Integer> lastLine = result.get(m - 1);
            line.add(1);
            for (int n = 1; n < m; ++n) {
                line.add(n, lastLine.get(n - 1) + lastLine.get(n));
            }
            line.add(1);
            result.add(line);
        }
        return result;
    }
}
