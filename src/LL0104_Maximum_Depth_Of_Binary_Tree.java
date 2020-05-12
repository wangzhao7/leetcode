import base.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树的最大深度
 */
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

    //递归
    //maxDepth(root) = 1 + maxDepth(root.left) + maxDepth(root.right)
    public int maxDepth1(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int left = maxDepth1(root.left);
        int right = maxDepth1(root.right);
        return 1+Math.max(left,right);
    }

    //DFS 深度优先遍历
    public int maxDepth2(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int depth = 1;
        Stack<Pair<TreeNode,Integer>> stack = new Stack<>();
        stack.add(new Pair(root,1));
        while (stack.size()>0)
        {
            Pair<TreeNode,Integer> pair = stack.pop();
            TreeNode pop = pair.getKey();
            int tmp= pair.getValue();
            if(pop.right != null)
            {
                stack.push(new Pair(pop.right,tmp+1));
                depth = Math.max(depth,tmp+1);
            }
            if(pop.left != null)
            {
                stack.push(new Pair(pop.left,tmp+1));
                depth = Math.max(depth,tmp+1);
            }

        }
        return depth;

    }
}
