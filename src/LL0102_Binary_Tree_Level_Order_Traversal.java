import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的层序遍历
 * 2020-05-08
 * wz
 */
public class LL0102_Binary_Tree_Level_Order_Traversal
{
    //BSF广度优先遍历
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        if(root == null)
        {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size()>0)
        {
            //获取当前队列的长度，当前这一层节点个数
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode treeNode = queue.remove();
                tmp.add(treeNode.val);
                if(treeNode.left != null)
                {
                    queue.add(treeNode.left);
                }
                if(treeNode.right != null)
                {
                    queue.add(treeNode.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }


}

