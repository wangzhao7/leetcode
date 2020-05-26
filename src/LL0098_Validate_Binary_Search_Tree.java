import base.TreeNode;

import java.util.Stack;

/**
 * 验证二叉搜索树
 * 2020-05-21
 * wz
 */
public class LL0098_Validate_Binary_Search_Tree
{
    //二叉查找树中序遍历，升序排序。
    //中序迭代
    public boolean isValidBST(TreeNode root)
    {
        if(root == null)
        {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();

        Integer preValue = null;

        while (!stack.isEmpty() || root != null)
        {
            //中序遍历
            while (root != null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if(preValue == null)
            {
                preValue = root.val;
            }
            else if(preValue >= root.val)
            {
                return  false;
            }
            preValue = root.val;
            root = root.right;
        }
        return true;
    }

    //递归
    public boolean isValidBST_1(TreeNode root)
    {
        return helper(root,null,null);
    }

    public boolean helper(TreeNode root, Integer lower, Integer upper)
    {
        if(root == null)
        {
            return true;
        }
        int val = root.val;
        if(lower !=null && val<=lower)
        {
            return false;
        }
        if(upper !=null && val>=upper)
        {
            return false;
        }
        if(!helper(root.left,lower,val))
        {
            return false;
        }
        if (!helper(root.right,val,upper))
        {
            return false;
        }
        return true;
    }
}
