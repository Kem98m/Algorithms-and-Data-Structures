import java.util.*;

public class MaxLeaves {
    ArrayList<Integer> myints = new ArrayList<>();
    ArrayList<Integer> myleaves = new ArrayList<>();
    public int[] gather(TreeNode tree) {
        int myheight = height(tree);
        inOrder(tree, myheight);
        int[] ret = new int[myints.size()];
        for (int k = 0; k<myints.size(); k++) {
            ret[k] = myints.get(k);
        }
        //Collections.addAll(ret, myints);
        //return new int[tree.info];
        return ret;
    }

    public int height(TreeNode tree) {
        if (tree == null) return 0;
        return 1 + Math.max(height(tree.left), height(tree.right));
    }

    public void inOrder(TreeNode t, int level) {

        if (t != null) {
            inOrder(t.left, level-1);
            // if ()
            //myints.add(t.info);
            //System.out.println(t.info);
            if (level == 1) {
                myints.add(t.info);
            }
            inOrder(t.right, level-1);
        }
    }
    public void findthem(TreeNode t, int level) {
        if (level == 0) {
            //if (t.right == null && t.left == null) {
            myleaves.add(t.info);
        }
        if (t.left != null) {
            findthem(t.left, level-1);
        }
        if (t.right != null) {
            findthem(t.right, level-1);
        }
    }
}