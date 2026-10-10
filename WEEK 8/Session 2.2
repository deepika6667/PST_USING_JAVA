import java.util.*;
import java.io.*;

enum Color {
    RED, GREEN
}

abstract class Tree {
    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {
    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);
        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {
    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);
}

/* ==========================================================================
   PART I: Visitor Implementation
   ========================================================================== */

class SumInLeavesVisitor extends TreeVis {
    private int sum = 0;

    public int getResult() {
        return sum;
    }

    public void visitNode(TreeNode node) {
        // Non-leaf nodes are not included in the leaf sum calculation
    }

    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}

class ProductRedNodesVisitor extends TreeVis {
    private long product = 1;
    private final int MOD = 1000000007;

    public int getResult() {
        return (int) product;
    }

    private void multiplyIfRed(Tree node) {
        if (node.getColor() == Color.RED) {
            product = (product * node.getValue()) % MOD;
        }
    }

    public void visitNode(TreeNode node) {
        multiplyIfRed(node);
    }

    public void visitLeaf(TreeLeaf leaf) {
        multiplyIfRed(leaf);
    }
}

class FancyVisitor extends TreeVis {
    private int nonLeafEvenDepthSum = 0;
    private int greenLeafSum = 0;

    public int getResult() {
        return Math.abs(nonLeafEvenDepthSum - greenLeafSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            nonLeafEvenDepthSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenLeafSum += leaf.getValue();
        }
    }
}

/* ==========================================================================
   PART II: Tree Parsing Implementation
   ========================================================================== */

public class Solution {
  
    public static Tree solve() {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return null;
        
        int n = scanner.nextInt();
        int[] values = new int[n + 1];
        Color[] colors = new Color[n + 1];

        for (int i = 1; i <= n; i++) {
            values[i] = scanner.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            colors[i] = (scanner.nextInt() == 0) ? Color.RED : Color.GREEN;
        }

        // Adjacency list to build undirected representation first
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adjList.put(i, new HashSet<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        scanner.close();

        // Edge case: single node tree
        if (n == 1) {
            return new TreeLeaf(values[1], colors[1], 0);
        }

        // Store generated Tree references to dynamically form parent-child connections
        Tree[] treeNodes = new Tree[n + 1];
        
        // BFS to reliably figure out parent-child directions, depths, and structural node types
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        // Root is always node 1, depth 0
        queue.add(1);
        visited[1] = true;
        
        // Root configuration check: if node 1 has neighbor nodes, it's a structural TreeNode
        treeNodes[1] = new TreeNode(values[1], colors[1], 0);

        while (!queue.isEmpty()) {
            int currentId = queue.poll();
            Tree currentTreeObj = treeNodes[currentId];

            for (int neighborId : adjList.get(currentId)) {
                if (!visited[neighborId]) {
                    visited[neighborId] = true;
                    int childDepth = currentTreeObj.getDepth() + 1;

                    // If neighbor has connections other than its parent, it's a TreeNode, else it's a leaf
                    boolean isLeaf = (adjList.get(neighborId).size() == 1);
                    
                    if (isLeaf) {
                        treeNodes[neighborId] = new TreeLeaf(values[neighborId], colors[neighborId], childDepth);
                    } else {
                        treeNodes[neighborId] = new TreeNode(values[neighborId], colors[neighborId], childDepth);
                    }

                    // Append child instance to the current TreeNode instance
                    ((TreeNode) currentTreeObj).addChild(treeNodes[neighborId]);
                    queue.add(neighborId);
                }
            }
        }

        return treeNodes[1];
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor v1 = new SumInLeavesVisitor();
        ProductRedNodesVisitor v2 = new ProductRedNodesVisitor();
        FancyVisitor v3 = new FancyVisitor();

        root.accept(v1);
        root.accept(v2);
        root.accept(v3);

        int res1 = v1.getResult();
        int res2 = v2.getResult();
        int res3 = v3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}


output
Input (stdin)
5
4 7 2 5 12
0 1 0 0 1
1 2
1 3
3 4
3 5
Expected Output
24
40
15
