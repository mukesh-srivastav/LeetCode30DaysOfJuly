/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */
import java.util.*;
public class Day2_BottomUpLevelOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left, right;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        
        if (root == null)
            return res;
        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        
        while (q.isEmpty() == false) {
            TreeNode curr = q.poll();
            
            if (curr == null) {
                stack.push(list);
                list = new LinkedList<>();
                if (!q.isEmpty())
                 q.add(null);
                continue;
            }
            list.add(curr.val);
            
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right !=null)
                q.add(curr.right);
        }
        
        while (stack.isEmpty() == false)
            res.add(stack.pop());
        
        return res;
    }
}