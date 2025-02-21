import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        findAnswers(target, 0, candidates, new ArrayList<>());

        return ret;
    }

    public void findAnswers(int target, int index, int[] candidates, List<Integer> buffer) {
        if (target == 0) {
            ret.add(List.copyOf(buffer));
            return;
        }

        for (int i = index; i < candidates.length; ++i) {
            if (target - candidates[i] < 0)
                continue;
            buffer.add(candidates[i]);
            findAnswers(target - candidates[i], i, candidates, buffer);
            buffer.removeLast();
        }
    }
}