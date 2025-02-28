import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public static class Pair implements Comparable<Pair> {
        int weight;
        int place;

        public Pair(int weight, int place) {
            this.weight = weight;
            this.place = place;
        }

        @Override
        public int compareTo(Solution.Pair o) {
            return Integer.compare(o.weight, weight);
        }

    }

    List<List<Pair>> graph;
    int[] dp;

    public int networkDelayTime(int[][] times, int n, int k) {
        graph = new ArrayList<>();
        dp = new int[n + 1];

        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>());
            dp[i] = -1;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < times.length; ++i) {
            int from = times[i][0];
            int to = times[i][1];
            int weight = times[i][2];

            graph.get(from).add(new Pair(weight, to));
        }

        pq.add(new Pair(0, k));
        dp[k] = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            if (cur.weight > dp[cur.place])
                continue;

            List<Pair> curEdges = graph.get(cur.place);

            if (curEdges == null)
                continue;

            for (Pair next : curEdges) {
                if (dp[next.place] == -1 || next.weight + dp[cur.place] < dp[next.place]) {
                    dp[next.place] = next.weight + dp[cur.place];
                    pq.add(new Pair((next.weight + dp[cur.place]), next.place));
                }
            }
        }

        int answer = -1;

        for (int i = 1; i <= n; ++i) {
            if (dp[i] == -1) {
                answer = -1;
                break;
            }
            if (answer < dp[i])
                answer = dp[i];
        }

        return answer;
    }
}