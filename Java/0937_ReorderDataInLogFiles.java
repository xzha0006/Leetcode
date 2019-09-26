class Solution {
    private static class LogComparator implements Comparator<String> {
        @Override
        public int compare(String log1, String log2) {
            int idx1 = log1.indexOf(" ");
            int idx2 = log2.indexOf(" ");
            int idfRes = log1.compareTo(log2);
            String body1 = log1.substring(idx1 + 1);
            String body2 = log2.substring(idx2 + 1);
            boolean isDigit1 = body1.charAt(0) <= '9';
            boolean isDigit2 = body2.charAt(0) <= '9';
            if (!isDigit1 && isDigit2) {
                return -1;
            }
            else if (isDigit1 && !isDigit2) {
                return 1;
            }
            
            else if (!isDigit1 && !isDigit2) {
                int result = body1.compareTo(body2);
                return result != 0 ? result : idfRes;
            }
            else {
                return 0;
            }
            
            
            
        }
    }
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new LogComparator());
        return logs;
    }
}
