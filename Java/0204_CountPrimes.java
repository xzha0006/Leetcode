class Solution {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        if (n == 3) return 1;
        int[] primeMap = new int[n];
        setNonPrime(n, 3, primeMap);
        int count = 2;
        for (int j = 5; j < n; j += 2) {
            if (primeMap[j] == 0) {
                setNonPrime(n, j, primeMap);
                ++count;
            }
        }
        return count;
    }
    
    private void setNonPrime(int n, int num, int[] primeMap) {
        for (int i = num; i < Math.ceil((double) n / num); ++i) {
            primeMap[i * num] = 1;
        }
    }

}
