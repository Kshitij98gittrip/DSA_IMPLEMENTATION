package LinkedList;


public class CircularSinglyLinkedList  {

    class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    private Node head,tail;

    CircularSinglyLinkedList(){
        head = null;
        tail = null;
    }

    public void addFirst(int data){

        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            tail = newNode;
            tail.next = head;
        }
        else {
            newNode.next = head;
            head = newNode;
            tail.next = head;

        }
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if (tail == null){
            tail = newNode;
            head = newNode;
            tail.next = head;
        }
        else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }   

    public int deleteFirst(){

        if (head == null){
            return -1;
        }
        if (head.next == null){
            int temp = head.data;
            head = null;
            tail = null;
            return temp;
        }
        else {
            int temp = head.data;
            head = head.next;
            tail.next = head;
            return temp;
        }
    }

    public int deleteLast(){

        if (tail == null){
            return -1;
        }
        if (head.next == null){
            int temp = tail.data;
            tail = null;
            head = null;
            return temp;
        }

        Node curNode = head;
        // Node previous = null;
        while (curNode.next != tail){
            // previous = curNode;
            curNode = curNode.next;
        }

        int data = tail.data;
        curNode.next = head;
        tail = curNode;
        // previous.next = head;
        // tail = previous;
        // tail.next = head;  
        return data;
    }

    public void display(){
        Node curNode = head;
        if ( head != null){
            do{
                System.out.print(curNode.data + " ");
                curNode = curNode.next;
            }while (curNode!=head); 
                
            }
        else{
            System.out.println("List is empty");
        }
            System.out.println();
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.display();
        // System.out.println();
        System.out.println(list.deleteLast());
        list.display();
        // System.out.println();
        System.out.println(list.deleteFirst());
        list.display();


    }
    

    
}
