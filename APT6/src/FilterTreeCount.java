import java.util.*;

public class FilterTreeCount {
    int counter = 0;
    public int count(TreeNode tree, int low, int high) {
        if (tree == null) {
            return 0;
        }
        if (tree != null) {
            if (tree.info>= low && tree.info<=high) {
                counter ++;
            }
        }
        if (tree.left != null) {
            count(tree.left, low, high);
        }
        if (tree.right != null) {
            count(tree.right, low, high);
        }
        return counter;
    }
}