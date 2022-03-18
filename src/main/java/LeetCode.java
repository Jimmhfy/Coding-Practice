import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        //Testing only
        TreeNode(int val, int[] leftList, int[]rightList) {
            this.val = val;
            left = new TreeNode();
            right = new TreeNode();
            TreeNode oCurr = left;
            for(int i:leftList){
                oCurr.val = i;
                TreeNode onew = new TreeNode();
                oCurr.left = onew;
                oCurr = oCurr.left;
            }

            oCurr = right;
            for(int i:rightList){
                oCurr.val = i;
                TreeNode onew = new TreeNode();
                oCurr.right = onew;
                oCurr = oCurr.right;
            }
        }
    }
    List<Integer> oResult = new ArrayList();
    public static void main(String args[]) {
        TreeNode oNode = new TreeNode(5, new int[]{4,3,2,1}, new int[]{6,7,8,9});
        System.out.println(inorderTraversal(oNode));
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> oList = new ArrayList();
        Stack<TreeNode> oStack = new Stack();
        while(root!=null || !oStack.isEmpty()){
            while(root!=null){
                oStack.push(root);
                root = root.left;
            }
            TreeNode pre = oStack.pop();
            oList.add(pre.val);
            root = pre.right;
        }
        return oList;
    }
}
