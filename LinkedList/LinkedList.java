package LinkedList;
public interface LinkedList {

    void addFirst(int data);
    void addLast(int data);
    void insert(int data,int beforeData);
    int deleteFirst();
    int deleteLast();
    // int delete(int data);
    void display();
}
