public class LeafSum {
    int sum = 0;
    public int sum(TreeNode t) {
        if (t == null) {
            return 0;
        }
        if (t.left == null && t.right == null) {
            sum = sum + t.info;
        }
        if (t.left != null) {
            sum(t.left);
        }
        if (t.right != null) {
            sum(t.right);
        }
        return sum;
    }
}