public class CircularQueue {

    private int front,rear;
    private int size;
    private int[] queue;
    public CircularQueue(int size) {
        this.size = size;
        this.front = -1;
        this.rear = -1;
        queue = new int[size];
    }

    public boolean isEmpty(){
        return (front == rear && front == -1);
    }

    public boolean isFull(){
        return (front == -1 && rear ==  queue.length-1) ||
        (front == rear && front != -1);
    }
    
    public void push(int data){
        if (isFull()){
            System.out.println("Queue is full");
            return;
        }
        rear++;
        queue[rear] = data;
    }

    public void pop(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return ;
        }
        front = (front+1) %queue.length;
        if (front==rear){
            rear = -1;
            front = -1;
        }

    }

    public int peek(){
        if (isEmpty())
            System.out.println("Queue is empty");
        int index = (front+1)%queue.length;
        return queue[index];
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.peek();
        queue.push(4);
        queue.push(5);
        queue.push(6);
        System.out.println(queue.peek());
        
        queue.pop();
        System.out.println(queue.peek());

    }
}
