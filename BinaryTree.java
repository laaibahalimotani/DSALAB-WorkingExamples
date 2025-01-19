public class BinaryTree {
    static class Node{
        int key;
        Node left,right;
        public Node(int item){
           key=item;
           left=right=null;
        }
    }

        Node root;
        public BinaryTree(int key){
            root=new Node(key);
        }
        BinaryTree(){root=null;}


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root=new Node(1);
        Node a = new Node(2);
        tree.root.left=a;
        Node b = new Node(3);
        tree.root.right=b;
        a.left=new Node(4);
        a.right=new Node(5);
        System.out.println("Pre-Order: ");
        tree.printPreorder(tree.root);
        System.out.println("\nIn-Order: ");
        tree.printInorder(tree.root);
        System.out.println("\nPost-Order: ");
        tree.printPostorder(tree.root);
        System.out.println("\nLevels of tree: "+tree.calculateLevel(tree.root));
        System.out.println("Children sum property: "+tree.hasChildrenSumProperty(tree.root));
      /*  System.out.println("Is tree full: "+tree.isTreeFull(tree.root));
        System.out.println("Is tree complete: "+tree.isTreeComplete(tree.root));*/
        System.out.println(tree.checkTreeType(tree.root));


    }
    //root->left->right
    void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.key+" ");
        printPreorder(node.left);
        printPreorder(node.right);

    }
    //left->root->right
    void printInorder(Node node){
            if(node==null){
                return;
            }
        printInorder(node.left);
        System.out.print(node.key+" ");
        printInorder(node.right);

    }
    //left->right->root
    void printPostorder(Node node){
            if(node==null){
                return;
            }
            printPostorder(node.left);
            printPostorder(node.right);
            System.out.print(node.key+" ");

    }
    //node==root
    int calculateLevel(Node node){
            if(node==null){
                return 0;
            }
            int leftLevel= calculateLevel(node.left);
            int rightLevel= calculateLevel(node.right);
            return 1+ Math.max(leftLevel,rightLevel);
    }
    boolean isTreeFull(Node node) {
        if (node == null) { //empty tree
            return true;
        }
        if(node.left==null && node.right==null){ //no children
            return true;
        }
        if(node.left!=null && node.right!=null){ //recursively checking for left and right subtrees if both children are present
            return isTreeFull(node.left) && isTreeFull(node.right);
        }
        return false;
    }
    String checkTreeType(Node node) {
        boolean isFull = isTreeFull(node);
        boolean isComplete = isTreeComplete(node);

        if (isFull && isComplete) {
            return "The tree is both FULL and COMPLETE.";
        } else if (isFull) {
            return "The tree is FULL but not COMPLETE.";
        } else if (isComplete) {
            return "The tree is COMPLETE but not FULL.";
        } else {
            return "The tree is neither FULL nor COMPLETE.";
        }
    }

    boolean hasChildrenSumProperty(Node node){
            //empty tree or leaf nodes
            if(node==null||node.left==null&&node.right==null){
                return true;
            }
            int leftValue= (node.left!=null)?node.left.key:0;
            int rightValue= (node.right!=null)?node.right.key:0;
            if(node.key==leftValue+rightValue && hasChildrenSumProperty(node.left) && hasChildrenSumProperty(node.right)){
                return true;
            }
            return false;
    }
    int countNodes(Node node){
            if(node==null){
                return 0;
            }
            return 1+ countNodes(node.left) +countNodes(node.right);
    }
    boolean isTreeComplete(Node node){
            int totalNodes = countNodes(node);
            return isTreeCompleteHelper(node, 0, totalNodes);
    }
    boolean isTreeCompleteHelper(Node node, int index, int totalNodes){
            if(node==null){
                return true;
            }
            if(index>=totalNodes){
                return false;
            }
            return isTreeCompleteHelper(node.left,2*index+1,totalNodes)&&isTreeCompleteHelper(node.right,2*index+2,totalNodes);
    }
}
