import com.flipthebird.gwthashcodeequals.EqualsBuilder;
import javafx.scene.text.HitInfo;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {
     static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
         public String toString() {
            if(this == null) return "null";
            return val + (left == null ? "null" : left.toString()) + (right == null ? "null" : right.toString());
         }
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root == null) return "";
        String res = "";
        Queue<TreeNode> oQueue = new LinkedList();
        oQueue.offer(root);
        while(!oQueue.isEmpty()){
            int size = oQueue.size();
            boolean hasValue = false;
            for(int i = 0; i<size;i++){
                TreeNode curr = oQueue.poll();
                if(!res.isEmpty())
                    res+=",";
                res += curr == null? "null" :curr.val;
                if(curr!=null && (curr.left != null || curr.right != null))
                    hasValue = true;
                oQueue.offer(curr == null? null :curr.left);
                oQueue.offer(curr == null? null :curr.right);
            }
            if(!hasValue)
                break;
        }
        System.out.println(res);
        return res;
    }


    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] dataArray = data.split(",");
        int iCount = 0;
        TreeNode root = new TreeNode(Integer.valueOf(dataArray[iCount]));
        Queue<TreeNode> node = new LinkedList();
        node.offer(root);
        while(iCount != dataArray.length-1){
            TreeNode curr = node.poll();
            TreeNode left = dataArray[++iCount].equals("null") ? null : new TreeNode(Integer.valueOf(dataArray[iCount]));
            TreeNode right = dataArray[++iCount].equals("null") ? null : new TreeNode(Integer.valueOf(dataArray[iCount]));
            if(curr!=null){
                curr.left = left;
                curr.right = right;
            }
            node.offer(left);
            node.offer(right);
        }
        return root;
    }
}
