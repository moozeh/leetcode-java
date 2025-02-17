import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Pair implements Comparator<Pair> {
    public int val;
    public int count;

    public Pair(int val, int count) {
        this.val = val;
        this.count = count;
    }

    @Override
    public int compare(Pair o1, Pair o2) {
        return o2.count - o1.count;
    }
}


// TODO: 최적화
class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        // make map
        // insert if does not exist
        // increase value if exists

        // traverse and check most k elements
        // it should not sort as time complexity should be better than n log n
        // sorting with priorty queue

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Pair(1, 1));
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else
                map.put(nums[i], 1);
        }

        map.keySet().forEach((key) -> {
            pq.add(new Pair(key, map.get(key)));
            System.out.println(key);
            System.out.println(map.get(key));
        });

        int[] ret = new int[k];

        for (int i = 0; i < k; ++i) {
            ret[i] = pq.poll().val;
        }

        return ret;

    }
}