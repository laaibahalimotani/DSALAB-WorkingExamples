import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Queues {

    // 1. Reverse the first K elements of a Queue
    public static void reverseFirstKElements(Queue<Integer> queue, int k) {
        if (queue == null || k <= 0 || k > queue.size()) {
            throw new IllegalArgumentException("Invalid value for k.");
        }

        Stack<Integer> stack = new Stack<>();

        //Push the first k elements into the stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        //Add the elements from the stack back to the queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        //Move the remaining elements in the queue to the back
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }

    // 2. Implement a getMinimum() function for Queue
    public static int getMinimum(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        int min = Integer.MAX_VALUE;
        int size = queue.size();

        // Traverse the queue to find the minimum value
        for (int i = 0; i < size; i++) {
            int current = queue.poll();
            min = Math.min(min, current);
            queue.offer(current); // Re-add the element to maintain order
        }

        return min;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);

        System.out.println("Original Queue: " + queue);

        // Test reverseFirstKElements
        int k = 3;
        reverseFirstKElements(queue, k);
        System.out.println("Queue after reversing first " + k + " elements: " + queue);

        // Test getMinimum
        int min = getMinimum(queue);
        System.out.println("Minimum element in the queue: " + min);
    }
}

