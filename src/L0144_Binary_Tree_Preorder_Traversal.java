import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前序遍历
 */
public class L0144_Binary_Tree_Preorder_Traversal
{
    //递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List result = new ArrayList();
        return helper(root,result);
    }

    public List<Integer> helper(TreeNode node,List result)
    {
        if(node != null)
        {
            result.add(node.val);
            helper(node.left,result);
            helper(node.right,result);
        }
        return result;
    }
}
