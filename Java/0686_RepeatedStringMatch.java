/**
 * It looks like lastIndexOf is much faster than contains or indexOf
 */
class Solution {
    public int repeatedStringMatch(String A, String B) {
        int n = B.length() / A.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(A);
        }
        if (sb.toString().lastIndexOf(B) != -1) {
            return n;
        }
        else if (sb.append(A).toString().lastIndexOf(B) != -1) {
            return n + 1;
        }
        else if (sb.append(A).append(A).toString().lastIndexOf(B) != -1) {
            return n + 2;
        }
        else {
            return -1;
        }
        
    }
}
class Solution {
    public int repeatedStringMatch(String A, String B) {
        int n = B.length() / A.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(A);
        }
        if (sb.toString().contains(B)) {
            return n;
        }
        else if (sb.append(A).toString().contains(B)) {
            return n + 1;
        }
        else if (sb.append(A).append(A).toString().contains(B)) {
            return n + 2;
        }
        else {
            return -1;
        }
        
    }
}
