import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: LiuZ
 * Date: 2022/8/1
 * Time: 15:49
 * Description:
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x; }

    public static TreeNode constructTree(Integer[] nums){

        if (nums.length == 0) return new TreeNode(0);
        Deque<TreeNode> nodeQueue = new LinkedList<>();

        TreeNode root = new TreeNode(nums[0]);
        nodeQueue.offer(root);
        TreeNode cur;
        // 记录当前行节点的数量（注意不一定是2的幂，而是上一行中非空节点的数量乘2）
        int lineNodeNum = 2;
        // 记录当前行中数字在数组中的开始位置
        int startIndex = 1;
        // 记录数组中剩余的元素的数量
        int restLength = nums.length - 1;

        while(restLength > 0) {
            for (int i = startIndex; i < startIndex + lineNodeNum; i = i + 2) {

                // 说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
                if (i == nums.length) return root;
                cur = nodeQueue.poll();
                if (nums[i] != null) {

                    cur.left = new TreeNode(nums[i]);
                    nodeQueue.offer(cur.left);
                }
                // 同上，说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
                if (i + 1 == nums.length) return root;
                if (nums[i + 1] != null) {

                    cur.right = new TreeNode(nums[i + 1]);
                    nodeQueue.offer(cur.right);
                }
            }
            startIndex += lineNodeNum;
            restLength -= lineNodeNum;
            lineNodeNum = nodeQueue.size() * 2;
        }

        return root;
    }
    public static void preOrder(TreeNode root) {
        //前序排列
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void midOrder(TreeNode root) {
        //中序排列
        if (root == null) return;
        midOrder(root.left);
        System.out.print(root.val + " ");
        midOrder(root.right);
    }
    public static void aftOrder(TreeNode root) {
        //后序排列
        if (root == null) return;
        aftOrder(root.left);
        aftOrder(root.right);
        System.out.print(root.val + " ");
    }



    public static void main(String[] args) {

        Integer[] nums = {1,2,2,3,3,3,3};
        TreeNode tree=constructTree(nums);
        preOrder(tree);
        System.out.println();
        midOrder(tree);
        System.out.println();
        aftOrder(tree);

    }
}