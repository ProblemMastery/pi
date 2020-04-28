package Trees;

import javax.swing.*;
import java.util.*;

import StringManipulation.*;

public class BST<Integer> {

    private Node root;             // root of BST

    static class Node {
        private int key;           // sorted by key
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(int key) {
            this.key = key;
        }

        public String toString(){
            String keyInString = StringManipulationProblems.intToString(key);
            return keyInString;

        }
    }

    public BST(){
        this.root = null;
    }
    public Node getRoot(){
        return this.root;
    }

    public void delete(int key){
        delete(root, key);
    }

    private Node delete(Node node, int key){
        if(node == null){
            return null;
        }
        int cmp = key - node.key;
        if(cmp  > 0)
            node.right = delete(node.right, key);
        else if(cmp < 0)
            node.left = delete(node.left, key);
        else {
            // cmp ==0
            if(node.right == null){
                return node.left;
            }
            if( node.left == null){
                return node.right;
            }
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;

        }
        return node;
    }

    private Node deleteMin(Node node){
        if(node.left == null){
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    public int get(int key){
        return get(root, key).key;
    }

    private Node get(Node node, int key){
        if(key == node.key)
            return node;

        int cmp = key - node.key;
        if(cmp > 0)
            return get(node.right, key);
        else if(cmp < 0)
            return get(node.left, key);
        return node;
    }

    public void insert(int key){
        Node node = insert(root, key);
        if (root == null)
            root = node;
    }
    private Node insert(Node node, int key){
        if(node == null){
            return new Node(key);
        }
        int cmp = key-node.key;
        if(cmp > 0)
            node.right  = insert(node.right, key);

        if(cmp <0)
            node.left = insert(node.left, key);
        return node;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        else                return min(x.left);
    }

    public Iterable<java.lang.Integer> levelOrder(){
        Queue<java.lang.Integer> keys = new LinkedList<>();
        Queue<Node> nodeQueue = new LinkedList<Node>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()){
            Node current = nodeQueue.remove();
            if( current == null)
                continue;
            keys.add(current.key);
            nodeQueue.add(current.left);
            nodeQueue.add(current.right);
        }

        return keys;
    }

    /*
    find if BST is balanced
     */
    public boolean isBalanced(Node root){
        if(checkHeight(root)== -1){
            return false;
        }
        return true;
    }

    public int checkHeight(Node node){
        if(node == null)
            return 0;
        int leftHeight = checkHeight(node.left);
        if(leftHeight == -1)
            return -1;
        int rightHeight = checkHeight(node.right);
        if(rightHeight ==-1)
            return -1;
        int heightDiff = Math.abs(leftHeight-rightHeight);
        //at any stage if height is greater than 1, return -1
        if(heightDiff > 1)
            return -1;
        int height = Math.max(leftHeight,rightHeight)+1;
        // if height diff is not greater than 1, return the height at each stage
        return height;
    }

    /*
    inorder recursive
     */

    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + "\t");
            inorder(root.right);
        }
    }

    public static void main(String [] args){
        BST bst = new BST();
        int [] key = new int[]{50, 30, 20, 40, 75, 60,80,10,25,35,45};
        for (int c : key){
            bst.insert(c);
        }
        bst.insert(47);


        Iterator itr =  bst.levelOrder().iterator();

        while(itr.hasNext()){
            System.out.print(itr.next()+"\t");
        }

        System.out.println("\nInOrder Traversal is");
        bst.inorder(bst.getRoot());

        //check if tree is balanced, result returned for the above tree is false
        //if 0 is removed the result is balanced.
        boolean isBalanced = bst.isBalanced(bst.getRoot());

        System.out.println("\nIsTreeBalanced ? "+isBalanced);
    }


}
