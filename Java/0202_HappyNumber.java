class Solution {
    List<Integer> set = new ArrayList();
    public boolean isHappy(int n) {
        int next = n, sum = 0;
        while (next > 0) {
            sum += Math.pow(next % 10, 2);
            next /= 10;
        }
        
        if (sum == 1) {
            return true;
        }
        else if (set.contains(sum)) {
            return false;
        }
        else {
            set.add(sum);            
        }
        
        return isHappy(sum);
    }
}
