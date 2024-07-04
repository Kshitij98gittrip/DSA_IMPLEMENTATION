package LinkedList;


public class DoublyLinkedList implements LinkedList{
    
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

    public DoublyLinkedList(){
        head = null;
        tail = null;
    }

    @Override
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.next = head;
        newNode.prev = null;
        head.prev = newNode;
        head = newNode;
        
    }

    @Override
    public void addLast(int data){
        Node newNode = new Node(data);
        if(tail == null){
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;


    }
    @Override
    public void insert(int data,int beforeData){
        Node newNode = new Node(data);
        Node curNode = head;
        Node prNode = null;
        while(curNode.data != beforeData){
            if (curNode.data == beforeData)
                break;
            prNode = curNode;
            curNode =curNode.next;
        }
        if (curNode ==null){
            prNode.next = newNode;
            newNode.prev = prNode;
            tail = newNode;
            return;

        }

        if (prNode == null){
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
            return;
        }

        newNode.next = curNode;
        curNode.prev = newNode;
        newNode.prev = prNode;
        prNode.next = newNode;

    }

    @Override
    public int deleteFirst(){

        if (head == null)
            return -1;
        int data = head.data;
        head = head.next;
        head.prev = null;
        return  data;

    }

    @Override
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
        tail.next = null;
        return data;

    }
    // int delete(int data);

    @Override
    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new DoublyLinkedList();
        list.addFirst(10);
        list.addFirst(20);
        list.addLast(30);
        list.display();
        System.out.println();
        System.out.println(list.deleteFirst());
        System.out.println(list.deleteLast());
        list.display();
        System.out.println();
        list.insert(50, 10);
        list.display();
        System.out.println();
        list.insert(60, 10);
        list.display();
        System.out.println();
        list.insert(90, 50);
        list.display();
    }
}
