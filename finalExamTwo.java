public class finalExamTwo {
    public int distanceFinder(TreeNode root, int a, int b){
        if(root == null) return 0;
        return lcaFinder(root,Math.min(a,b), Math.max(a,b));
    }
    private int lcaFinder(TreeNode root, int smaller, int larger){
        TreeNode lca = null;
        while(lca!=root){
            if(root.key < smaller){
                root = root.right;
            } else if (root.key > larger){
                root = root.left;
            } else {
                lca = root;
            }
        }
        return distance(lca, smaller) + distance(lca, larger);
    }
    private int distance(TreeNode root, int a){
        int distance = 0;
        while(root.key!=a){
            if(root.key>a){
                root = root.left;
            } else {
                root = root.right;
            }
            distance++;
        }
        return distance;
    }
    public static void main(String[] args) {
        finalExamTwo a = new finalExamTwo();
        TreeNode root = TreeNode.fromLevelOrder(new Integer[]{4, 2, 6, 1, 3, 5, 7});
        System.out.println(a.distanceFinder(root, 1, 2));
        System.out.println(a.distanceFinder(root, 1, 3));
        System.out.println(a.distanceFinder(root, 1, 4));
        System.out.println(a.distanceFinder(root, 1, 5));
        System.out.println(a.distanceFinder(root, 1, 6));
        System.out.println(a.distanceFinder(root, 1, 7));
    }
}
