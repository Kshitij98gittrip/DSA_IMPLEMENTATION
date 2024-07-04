package BST;

public interface Tree {
     void insert(int data);
     String search(int data);
     void inorderTraversal();
     void preorderTraversal();
     void postorderTraversal();
     int height();
     Node  delete(int data);
     

}
