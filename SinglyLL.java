public class SinglyLL {
    Node head;
    private static class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public void insertFirst(int data){
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
        }
        head=newNode;
    }
    public void display(){
        Node current=head;
            while(current!=null){
                System.out.print(current.data+" -> ");
                current=current.next;
            }
            System.out.println("null");
        }

    public int length(){
        int nodeCount =0;
        Node current=head;
        while(current!=null){
            nodeCount++;
            current=current.next;
        }
        return nodeCount;
    }
    public void insertLast(int data){
        Node newNode= new Node(data);
        Node current=head;
        if(head==null){
            head=newNode;
        }else{
            //traversing to the second last node
            while(current.next!=null){
               current=current.next;
            }
            current.next=newNode;
        }
    }
    public void insert(int position, int data){
        Node newNode = new Node(data);
        if(position==1){
            newNode.next=head;
            head=newNode;
        }else{
            Node current=head;
            int count= 1;// iterate to pos-1
            while(count<position-1){
                current=current.next;
                count++;
            }
            Node temp=current.next;
            current.next=newNode;
            newNode.next=temp;
        }
    }
    public Node deleteFirst(){
        if(head==null){
            return null;
        }
        Node temp=head;
        head=head.next;
        temp.next=null;
            return temp;
    }
    public Node deleteLast(){
        if(head==null||head.next==null){
            return head;
        }
        Node current=head;
        Node previous=null; //traverses to the second last node
        while(current.next!=null){
              previous=current;
              current=current.next;
        }
        previous.next=null; // delete the last node
        return current; //returning the deleted node
    }
    public void delete(int position){
        if(position==1){
            head=head.next;
        }else{
            Node current=head;
            int count=1;
            while(count<position-1){
                current=current.next;
                count++;
            }
            Node temp= current.next;
            temp.next=current.next;

        }

    }
    public boolean search(int key){
        Node current=head;
        while(current!=null){
            if(key==current.data){
                return true;
            }
            current=current.next;
        }
        return false;
    }
    //reversing while retaining the original
    public SinglyLL reverse(){
        if (head==null){
            return null;
        }
        Node current=head;
        SinglyLL reversed = new SinglyLL(); //create a new list
        while(current!=null){
            Node newNode = new Node(current.data);// create a new node for each traversed node
            newNode.next= reversed.head; //add it to the front of the reversed list
            reversed.head=newNode;//continue inserting at the beginning of the reversed list
            current=current.next;
        }
        return reversed; //return the reversed list
    }
    public Node middleNode(){
        if(head==null){
            return null;
        }
        Node fastPtr=head;
        Node slowPtr=head;
        while(fastPtr!=null&&fastPtr.next!=null){
            slowPtr=slowPtr.next;      //finds the mid node
            fastPtr=fastPtr.next.next; //ends 2x faster than slowptr
        }
        return slowPtr;
    }
    public Node searchFromEnd(int n){
        if(head==null){
            return null;
        }
        if(n <=0){
            throw new IllegalArgumentException("Invalid value");
        }
        Node mainPtr=head;
        Node refPtr = head;
        int count=0;
        while(count< n){
            if(refPtr==null){
                throw new IllegalArgumentException(n +" is greater than the no. of nodes in the list.");
            }
           refPtr=refPtr.next;
           count++;
        }
        while(refPtr!=null){
            refPtr=refPtr.next;
            mainPtr=mainPtr.next;
        }
        return mainPtr;
    }
    public void removeDuplicates(){
        if(head==null){
            return;
        }
        Node current=head;
        while(current != null && current.next != null){
            if(current.data==current.next.data){
                current.next=current.next.next;
            }else{
            current=current.next;
        }
        }
    }
    public void removeKey(int key){
        Node current=head;
        Node temp=null;
        if(current!=null && current.data==key){
            head=current.next; //if key is found at head
        }
        while(current!=null&&current.data!=key){
            temp=current;
            current=current.next;
        }
        if(current==null){
            return; //key not found
        }
        temp.next=current.next;
    }
    public void removeLastOccurrence(int key){
        Node current=head;
        Node temp= null;
        while(current!=null){
            if(current.data==key){
                temp=current; //if key is found updating temp
            }
            current=current.next;
        }
        //if node is present at head
        if(temp==head){
            head=head.next;
            return;
        }
        //if key is not found
        if(temp==null){
            System.out.println("key not found");
            return;
        }
        //traversing again to find node before temp
        current=head;
        while(current.next!=temp){ //traversing until the node right before temp
            current=current.next;
        }
        current.next=temp.next;
    }
    public boolean containsLoop(){
        Node fastPtr=head;
        Node slowPtr=head;
        while(fastPtr!=null && fastPtr.next!=null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr) {
                return true;
            }
        }
        return false;
    }
    public Node findStartOfLoop(){
        Node fastPtr=head;
        Node slowPtr= head;
        while(fastPtr!=null&&fastPtr.next!=null){
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
            if(fastPtr==slowPtr){
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }

    public Node getStartingNode(Node slowPtr){
        Node temp=head;
        while(slowPtr!=temp){
            temp=temp.next;
            slowPtr=slowPtr.next;
        }
        return temp;
    }
    public void removeLoopFromLinkedList(){
        Node fastPtr=head;
        Node slowPtr=head;
        while(fastPtr!=null&&fastPtr.next!=null){
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
            if(fastPtr==slowPtr){
                removeLoop(slowPtr);
                return;
            }
        }
    }
    public void removeLoop(Node slowPtr){
        Node temp=head;
        //traverse until just before the starting point of the loop
        while(slowPtr.next!=temp.next){
            temp=temp.next;
            slowPtr=slowPtr.next;
        }
        slowPtr.next=null;
    }
    //creates a linked list with a loop
    public void createALoopInLinkedList(){
        Node first= new Node(1);
        Node second= new Node(2);
        Node third= new Node(3);
        Node fourth= new Node(4);
        Node fifth= new Node(5);
        Node sixth= new Node(6);

        head=first;
        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=sixth;
        sixth.next=third;

    }
    //static to keep is accessible from the main method
    public static Node mergeSortedList(Node a, Node b){
        Node dummy = new Node(0);
        Node tail =dummy;
        while(a!=null && b!=null){
            if(a.data<=b.data){
                tail.next=a;
                a=a.next;
            }else{
                tail.next=b;
                b=b.next;
            }
            tail=tail.next;
        }
        if(a==null){
            tail.next=b;
        }else{
            tail.next=a;
        }
        return dummy.next;
    }
    public static Node sumOfLinkedList(Node a, Node b){
        Node dummy = new Node(0);
        Node tail= dummy;
        int carry=0;
        //loop will iterate until both are null
        while(a!=null||b!=null){
            int x = (a!=null)?a.data:0; //ternary operator
            int y = (b!=null)?b.data:0;
            int sum = carry+x+y;
            carry = sum/10; //dividing sum by 10 to get carry
            tail.next= new Node(sum%10); //using modulus operator to get the lower value
            tail=tail.next; //updating the tail
            if(a!=null) a=a.next;
            if(b!=null) b=b.next;
            }
        // when the loop terminates and carry still has a value>0 then it will be a new node
         if(carry>0){
             tail.next = new Node(carry);
        }
         return dummy.next;
    }
    public static Node intersectionOfLinkedList(Node headA, Node headB){
        Node tempA=headA;
        Node tempB=headB;
        int lengthA=0;
        while(tempA!=null){
            lengthA++;
            tempA=tempA.next;
        }
        int lengthB=0;
        while(tempB!=null){
            lengthB++;
            tempB=tempB.next;
        }
        tempA=headA;
        tempB=headB;
        if(lengthA>lengthB){
            int steps =lengthA-lengthB;
            for(int i=0;i<steps;i++){
                tempA=tempA.next;
            }
        }else{
            int steps = lengthB-lengthA;
            for(int i=0;i<steps;i++){
                tempB=tempB.next;
            }
        }while(tempA!=tempB){
            tempA=tempA.next;
            tempB=tempB.next;
        }
        return tempA;
    }
    public static Node deleteMiddleNode(Node head){
        if(head.next==null){
            return null;
        }
        Node fastPtr=head;
        Node slowPtr=head;
        //.next.next for right middle & .next.next.next for left middle
        while(fastPtr.next.next!=null&&fastPtr.next.next.next!=null){
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
        }
        slowPtr.next=slowPtr.next.next;
        return head;
    }
    public static Node evenOdd(Node head){
        Node odd= new Node(0);
        Node even = new Node(0);
        Node tempO=odd;
        Node tempE=even;
        Node temp=head;
        while(temp!=null){
            tempO.next=temp;
            tempO=tempO.next;
            temp=temp.next;

            tempE.next=temp;
            if(temp==null)break;
            tempE=tempE.next;
            temp=temp.next;

        }
        odd=odd.next;
        even=even.next;
        tempO.next=even;
        return odd;
    }

    public static void main(String[] args) {
        SinglyLL sll1 = new SinglyLL();
        sll1.insertLast(1);
        sll1.insertLast(2);
        sll1.insertLast(3);
        sll1.insertLast(4);
        sll1.insertLast(5);
        sll1.insertLast(6);
        sll1.display();
        evenOdd(sll1.head);
        sll1.display();
       /* SinglyLL sll2 = new SinglyLL();
        sll2.insertLast(7);
        sll2.insertLast(4);
        sll2.insertLast(2);
        sll1.display();
        sll2.display();*/
        //numbers r stored in reverse order
        //9527+257 =9784
        /*SinglyLL sum = new SinglyLL();
        sum.head=sumOfLinkedList(sll1.head,sll2.head);
        sum.display();*/
     /*   sll1.display();
        sll2.display();*/
 /*       SinglyLL result = new SinglyLL();
        // using (.head) because we are returning the head node of the list
        result.head =mergeSortedList(sll1.head,sll2.head);
        result.display();*/

/*        sll.insertFirst(12);
        sll.insertFirst(11);
        sll.insertLast(13);
        sll.insertLast(14);
        sll.insertLast(15);*/
//      sll.display();
/*      SinglyLL reversed= sll.reverse();
        reversed.display();
        sll.display(); */
//      System.out.println("Middle node: "+sll.middleNode().data);//**print the data of the middle node not j the function (gives an error)
//      System.out.println("3rd node from the end : "+sll.searchFromEnd(4).data);
//      sll.removeDuplicates();
//      sll.display();
//      sll.removeKey(14);
//      sll.removeLastOccurrence(11);
//      sll.removeLastOccurrence(15);
//      sll.removeLastOccurrence(14);
//      sll.display();
/*        sll.createALoopInLinkedList();
        System.out.println(sll.containsLoop());
        System.out.println(sll.findStartOfLoop().data);
        sll.removeLoopFromLinkedList();
        System.out.println(sll.containsLoop());
        sll.display();*/

    }
}
