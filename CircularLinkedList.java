import java.util.NoSuchElementException;

public class CircularLinkedList {
    Node last;
    int length;
    private class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data=data;
        }
    }
    public CircularLinkedList(){
        this.last=null;
        this.length=0;
    }
    public boolean isEmpty(){
        return length==0;
    }
    public int length(){
        return length;
    }
    public void createCircularSLL(){
        Node first = new Node(12);
        Node second = new Node(14);
        Node third = new Node(16);
        Node fourth = new Node(18);
        first.next=second;
        second.next=third;
        third.next= fourth;
        fourth.next=first;

        last=fourth;
    }
    public void print(){
        if(last==null){
            return;
        }
        Node first=last.next;
        while(first!=last){
             System.out.print(first.data+" -> ");
            first=first.next;
        }
        System.out.print(first.data);
    }
    public void insertAtBeginning(int data){
        Node temp = new Node(data);
        if(isEmpty()){ //last==null
            last=temp;
        }else {
           temp.next=last.next;
        }
        last.next=temp;
        length++;
    }
    public void insertAtEnd(int data){
        Node temp = new Node(data);
        if(isEmpty()){
            last=temp;
            last.next=last; //to make is circular
        }else{
            temp.next=last.next;
            last.next=temp;
            last=temp;
        }
        length++;
    }
    public Node removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Node temp=last.next;
        if(last.next==last){ //single node case
            last=null;
        }else{
            last.next=temp.next;
        }
        temp.next=null;
        length--;
        return temp;
    }
    public Node removeLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node temp=last.next;
        Node current=last.next;
        if(last.next==last){ //single node case
            last=null;
        }else{
            while(current.next!=last){ //look for second last element
                current=current.next;
            }
            current.next=last.next; //assigning the first nodes pointer to the second last node
            last=current; //making current node the last node
        }
        length--;
        return temp;
    }
    public void deleteAtPosition(int position) {
        if (isEmpty() || position < 1 || position > length) {
            System.out.println("Invalid position or list is empty.");
            return;
        }

        Node current = last.next; // Start from the head node

        //  Deleting the first node
        if (position == 1) {
            if (last.next == last) { // Single node case
                last = null;
            } else {
                last.next = current.next;
            }
        } else {
            //  Deleting a node at a specific position
            Node previous = null;
            for (int i = 1; i < position; i++) {
                previous = current;
                current = current.next;
            }
            previous.next = current.next;

            // If deleting the last node, update `last`
            if (current == last) {
                last = previous;
            }
        }
        length--;
    }


    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertAtEnd(20);
        cll.insertAtEnd(40);
        cll.insertAtEnd(60);
        cll.insertAtEnd(15);
        cll.insertAtEnd(112);
        cll.insertAtBeginning(12);
        cll.insertAtBeginning(11);
       /* cll.removeFirst();
        cll.removeLast();*/
        System.out.println("Original list: ");
        cll.print();

        System.out.println("\n\nDeleting node at position 3...");
        cll.deleteAtPosition(3);
        cll.print();

        System.out.println("\n\nDeleting node at position 1...");
        cll.deleteAtPosition(1);
        cll.print();

        System.out.println("\n\nDeleting node at position 5...");
        cll.deleteAtPosition(5);
        cll.print();
    }
}
