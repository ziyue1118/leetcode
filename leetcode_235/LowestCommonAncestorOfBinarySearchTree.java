public class LowestCommonAncestorOfBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (isDescendant(p, q)) {
            return p;
        }
        if (isDescendant(q, p)) {
            return q;
        }
        if ((root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val)) {
            return root;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root; // It is possible that p and q are the same TreeNode, in that case return root is reasonable.
    }
    // Check if q is a descendant of p
    public boolean isDescendant(TreeNode p, TreeNode q) {
        if (p.left == q || p.right == q) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //      _______6______
        //     /              \
        //  ___2__          ___8__
        // /      \        /      \
        // 0      _4       7       9
        //       /  \
        //       3   5
        TreeNode root = new TreeNode(6);
        TreeNode node10 = new TreeNode(2);
        TreeNode node11 = new TreeNode(8);
        TreeNode node20 = new TreeNode(0);
        TreeNode node21 = new TreeNode(4);
        TreeNode node22 = new TreeNode(7);
        TreeNode node23 = new TreeNode(9);
        TreeNode node30 = new TreeNode(3);
        TreeNode node31 = new TreeNode(5);
        root.left = node10;
        root.right = node11;
        node10.left = node20;
        node10.right = node21;
        node11.left = node22;
        node11.right = node23;
        node21.left = node30;
        node21.right = node31; 
        LowestCommonAncestorOfBinarySearchTree lCA = new LowestCommonAncestorOfBinarySearchTree();
        System.out.println(lCA.lowestCommonAncestor(root, node10, node11).val);
        System.out.println(lCA.lowestCommonAncestor(root, node10, node21).val);
    }
}