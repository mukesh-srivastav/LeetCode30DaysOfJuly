/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */
public class Day27_ConstructBinaryTreeFromInOrderAndPostOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return construct(inorder, 0, inorder.length - 1, postorder, postorder.length -1);
    }
    
    TreeNode construct(int[] inorder, int low, int high, int[] postorder, int key) {
        if (key > postorder.length - 1 || key < 0)
            return null;
        if (low>high) return null;
        
        TreeNode root = new TreeNode (postorder[key]);
        
        int i = low;
        
        while (inorder[i] != postorder[key]) i++;
        
        
        
        root.left = construct(inorder, low, i - 1, postorder, key - (high-i)- 1);
        root.right = construct(inorder, i + 1, high, postorder, key - 1);
        
        return root;
    }
}