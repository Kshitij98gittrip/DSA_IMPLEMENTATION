package LinkedList;


public class SinglyLinkedList implements LinkedList {

    class Node{

        int data;
        Node next;

         Node(int data) {
            this.data = data;
            this.next = null;
        }
        
    }

    Node head;
    Node tail;
    SinglyLinkedList(){
        head = null;
        tail = null;
    }

    @Override
    public void addFirst(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
            }

    }

    @Override
    public void addLast(int data){

        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        
            }
    }

    @Override
    public void insert(int data,int beforeData){
        Node newNode = new Node(data);
        Node current = head;
        Node previous = null;
        while(current != null){
            if (current.data ==beforeData){
                break;
            }

            previous = current;
            current = current.next;
        }

        if (current == null){
            previous.next = newNode;
            tail =  newNode;
            return;

        }

        if (previous == null){
            newNode.next = head;
            head = newNode;

            return;
        }

        previous.next = newNode;
        newNode.next = current;
    }
    
    @Override
    public int deleteFirst(){

        if (head == null){
            return -1;
        }
        int data = head.data;
        head = head.next;
        return data;
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

        Node current = head;
        Node previous = null;
        while (current.next !=null){
            previous = current;
            current = current.next;
        }

        int data = tail.data;
        tail = previous;
        previous.next = null;
        return data;
    }

      
    // @Override
    // public int delete(int data){

    //     if (head == null){
    //         return -1;
    //     }
    //     Node currNode=head;
    //     Node prNode = null;
    //     while (currNode.next.data != data){
    //         currNode =  currNode.next;
    //     }
    //     if (currNode.next == null){
    //         return -1;
    //         }
    //     int data = currNode.next.data;
    //     currNode.next = currNode.next
    // }
    @Override
    public void display(){
        Node current = head;
        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }


    public static void main(String[] args) {
        LinkedList list = new SinglyLinkedList();
        list.addFirst(10);
        list.addLast(30);
        list.addFirst(20);
        list.display();
        System.out.println();
        System.out.println("FIrst Delete"+list.deleteFirst());
        System.out.println("Last delete"+list.deleteLast());
        list.display();
        System.out.println();
        list.insert(40, 10);
        list.display();
    }
}
