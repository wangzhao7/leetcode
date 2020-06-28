import base.TreeNode;

/**
 * 删除二叉搜索树中的节点
 */
public class LL0450_Delete_Node_In_A_BST
{
    public TreeNode deleteNode(TreeNode root, int key)
    {
        //p指向要删除的节点，初始指向根节点
        TreeNode p = root;
        //pp记录p的父节点
        TreeNode pp = null;
        //找到要删除的节点
        while ( p!= null && p.val != key)
        {
            pp = p;
            if(key>p.val)
            {
                p = pp.right;
            }
            else
            {
                p = p.left;
            }
        }
        if(p == null)
        {
            return null;
        }
        //删除的节点有两个子节点
        if(p.right != null && p.left != null)
        {
            TreeNode miniP = p.right;
            //miniPP标识miniP的父节点
            TreeNode miniPP = p;
            while (miniP.left != null)
            {
                miniPP = miniP;
                miniP = miniP.left;
            }
            p.val = miniP.val;
            p = miniP;
            //删除miniP
            pp = miniPP;
        }
        return null;
    }
}
