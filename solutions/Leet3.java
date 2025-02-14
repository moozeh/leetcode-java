import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int longestSeq = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                int idx = map.get(s.charAt(i));
                i = idx + 1;
                map.clear();
            }

            map.put(s.charAt(i), i);

            if (longestSeq < map.size()) {
                longestSeq = map.size();
            }
        }

        return longestSeq;
    }
}