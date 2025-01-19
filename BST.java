import java.util.*;
class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BST {

    // Convert sorted array to Binary Search Tree
    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);

        return root;
    }

    // Convert Binary Tree to Binary Search Tree
    public static TreeNode binaryTreeToBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inOrderCollect(root, values);
        Collections.sort(values);
        return buildBSTFromSortedList(values, 0, values.size() - 1);
    }

    private static void inOrderCollect(TreeNode node, List<Integer> values) {
        if (node == null) return;
        inOrderCollect(node.left, values);
        values.add(node.value);
        inOrderCollect(node.right, values);
    }

    private static TreeNode buildBSTFromSortedList(List<Integer> values, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(values.get(mid));

        root.left = buildBSTFromSortedList(values, start, mid - 1);
        root.right = buildBSTFromSortedList(values, mid + 1, end);

        return root;
    }

    // Utility function to print in-order traversal of the tree
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.value + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        // Convert sorted array to BST
        int[] sortedArray = {-10, -3, 0, 5, 9};
        TreeNode bstFromArray = sortedArrayToBST(sortedArray);
        System.out.print("In-order Traversal of BST from Sorted Array: ");
        printInOrder(bstFromArray);
        System.out.println();

        // Convert Binary Tree to BST
        TreeNode binaryTree = new TreeNode(10);
        binaryTree.left = new TreeNode(2);
        binaryTree.right = new TreeNode(7);
        binaryTree.left.left = new TreeNode(8);
        binaryTree.left.right = new TreeNode(4);

        TreeNode bstFromBinaryTree = binaryTreeToBST(binaryTree);
        System.out.print("In-order Traversal of BST from Binary Tree: ");
        printInOrder(bstFromBinaryTree);
    }
}
