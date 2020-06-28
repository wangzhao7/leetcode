import base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 */
public class L0094_BinaryTree_Inorder_Traversal
{
    //递归

    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root)
    {
        if(root == null)
        {
            return result;
        }
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;
    }

    //迭代DFS
    public List<Integer> inorderTraversal_1(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr!=null)
        {
            while (curr!=null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr=curr.right;
        }
        return result;
    }
}
