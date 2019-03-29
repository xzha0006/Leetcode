class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> dict = new HashSet<>();
        for (String word: wordList) dict.add(word);
        if (!dict.contains(endWord)) return 0;
        
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add(beginWord);
        q2.add(endWord);
        int step = 0;
        while (q1.size() != 0 && q2.size() != 0) {
            ++step;
            if (q1.size() > q2.size()) {
                Set<String> tmp = q2;
                q2 = q1;
                q1 = tmp;
            }
            
            Set<String> q = new HashSet<>();
            for (String word: q1) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; ++i) {
                    char tmp = chars[i];
                    for (int ch = 'a'; ch <= 'z'; ++ch) {
                        if (chars[i] == ch) continue;
                        chars[i] = (char) ch;
                        String str = new String(chars);
                        if (q2.contains(str)) return step + 1;
                        if (!dict.contains(str)) continue;
                        dict.remove(str);
                        q.add(str);
                    }
                    chars[i] = tmp;
                }
            }
            q1 = q;
        }
        return 0;
    }
    
}
