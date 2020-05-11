import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class LL0104_Maximum_Depth_Of_Binary_Tree
{
    //BSF 广度优先遍历+队列 FIFO
    public int maxDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.add(root);
        while (queue.size()>0)
        {
            int size = queue.size();
            depth++;
            for(int i = 0;i <size;i++)
            {
                TreeNode temp = queue.remove();
                if(temp.left != null)
                {
                    queue.add(temp.left);
                }
                if(temp.right != null)
                {
                    queue.add(temp.right);
                }
            }
        }
        return depth;
    }
}
