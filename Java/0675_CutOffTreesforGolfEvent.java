// bfs solution
class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();
        int x = 0;
        for (List<Integer> row : forest) {
            int y = 0;
            for (Integer val : row) {
                if (val > 1) {
                    trees.add(new int[]{x, y, val});
                }
                y++;
            }
            x++;
        }
        Collections.sort(trees, (a, b) -> a[2] - b[2]);
        int sx = 0, sy = 0;
        int ans = 0;
        
        for (int[] tree : trees) {
            // System.out.println(Arrays.toString(tree));
            int distance = dist(forest, sx, sy, tree[0], tree[1]);
            if (distance != -1) {
                ans += distance;
            }
            else {
                return -1;
            }
            sx = tree[0];
            sy = tree[1];
        }
        return ans;
    }
    
    private int dist(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sx, sy});
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; ++j) {
                int[] cur = queue.poll();
                // System.out.println(cur[0] + "-" + tx + "|" + cur[1] + "-" + ty);
                if (cur[0] == tx && cur[1] == ty) return dist;
                for (int i = 0; i < 4; ++i) {
                    int newX = cur[0] + direction[i][0];
                    int newY = cur[1] + direction[i][1];
                    if (newX >= 0 && newX < forest.size() && newY >=0 && newY < forest.get(0).size() && !visited[newX][newY] && forest.get(newX).get(newY) != 0) {
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            dist++;
        }
        return -1;
        
    }
}
