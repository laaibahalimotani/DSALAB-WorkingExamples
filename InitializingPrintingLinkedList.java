class Node{
    int data;
    Node address;

    public Node(int data){
        this.data= data;
        this.address=null;
    }
}
public class InitializingPrintingLinkedList {

    Node head,tail;

    public void add(int d){
        Node n=new Node(d);
        if(head==null){
            head=tail=n;
        }else{
            tail.address=n;
            tail=n;
        }
    }
    public void printList(){
        Node current= head;
        while(current!=null){
            System.out.print(current.data+" -> ");
            current=current.address;
        }
        System.out.print("null");
    }
    //inserting at beginning in linked list
    public void insertAtBeginning(int data){
        Node newNode= new Node(data); // create a new node with the given data
        newNode.address=head;// point the new node to the new node
        head=newNode;//move the head to point to the new node
    }




    public static void main(String[] args) {  //leaked code >> any node can be accessed directly by the user===linked lists should not do that
        /*Node node1 = new Node(10);      //all of the assigning is done and SHOULD BE DONE in methods
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        Node node4 = new Node(40);*/

       /* node1.address= node2;
        node1.address.address= node3;
        node1.address.address.address= node4;

        Node current = node1;
        while (current!=null){
            System.out.print(current.data+ " ");
            current=current.address;

        }
        System.out.println();*/

        InitializingPrintingLinkedList list= new InitializingPrintingLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.printList();
    }
}
