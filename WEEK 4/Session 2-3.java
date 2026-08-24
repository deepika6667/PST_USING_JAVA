DFS:
import java.util.*;

public class DFSPatterns {

    // 1. GRID / MATRIX DFS (Connected Components / Flood Fill)
    public static void floodFill(int[][] g, int r, int c, int oldColor, int newColor) {
        if (r < 0 || r >= g.length || c < 0 || c >= g[0].length || g[r][c] != oldColor || g[r][c] == newColor) return;
        g[r][c] = newColor;
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        for (int[] d : dirs) floodFill(g, r + d[0], c + d[1], oldColor, newColor);
    }

    // 2. BACKTRACKING / SUBSETS
    public static void subsets(int[] nums, int idx, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            subsets(nums, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    // 3. PERMUTATIONS
    public static void permute(int[] nums, boolean[] vis, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) { res.add(new ArrayList<>(path)); return; }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) continue;
            vis[i] = true; path.add(nums[i]);
            permute(nums, vis, path, res);
            path.remove(path.size() - 1); vis[i] = false;
        }
    }

    // 4. GRAPH CYCLE DETECTION (Directed Graph: 0=unvisited, 1=visiting, 2=visited)
    public static boolean hasCycleDirected(List<List<Integer>> adj, int u, int[] state) {
        state[u] = 1;
        for (int v : adj.get(u)) {
            if (state[v] == 1) return true;
            if (state[v] == 0 && hasCycleDirected(adj, v, state)) return true;
        }
        state[u] = 2;
        return false;
    }

    // 5. TOPOLOGICAL SORT (DFS Post-Order)
    public static void topoDFS(List<List<Integer>> adj, int u, boolean[] vis, Deque<Integer> stack) {
        vis[u] = true;
        for (int v : adj.get(u)) if (!vis[v]) topoDFS(adj, v, vis, stack);
        stack.push(u);
    }

    // MAIN METHOD TO RUN TESTS
    public static void main(String[] args) {
        // Test Subsets
        List<List<Integer>> subsetRes = new ArrayList<>();
        subsets(new int[]{1, 2}, 0, new ArrayList<>(), subsetRes);
        System.out.println("Subsets of [1, 2]: " + subsetRes);

        // Test Flood Fill
        int[][] grid = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        floodFill(grid, 0, 0, 1, 2);
        System.out.println("Flood Fill output at (0,0): " + grid[0][0]);
    }
}

OUTPUT:
C:\Users\Admin\Downloads>javac  DFSPatterns.java

C:\Users\Admin\Downloads>java  DFSPatterns
Subsets of [1, 2]: [[], [1], [1, 2], [2]]
Flood Fill output at (0,0): 2
