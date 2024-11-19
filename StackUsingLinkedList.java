 class LinkedList {
    private Node top;
    public static class Node{
        public int data;
        public Node next;

        public Node(int data){
            this.data=data;
        }
    }
    public void insertFirst(int data){
        Node n = new Node(data);
        n.next= top;
        top=n;
    }
    public Node deleteFirst(){
        Node temp = top;
        top=top.next;
        return temp;
    }
    public void displayList(){
        Node current = top;
        while(current!=null){
            System.out.print(current.data+" -> ");
            current=current.next;
        }
        System.out.print("null");
    }

}
class LinkedListStack{
    LinkedList li = new LinkedList();
    public void push(int element){
        li.insertFirst(element);
    }
    public void pop(){
        li.deleteFirst();
    }
    public void displayStack(){
        System.out.println(" ");
        li.displayList();
    }
}
public class StackUsingLinkedList{
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push(50);
        stack.push(70);
        stack.push(190);
        System.out.print("1. Stack after push operation: ");
        stack.displayStack();
        System.out.print("\n2. Stack after pop operation: ");
        stack.pop();
        stack.displayStack();
    }
}
