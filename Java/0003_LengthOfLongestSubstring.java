public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0, length = 0;
        Map<Character, Integer> map = new HashMap<>();
        int seq = 0;
        int flag = 0;
        for (char c : s.toCharArray())
        {
            if (map.containsKey(c) && map.get(c) > flag)
            {
            	flag = map.get(c);
            	length = seq - map.get(c);
            }
            map.put(c, ++seq);
            length++;
            if (length > maxLength)
                maxLength = length;
        }
        return maxLength;
    }
}