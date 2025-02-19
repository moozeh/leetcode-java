import java.util.ArrayList;
import java.util.List;

class Solution {
    char[][] graph = {
            {}, // 0
            {}, // 1
            { 'a', 'b', 'c' },
            { 'd', 'e', 'f' },
            { 'g', 'h', 'i' },
            { 'j', 'k', 'l' },
            { 'm', 'n', 'o' },
            { 'p', 'q', 'r', 's' },
            { 't', 'u', 'v' },
            { 'w', 'x', 'y', 'z' }
    };

    List<String> ret = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isBlank())
            return ret;
        dfs(digits, 0, "");

        return ret;
    }

    public void dfs(String digits, int idx, String ans) {
        if (digits.length() <= idx) {
            ret.add(ans);
            return;
        }

        int digit = digits.charAt(idx) - '0';

        for (char t : graph[digit]) {
            dfs(digits, idx + 1, ans + t);
        }
    }
}