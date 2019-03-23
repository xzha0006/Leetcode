class Solution {
    public boolean judgeCircle(String moves) {
        if (moves.length() == 0) return false;
        int leftAndRight = 0, upAndDown = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') leftAndRight--;
            else if (c == 'R') leftAndRight++;
            else if (c == 'U') upAndDown++;
            else if (c == 'D') upAndDown--;
        }
        return leftAndRight == 0 && upAndDown == 0;
    }
}
