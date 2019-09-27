// quick sort
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        int index = logs.length - 1;
        for (int i = logs.length - 1; i >= 0; i--) {
            String cur = logs[i].substring(logs[i].indexOf(" ") + 1);
            if (cur.charAt(0) <= '9') {
                swap(logs, index--, i);
            }
        }
        quickSort(logs, 0, index);
        return logs;
    }
    
    // Sort arr
    private void quickSort(String[] arr, int start, int end) {
        if (start <= end) {
            String pivot = arr[end].substring(arr[end].indexOf(" ") + 1);
            int index = start;
            for (int i = start; i < end; i++) {
                String cur = arr[i].substring(arr[i].indexOf(" ") + 1);
                if (pivot.compareTo(cur) > 0 || ((pivot.compareTo(cur) == 0 && arr[end].compareTo(arr[i]) > 0))) {
                    swap(arr, index++, i);
                } 
            }
            swap(arr, index, end);
            quickSort(arr, start, index - 1);
            quickSort(arr, index + 1, end);
        }
    }
    
    private void swap(String[] arr, int old, int nnew) {
        String tmp = arr[old];
        arr[old] = arr[nnew];
        arr[nnew] = tmp;
    }
}
// common solution
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
