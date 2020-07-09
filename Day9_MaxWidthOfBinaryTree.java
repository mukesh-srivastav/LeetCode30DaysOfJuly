import java.util.*;
/**
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:

Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:

Input: 

          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:

Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:

Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 */
public class Day9_MaxWidthOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left, right;
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        
        Deque<TreeNode> dq = new LinkedList<>();
        dq.add(root);
        int max = 0;
        
        while (dq.isEmpty() == false) {
            int size = dq.size();
            max = Math.max(size, max);
            for (int i=0; i<size; i++) {
                TreeNode curr = dq.poll();
                
                if (curr == null) {
                    dq.add(null);
                    dq.add(null);
                } else {
                    dq.add(curr.left);
                    dq.add(curr.right);
                }
            }
            // Remove all the null nodes from left until we hit non null leftmost node
            while (!dq.isEmpty() && dq.peekFirst() == null)
                dq.pollFirst();
            // Remove all the null nodes from right until we hit non null rightmost node
            while (!dq.isEmpty() && dq.peekLast() == null)
                dq.pollLast();
        }
        
        return max;
    }
}