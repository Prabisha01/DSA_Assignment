package QuestionTwo;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solve {
    // Main function to calculate the minimum number of service centers required
    public int minServiceCenters(TreeNode root) {
        int[] ans = new int[]{0}; // ans[0] stores the result
        int[] unserviced = new int[]{0}; // unserviced[0] stores the number of unserviced cities
        dfs(root, unserviced);
        ans[0] = (int) Math.ceil(unserviced[0] / 2.0); // minimum number of service centers required
        return ans[0];
    }

    // DFS function to calculate the number of unserviced cities
    private void dfs(TreeNode node, int[] unserviced) {
        if (node == null) return; // return if node is null
        unserviced[0]++; // increment unserviced city count by 1
        dfs(node.left, unserviced); // call dfs on left child node
        dfs(node.right, unserviced); // call dfs on right child node
    }
}

public class Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(0);
        Solve solve = new Solve();
        System.out.println("Minimum number of service centers required: " + solve.minServiceCenters(root));
    }
}

