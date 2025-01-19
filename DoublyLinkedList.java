import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private Node head, tail;
    private int length;
    private class Node{
        private int data;
        private Node next;
        private Node previous;

        public Node (int data){
            this.data=data;
        }
    }
    public DoublyLinkedList(){
        this.head=null;
        this.tail=null;
        this.length=0;
    }
    public boolean isEmpty(){
        return length==0;
    }
    public int length(){
        return length;
    }
    public void displayForward(){
        Node current=head;
        while(current!=null){
            System.out.print(current.data+" -> ");
            current=current.next;
        }
        System.out.println("null");
    }
    public void displayBackward(){
        Node current = tail;
        while(current!=null){
            System.out.print(current.data+"  -> ");
            current=current.previous;
        }
        System.out.println("null");
    }
    public void insertAtBeginning(int data){
        Node newNode = new Node(data);
        if(head==null){
            tail=newNode;
        }else{
            head.previous=newNode;
        }
        newNode.next=head;
        head=newNode;
        length++;
    }
    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(tail==null){
            head=newNode;
        }else{
            tail.next=newNode;
            newNode.previous=tail;
        }
        tail=newNode;
        length++;
    }
    public Node deleteFirst(){
        if(head==null){
            throw new NoSuchElementException();
        }
        Node temp = head;
        if(head==tail){
            tail=null;
        }else{
            head.next.previous=null;
        }
        head=head.next;
        temp.next=null;
        length--;
        return temp;
    }
    public Node deleteLast(){
        if(head==null){
            throw new NoSuchElementException();
        }
        Node temp= tail;
        if (head==tail){
            head=null;
        }else{
            tail.previous.next=null;
            tail=tail.previous;
        }
        temp.previous=null;
        length--;
        return temp;
    }

    public static void main(String[] args) {
       DoublyLinkedList dll = new DoublyLinkedList();
       dll.insertAtBeginning(12);
       dll.insertAtBeginning(23);
       dll.insertAtEnd(45);
       dll.insertAtEnd(35);
       //23->12->45->35->null
        dll.displayForward();
       //35->45->12->23->null
        dll.displayBackward();
        System.out.println(dll.length());
        dll.deleteFirst();
        //12->45->35->null
        dll.displayForward();
        dll.deleteLast();
        //12->35->null
        dll.displayForward();


    }

}
