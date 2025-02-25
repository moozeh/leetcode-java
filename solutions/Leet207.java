import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    int[] indegrees;
    boolean[] visited;
    List<Integer>[] graph;

    public boolean canFinish(int n, int[][] prerequisites) {
        graph = new List[n];
        indegrees = new int[n];
        visited = new boolean[n];
        boolean answer = true;

        for (int[] pair : prerequisites) {
            if (graph[pair[1]] == null) graph[pair[1]] = new ArrayList<>();
            graph[pair[1]].add(pair[0]);
            indegrees[pair[0]]++;
        }

        Queue<Integer> available = new LinkedList<>();

        for (int i = 0; i < n; ++i) {
            if (indegrees[i] == 0) {
                available.add(i);
            }
        }

        while (!available.isEmpty()) {
            int course = available.poll();
            visited[course] = true;
            if (graph[course] == null) continue;
            for (int t : graph[course]) {
                indegrees[t]--;
                if (indegrees[t] == 0)
                    available.add(t);
            }
        }

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                answer = false;
            }
        }

        return answer;
    }
}