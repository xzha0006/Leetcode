class Solution {
    public int longestValidParentheses(String s) {
        //use a stack. when '(' push the index into stack. when ')' pop and calculate max length
        Stack<Integer> stack = new Stack();
        int maxLen = 0;
        stack.push(-1); //-1 is used to calculate the length
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } 
            else {
                stack.pop();
                if (stack.size() != 0) {
                    maxLen = maxLen > i - stack.peek() ? maxLen : i - stack.peek();    
                }
                else {
                    stack.push(i);
                }
            }
        }
        return maxLen;
    }
}
