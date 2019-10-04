// Not best solution
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!Arrays.stream(banned).anyMatch(word::equals) && word.length() != 0) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        // System.out.println(map);
        int max = -1;
        String result = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                result = entry.getKey();
                max = entry.getValue();
            }
        }
        return result;
    }
}
