class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode node, int lower, int upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;
        if (val <= lower || val >= upper) {
            return false;
        }

        if (!isValidBSTHelper(node.right, val, upper)) {
            return false;
        }
        if (!isValidBSTHelper(node.left, lower, val)) {
            return false;
        }

        return true;
    }

    // Example usage:
    public static void main(String[] args) {
        TreeNode a = new TreeNode(7);
        TreeNode b = new TreeNode(11);
        TreeNode c = new TreeNode(10, a, b); // create left subtree

        TreeNode d = new TreeNode(21);
        TreeNode e = new TreeNode(27);
        TreeNode f = new TreeNode(22, d, e); // create right subtree

        TreeNode root = new TreeNode(20, c, f);

        Solution helper = new Solution();
        System.out.println(helper.isValidBST(root)); // Output: true
    }
}
