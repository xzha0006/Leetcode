class Solution {
    public int lengthLongestPath(String input) {
        int maxLen = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (String s: input.split("\n")) {
            int numOfTab = s.lastIndexOf('\t') + 1;
            while (stack.size()-1 > numOfTab) stack.pop(); //key point
            if (s.contains(".")) {
                maxLen = Math.max(maxLen, stack.peek() + s.length() - numOfTab);
            }
            else {
                stack.push(stack.peek() + s.length() - numOfTab + 1);
            }
        }
        return maxLen;
    }
}
