
import java.util.*;

public class AllPaths {
    //ArrayList<String> myList = new ArrayList();
    public String[] paths(TreeNode t) {
        if (t == null) {
            return new String[0];
        }
        ArrayList<String> ret = doWork(t);
        Collections.sort(ret);
        return ret.toArray(new String[0]);
    }

    public ArrayList<String> doWork(TreeNode tree) {
        if (tree.left == null && tree.right == null) {
            ArrayList<String> baselist = new ArrayList<>();
            baselist.add(tree.info + "");
            return baselist;
        }
        else {
            ArrayList<String> list = new ArrayList<>();
            if (tree.left != null) {
                ArrayList<String> lefty = doWork(tree.left);
                for (String str : lefty) {
                    list.add(tree.info + "->" + str);
                }
            }
            if (tree.right != null) {
                ArrayList<String> righty = doWork(tree.right);
                for (String str : righty) {
                    list.add(tree.info + "->" + str);
                }
            }
            return list;
        }
    }
}

