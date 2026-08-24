BFS
  public class Solution {

    public int bfsPattern(int[][] grid, int startR, int startC) {
        int rows = grid.length, cols = grid[0].length;
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        queue.offer(new int[]{startR, startC});
        visited[startR][startC] = true;

        int steps = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                int[] curr = queue.poll();
                int r = curr[0], c = curr[1];

                // Example target condition
                if (grid[r][c] == 9) return steps; 

                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] != 1 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test runner
        Solution sol = new Solution();
        int[][] grid = {
            {0, 0, 0},
            {1, 1, 0},
            {0, 0, 9}
        };
        System.out.println(sol.bfsPattern(grid, 0, 0)); // Prints shortest steps
    }
}

OUTPUT:

C:\Users\Admin\Downloads>javac Solution.java

C:\Users\Admin\Downloads>java Solution
4
