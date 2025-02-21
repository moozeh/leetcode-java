import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        fillAnswers(nums, 0, new ArrayList<>());

        return ret;
    }

    public void fillAnswers(int[] nums, int index, List<Integer> buffer) {
        if (nums.length == index) {
            ret.add(List.copyOf(buffer));
            return;
        }

        buffer.add(nums[index]);
        fillAnswers(nums, index + 1, buffer);

        buffer.removeLast();
        fillAnswers(nums, index + 1, buffer);
    }
}