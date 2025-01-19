import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private TreeNode root;

    private static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void createBinaryTree() {
    TreeNode first = new TreeNode(1);
    TreeNode second = new TreeNode(2);
    TreeNode third = new TreeNode(3);
    TreeNode fourth = new TreeNode(4);
    TreeNode fifth = new TreeNode(5);

    root =first;
    first.left=second;
    first.right=third;
    second.left=fourth;
    second.right=fifth;
}
  // left-> root-> right
   public void inorderTraversal(TreeNode root) {
       if (root != null) {
           inorderTraversal(root.left);
           System.out.print(root.data + " ");
           inorderTraversal(root.right);
       }
   }
   //root-> left-> right
   public void preorderTraversal(TreeNode root){
       if(root!=null){
           System.out.print(root.data+" ");
           preorderTraversal(root.left);
           preorderTraversal(root.right);
       }
    }
    //left-> right-> root
    public void postorderTraversal(TreeNode root){
        if(root!=null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.data+" ");
        }
    }
    public void levelOrderTraversal(TreeNode root){
        if(root==null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp.data+" ");
            if(temp.left!=null){
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.createBinaryTree();
        System.out.println("Inorder Traversal: ");
        tree.inorderTraversal(tree.root);
        System.out.println("\nPreorder Traversal: ");
        tree.preorderTraversal(tree.root);
        System.out.println("\nPostorder Traversal: ");
        tree.postorderTraversal(tree.root);
        System.out.println("\nLevel order Traversal: ");
        tree.levelOrderTraversal(tree.root);

    }
}