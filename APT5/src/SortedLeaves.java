import java.util.ArrayList;
import java.util.Collections;

public class SortedLeaves {
    ArrayList<String> myList = new ArrayList();
    public String[] values(TreeNode tree) {
        //ArrayList<String> myList = new ArrayList<>();
        doWork(tree);
        Collections.sort(myList);
        return myList.toArray(new String[0]);
    }

    public void doWork(TreeNode tree) {
        if (tree == null) {
            return;
        }
        if (tree.left == null && tree.right == null) {
            myList.add("" + ((char)tree.info));
        }
        else {
            doWork(tree.left);
            doWork(tree.right);
        }
    }
}