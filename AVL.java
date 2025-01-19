class Node1 {
    int key, height;
    Node1 left, right;

    Node1(int d) {
        key = d;
        height = 1;
    }
}

public class AVL {

    Node1 root;

    int height(Node1 n) {
        if(n == null){
            return 0;
        }
        return n.height;
    }

    int max(int a,int b){
        return (a>b)? a: b;
    }


    Node1 rightRotate(Node1 y) {
        Node1 x = y.left;
        Node1 T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node1 leftRotate(Node1 x) {
        Node1 y = x.right;
        Node1 T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    int getBalance(Node1 n) {
        if(n == null){
            return 0;
        }
        return height(n.left) - height(n.right);
    }

    Node1 insert(Node1 node, int key) {
        if (node == null) {
            return (new Node1(key));
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node;
        }

        node.height = 1 + max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void printInorder(Node1 node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);

    }

    public static void main(String[] args) {
        AVL tree = new AVL();

        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        System.out.println("Inorder traversal of constructed tree is: ");
        tree.printInorder(tree.root);
    }
}