import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private Node head, tail;
    private int length;
    private class Node{
        private int data;
        private Node next;
        private Node previous;

       public Node(int data){
           this.data=data;
        }
    }
    public DoublyLinkedList(){
        this.head=null;
        this.tail=null;
        this.length=0;
    }

    public boolean isEmpty(){
        return length==0;  //or head==null
    }

    public int length(){
        return length;
    }

    public void printForward(){
        Node temp = head;
        if(head==null){
            return;
        }
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public void printBackward(){
        Node temp=tail;
        if(tail==null){
            return;
        }
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.previous;
        }
        System.out.println("null");
    }

    public void insertAtBeginning(int data){
          Node newNode = new Node(data);
          if(isEmpty()){
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
        if(isEmpty()){
            head=newNode;
        }else{
            tail.next=newNode;
            newNode.previous=tail;

        }
        tail=newNode;
        length++;
    }
    public Node deleteAtBeginning(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node  temp=head;
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
    public Node deleteAtEnd(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node temp=tail;
        if(head==tail){
            head=null;
        }
        else{
            tail.previous.next=null;
        }
        tail=tail.previous;
        temp.previous=null;
        length--;
        return temp;
    }
    public void insertBefore(Node next_node, int data) {
        if (next_node == null) {
            System.out.println("The specified node cannot be null.");
            return;
        }


        Node newNode = new Node(data);

        newNode.next = next_node;
        newNode.previous = next_node.previous;

        if (next_node.previous != null) {
            next_node.previous.next = newNode;
        } else {
            head = newNode;
        }

        next_node.previous = newNode;

        length++;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtBeginning(12);
        dll.insertAtBeginning(11);
        dll.insertAtBeginning(13);
        dll.insertAtBeginning(11);
        dll.insertAtEnd(55);
        dll.insertAtEnd(223);
        dll.insertAtEnd(67);
/*
        dll.printBackward();
        System.out.println(dll.length());
        dll.printForward();
        dll.deleteAtBeginning();
        dll.deleteAtEnd();
*/
        System.out.println("Original List: ");
        dll.printForward();
        System.out.println("\nInserting 50 before 55...");
        Node current = dll.head;
        while (current != null && current.data != 55) {
            current = current.next;
        }

        dll.insertBefore(current, 50);

        System.out.println("List after inserting 50 before 55:");
        dll.printForward();


    }

}

