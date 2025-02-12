class Solution {
    boolean[] jewelMap = new boolean[52]; // a-zA-Z
    
    public int numJewelsInStones(String jewels, String stones) {
        int cnt = 0;
        for (int i=0; i<jewels.length(); ++i) {
            jewelMap[getIdx(jewels.charAt(i))] = true;
        }

        for (int i=0; i<stones.length(); ++i) {
            if (jewelMap[getIdx(stones.charAt(i))]) cnt++;
        }

        return cnt;
    }

    public static int getIdx(char t) {
        if (t >= 'a' && t <= 'z') return t - 'a';
        if (t >= 'A' && t <= 'Z') return t - 'A' + 26;
        return -1;
    }
}