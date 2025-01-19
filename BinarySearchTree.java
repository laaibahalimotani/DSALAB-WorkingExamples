class Node2 {
    int key;
    Node2 left,right;

    public Node2(int item){
        key = item;
        left= right = null;
    }
}

public class BinarySearchTree {
    Node2 root;
    BinarySearchTree(int key){
        root = new Node2(key);
    }

    BinarySearchTree(){
        root = null;
    }
    //left->right->root
    void printPostorder(Node2 node){
        if(node == null) return;

        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.key+" ");
    }
    //left->root->right
    void printInorder(Node2 node){
        if(node == null) return;
        printInorder(node.left);
        System.out.print(node.key+" ");
        printInorder(node.right);
    }
    //root->left->right
    void printPreorder(Node2 node){
        if(node == null) return;
        System.out.print(node.key+" ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public Node2 search(Node2 root, int key){
        if(root == null || root.key == key) return root;
        if(root.key>key) return search(root.left,key);

        return search(root.right,key);
    }

    Node2 insertRec(Node2 root, int key){
        if(root == null){
            root = new Node2(key);
            return root;
        }
        else{
            if(key<root.key){
                root.left = insertRec(root.left,key);
            }else if(key >root.key){
                root.right = insertRec(root.right,key);
            }
            return root;
        }
    }

    Node2 deleteRec(Node2 root, int key) {
        if (root == null) return root;
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else{
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    int minValue(Node2 root){
        int minv = root.key;
        while(root.left != null){
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.root = new Node2(10);
        Node2 a = new Node2(4);
        tree.root.left = a;
        Node2 b = new Node2(11);
        tree.root.right = b;

        a.left = new Node2(3);
        a.right = new Node2(5);
        b.left = new Node2(9);
        b.right = new Node2(14);
        System.out.println("Preorder: ");
        tree.printPreorder(tree.root);

        System.out.println("\nPostorder:");
        tree.printPostorder(tree.root);

        System.out.println("\nInorder: ");
        tree.printInorder(tree.root);


    }

}
