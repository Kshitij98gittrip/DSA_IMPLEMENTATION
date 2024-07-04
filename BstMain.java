/*
 * Question:
Write a program to construct Binary Search Tree with data in sequence 33, 31, 34, 35, 39, 
32, 36, 38, 37, 30.
Perform following operations on the constructed tree.
i. Print inorder traversal
ii. Find height and depth of any given node
iii. Count siblings (pairs of node whose parent is common)
iv. Count full nodes (node with two children’s)
v. Check ancestor or not (take any two nodes from user and check first node is ancestor of 
second node or not)
vi. Find smallest and highest element of tree in O(h) time complexity
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

class Bst{

    private Node root;

    public void insert(int data){
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node root, int data){

        if (root == null){
            root = new Node(data);
            return root;
        }

        if (data < root.data){
            root.left = insertRecursive(root.left, data);
        }
        else if (data > root.data){
            root.right = insertRecursive(root.right, data);
        }
        return root;
    }

    public void inorderTraversal(){
        inorderTraversalRecursive(root);
        System.out.println();
    }

    private void inorderTraversalRecursive(Node root){
        if (root != null){
            inorderTraversalRecursive(root.left);
            System.out.print(root.data+" ");
            inorderTraversalRecursive(root.right);
        }
    }

    public List<List<Integer>> levelOrderTraversal(){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result = levelOrder(root);
        return result;

    }

    private  List<List<Integer>> levelOrder(Node root){

        Queue<Node> queue = new LinkedList<Node>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        if (root == null)
            return wrapList;
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> levelList = new LinkedList<Integer>();
            for (int i = 0; i < levelNum;i++){
                if (queue.peek().left!=null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right!=null)
                    queue.offer(queue.peek().right);
                levelList.add(queue.poll().data);
            }
            wrapList.add(levelList);

        }
        return wrapList;

    
    }

    public int countSibling(){
        return countSiblingRec(root);
    }

    private  int countSiblingRec(Node root){
        if (root == null)
            return 0;
        int count = 0;
        if (root.left!=null && root.right!=null){
            count = 1;
        }

        count += countSiblingRec(root.left);
        count += countSiblingRec(root.right);
        return count;
    }

    public boolean  isAncestor(int data1,int data2){
        return isAncestorRec(root,data1,data2);
    }

    private boolean isAncestorRec(Node root, int dataAncestor,int dataDescendent){
        Node ancestorNode = findNode(root,dataAncestor);
        if (ancestorNode == null){
            return false;
        }
        return findNode(ancestorNode,dataDescendent)!=null;
    }

    private Node findNode(Node node, int data){
        if (node == null || node.data ==data)
            return node;
        
        if (node.data < data)
            return findNode(node.right,data);
        else
            return findNode(node.left, data);
    }   


   
        

}
 public class BstMain{
    public static void main(String[] args) {
        Bst bst = new Bst();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        // bst.insert(80);
        bst.inorderTraversal();
        System.out.println(bst.levelOrderTraversal());
        System.out.println("No of siblings = "+ bst.countSibling());
        System.out.println("Is 70 ancestor of 60 = "+bst.isAncestor(70,60));
        
    }

 }