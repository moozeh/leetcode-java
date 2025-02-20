import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> buf = new ArrayList<>();
        getCombine(n, k, 1, buf);

        return ret;
    }

    public void getCombine(int n, int count, int idx, List<Integer> buf) {
        if (count == 0) {
            ret.add(List.copyOf(buf));
            return;
        }

        for (int i = idx; i <= n; ++i) {
            buf.add(i);
            getCombine(n, count - 1, i + 1, buf);
            buf.removeLast();
        }
    }
}