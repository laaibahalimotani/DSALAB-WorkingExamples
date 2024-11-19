public class StackUsingArrays {
    private int arr[];
    private int size;
    private int index =0;

    public StackUsingArrays(int size){
        this.size=size;
        arr= new int[size];
    }
    public void push(int element){
        if (isFull()){
            System.out.println("Stack is full");
        }
        arr[index]= element;
        index++;
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        }
        return arr[--index];
    }
    public boolean isFull(){
        if (index==size){
            return true;
        }
        return false;
    }
    public boolean isEmpty(){
        if(index==0){
            return true;
        }
        return false;
    }
    public int size(){
        return index;
    }

    public static void main(String[] args) {
        StackUsingArrays stack = new StackUsingArrays(5);
        stack.push(8);
        stack.push(11);
        stack.push(13);
        stack.push(20);
        stack.push(11);
        System.out.println("1. Size of stack after push operations: "+stack.size());
        System.out.println("2. Pop elements from stack: ");
        while(!stack.isEmpty()){
            System.out.print(" "+stack.pop());
        }
        System.out.println("\n3. Size of stack after pop operations: "+stack.size());
    }
}
