public class LevelCount {
    int counter = 0;
    int myLevel = 0;
//    int howmany = 0;
    public int count(TreeNode t, int level) {
        if (t == null) {
            return 0;
        }
        else if (level == 0) {
            return 1;
        }
        myLevel = level;
        findthem(t, myLevel);
        return counter;
    }

    private void findthem(TreeNode t, int level) {
        if (level == 0) {
            counter ++;
            return;
        }
        if (t.left != null) {
            findthem(t.left, level-1);
        }
        if (t.right != null) {
            findthem(t.right, level-1);
        }
    }
}