package BST;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

public class Bst implements Tree{

    

    Node root;

    public Bst(){
        root = null;
    }


    @Override
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

    @Override
     public String search(int data){
        Node searchedNode = searchRecursive(root,data);

        return searchedNode!=null ? "Data found": "Data not found";

     }

     private Node searchRecursive(Node root,int data){

        if (root == null || root.data == data){
            return root;
        }

        if (data < root.data){
            return searchRecursive(root.left, data);
        }

        return searchRecursive(root.right, data);
     }
    
    
     @Override
     public int height(){
        return heightRecursive(root);
     }

     private int heightRecursive(Node root){

        if (root == null){
            return 0;
        }

        int leftHeight = heightRecursive(root.left);
        int rightHeight = heightRecursive(root.right);

        if (leftHeight > rightHeight)
            return 1 + leftHeight;
        
        return 1 + rightHeight;
     }

     @Override
     public Node delete(int data){
        return deleteNode(root, data);
     }

     private Node deleteNode(Node root, int data){
        if (root==null){
            return null;
        }

        if (root.data == data){
            return helper(root);
        }

        Node temp = root;
        while (root!= null){
            if (root.data >data){
                if (root.left != null && root.left.data == data){
                    root.left = helper(root.left);
                    break;
                }
                else{
                    root = root.left;
                }
            }
            else{
                if ( root.right != null && root.right.data==data){
                    root.right = helper(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
        }

        return temp;
     }

     private Node helper(Node root){
        if (root.left == null){
            return root.right;
        }
        else if (root.right == null){
            return root.left;
        }

        Node rightChild = root.right;
        Node lastRight = findLastRight(root.left);
        lastRight.right = rightChild;
        return root.left;
     }

     private Node findLastRight(Node root){
        if (root.right == null){
            return root; 
        }
        return findLastRight(root.right);
     }


     @Override
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

     @Override
     public void preorderTraversal(){
        preorderTraversalRecursive(root);
        System.out.println();
     }

     private void preorderTraversalRecursive(Node root){
        if (root != null){
            System.out.print(root.data+" ");
            preorderTraversalRecursive(root.left);
            preorderTraversalRecursive(root.right);
        }
     }
     public void postorderTraversal(){
        postorderTraversalRecursive(root);
        System.out.println();
     }

     private void postorderTraversalRecursive(Node root){
        if (root != null){
            postorderTraversalRecursive(root.left);
            postorderTraversalRecursive(root.right);
            System.out.print(root.data +" ");
        }
     }


     public static void main(String[] args) {
         Tree tree = new Bst();
         tree.insert(10);
         tree.insert(5);
         tree.insert(15);
         tree.insert(3);
         tree.insert(7);
         tree.insert(12);
         tree.insert(18);
         System.out.println("Inorder traversal");
         tree.inorderTraversal();
         System.out.println("Preorder traversal");
         tree.preorderTraversal();
         System.out.println("Postorder traversal");
         tree.postorderTraversal();

         System.out.println("Height of bst is "+ tree.height());
         System.out.println("Is 12 present in bst ? "+ tree.search(12));
         Node root = tree.delete(5);
         System.out.println("Preorder traversal after deletion of 5");
         tree.preorderTraversal();



     }
    
}
