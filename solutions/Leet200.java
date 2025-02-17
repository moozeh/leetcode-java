
// TODO: 재귀 차이 이해해두기
class Solution {
    boolean[][] visited;
    int[][] dir = {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
    };
    int m, n;
    char[][] grid;

    public int numIslands(char[][] grid) {
        m = grid[0].length;
        n = grid.length;
        this.grid = grid;

        int islands = 0;

        visited = new boolean[n][m];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (visited[i][j])
                    continue;
                if (grid[i][j] == '0') {
                    visited[i][j] = true;
                    continue;
                }
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void dfs(int y, int x) {

        for (int i = 0; i < dir.length; ++i) {
            int dy = y + dir[i][0];
            int dx = x + dir[i][1];
            if (dy < 0 || dy >= n || dx < 0 || dx >= m)
                continue;
            if (!visited[dy][dx] && grid[dy][dx] == '1') {
                visited[dy][dx] = true;
                dfs(dy, dx);
            }
        }
    }
}