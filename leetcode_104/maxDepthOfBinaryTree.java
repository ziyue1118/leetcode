public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
    public static void main(String[] args){
        //          a
        //         / \
        //        b   c
        //       / \
        //      d   e
        //     /
        //    f
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(1);
        TreeNode f = new TreeNode(1);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        d.left = f;
        MaxDepthOfBinaryTree mdbt = new MaxDepthOfBinaryTree();
        System.out.println(mdbt.maxDepth(a));
    }
}