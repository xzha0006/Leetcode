class Solution {
    private static class LogComparator implements Comparator<String> {
        @Override
        public int compare(String log1, String log2) {
            int idx1 = log1.indexOf(" ");
            int idx2 = log2.indexOf(" ");
            String identifier1 = log1.substring(0, idx1);
            String identifier2 = log2.substring(0, idx2);
            int idfRes = identifier1.compareTo(identifier2);
            String body1 = log1.substring(idx1);
            String body2 = log2.substring(idx2);
            if (body1.matches("[a-z\\ ]+") && !body2.matches("[a-z\\ ]+")) {
                return -1;
            }
            else if (body2.matches("[a-z\\ ]+") && !body1.matches("[a-z\\ ]+")) {
                return 1;
            }
            
            else if (body2.matches("[a-z\\ ]+") && body1.matches("[a-z\\ ]+")) {
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
