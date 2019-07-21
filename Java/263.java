class Solution {
    public boolean isUgly(int num) {
        if (num == 0) return false;
        do {
            if (num % 2 == 0) num /= 2;
            else if (num % 3 == 0) num /= 3;
            else if (num % 5 == 0) num /= 5;
        } while (num % 2 == 0 || num % 3 == 0 || num % 5 == 0);
        return num == 1;
    }
}
