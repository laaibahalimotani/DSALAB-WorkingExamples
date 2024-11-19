class QueueLinkedList {
    private Node front;
    private Node rear;

    static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public boolean isEmpty(){
        return(front==null);
    }
    public void insertLast(int new_data){
        Node newNode= new Node(new_data);
        if(isEmpty()){
            front = newNode;
            rear = newNode;
        }else{
            rear.next= newNode;
            rear = newNode;
        }
    }
    public int deleteFirst(){
        int temp = front.data;
        if(front.next==null){
            rear=null;
        }
        front = front.next;
        return temp;
    }
    void displayList(){
        System.out.println("\n===Displaying Elements of DEQ===");
        Node current= front;
        while(current!=null){
            System.out.print(current.data+" -> ");
            current =current.next;
        }
        System.out.print("null");
    }
}
class Queue_2{
    QueueLinkedList list;
    public Queue_2(){
        list = new QueueLinkedList();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public void enqueue(int new_data){
        list.insertLast(new_data);
    }
    public int dequeue(){
        return list.deleteFirst();
    }
    void printQueue(){
        list.displayList();
    }
}

public class QueueUsingLinkedList {
    public static void main(String[] args) {
        Queue_2 list = new Queue_2();
        list.enqueue(10);
        list.enqueue(20);
        list.enqueue(30);
        list.enqueue(40);
        list.printQueue();
        list.dequeue();
        list.printQueue();
        list.enqueue(50);
        list.printQueue();
        list.dequeue();
        list.printQueue();
    }
}
