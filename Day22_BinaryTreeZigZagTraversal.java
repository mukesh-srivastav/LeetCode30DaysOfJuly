/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
import java.util.*;
public class Day22_BinaryTreeZigZagTraversal {
    public class TreeNode {
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
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null)
            return res;
        
        boolean leftToRight = true;
        Deque<TreeNode> dq = new LinkedList<>();
        
        dq.add(root);
        
        while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> level = new LinkedList<>();
            while (size-- > 0) {
                TreeNode curr;
                if (leftToRight) {
                    curr = dq.pollLast();
                    if (curr.left != null)
                        dq.offerFirst(curr.left);
                    if (curr.right != null)
                        dq.offerFirst(curr.right);
                } else {
                    curr = dq.pollFirst();
                    if (curr.right != null)
                        dq.offerLast(curr.right);
                    if (curr.left != null)
                        dq.offerLast(curr.left);
                }
                
                level.add(curr.val);
            }
            res.add(level);
            leftToRight = !leftToRight;
        }
        
        return res;
    }
}