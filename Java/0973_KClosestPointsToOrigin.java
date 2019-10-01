// quick sort solution
class Solution {
    int[][] points;
    public int[][] kClosest(int[][] points, int K) {
        this.points = points;
        sort(0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }
    
    public void sort(int start, int end, int K) {
        if (start < end) {
            int[] pivot = points[end];
            int index = start;
            for (int i = start; i < end; ++i) {
                if (compare(points[i], pivot) <= 0) {
                    swap(index++, i);
                }
            }
            swap(index, end);
            if (index - start + 1 < K) {
                sort(index + 1, end, K - index + start - 1);
            }
            else if (index - start + 1 > K) {
                sort(start, index - 1, K);
            }
        }
        
    }
    private void swap(int old, int nw) {
        int[] tmp = points[old];
        points[old] = points[nw];
        points[nw] = tmp;
    }
    
    private int compare(int[] p1, int[] p2) {
        return (p1[0] * p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] + p2[1] * p2[1]);
    }
}
// qp solution
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] p1, int[] p2) {
                return dist(p1) - dist(p2);
            }
        });
        
        for (int i = 0; i < points.length; ++i) {
            pq.offer(points[i]);
        }
        
        int[][] result = new int[K][2];
        
        for (int j = 0; j < K; ++j) {
            int[] point = pq.poll();
            result[j][0] = point[0];
            result[j][1] = point[1];
        }
        return result;
    }
    
    private int dist(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}
//sort solution
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Integer[][] distances = new Integer[points.length][2];
        for (int i = 0; i < points.length; ++i) {
            distances[i][0] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            distances[i][1] = i;
        }
        Arrays.sort(distances, (Integer[] x, Integer[] y) -> {
            if (x[0] > y[0]) return 1;
            if (x[0] < y[0]) return -1;
            return 0;
        });
        int[][] result = new int[K][2];
        for (int j = 0; j < K; j++) {
            result[j][0] = points[distances[j][1]][0];
            result[j][1] = points[distances[j][1]][1];
        }
        return result;
    }
}
