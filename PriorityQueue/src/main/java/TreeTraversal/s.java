package TreeTraversal;

import java.util.Arrays;

class Node {
    int key;
    Node left, right;

    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}

class BinaryTree {
    // Root of Binary Tree
    Node root;

    BinaryTree() {
        root = null;
    }
    //   +
    //1     2
    public void inOrder (Node root){
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.key);
        inOrder(root.right);
    }

    public void printInorder(){
        inOrder(root);
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);


        System.out.println(
                "\nInorder traversal of binary tree is ");


    }
}

