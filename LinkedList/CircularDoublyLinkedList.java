package LinkedList;
public class CircularDoublyLinkedList {
    
    class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    public CircularDoublyLinkedList(){
        head = null;
        tail = null;
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            head.prev = tail;
            tail.next = head;
            return;
        }

        newNode.next = head;
        newNode.prev = tail;
        head.prev = newNode;
        head = newNode;
        
        
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(tail == null){
            head = newNode;
            tail = newNode;
            tail.next = head;
            head.prev = tail;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = head;
        tail = newNode;
        head.prev = tail;
    }

    public int deleteFirst(){

        if (head == null)
            return -1;
        int data = head.data;
        head = head.next;
        tail.next = head;
        head.prev = tail;
        return  data;

    }

    public int deleteLast(){

        if (tail == null)
            return -1;
        if (head.next == null){
            int data = head.data;
            head = null;
            tail = null;
            return data;
        }
        int data = tail.data;
        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
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
        CircularDoublyLinkedList list = new CircularDoublyLinkedList(); 
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addLast(40);
        list.display();
        System.out.println(list.deleteFirst());
        list.display();
        System.out.println(list.deleteLast());
        list.display();
    }


}
