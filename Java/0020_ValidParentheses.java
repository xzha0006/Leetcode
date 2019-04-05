class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty()) {
                    if (stack.pop() == '(') {
                        break;
                    } else {
                        return false;
                    }
                        
                }
            } else if (c == ']') {
                while (!stack.isEmpty()) {
                    if (stack.pop() == '[') {
                        break;
                    } else {
                        return false;
                    }
                        
                }
            } else if (c == '}') {
                while (!stack.isEmpty()) {
                    if (stack.pop() == '{') {
                        break;
                    } else {
                        return false;
                    }
                        
                }
            }
        }
        return stack.isEmpty();
    }
}
