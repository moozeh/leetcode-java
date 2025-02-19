import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];

        makePermutation(nums, 0, new ArrayList<>());

        return ret;
    }

    public void makePermutation(int[] nums, int count, ArrayList<Integer> cand) {
        if (nums.length == count) {
            ret.add(List.copyOf(cand));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (visited[i])
                continue;
            visited[i] = true;
            cand.add(nums[i]);
            makePermutation(nums, count + 1, cand);
            visited[i] = false;
            cand.removeLast();
        }
    }
}