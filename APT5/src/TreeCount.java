import java.util.LinkedList;
import java.util.*;

public class TreeCount {
    int counter = 0;
    public int count(TreeNode tree) {

        if (tree == null) {
            return 0;
        }
        if (tree != null) {
            counter ++;
        }
        if (tree.left != null) {
            count(tree.left);
        }
        if (tree.right != null) {
            count(tree.right);
        }
        return counter;
    }
}