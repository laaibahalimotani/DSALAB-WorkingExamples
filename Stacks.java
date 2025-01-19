import java.util.Stack;

public class Stacks {

    // 1. Reverse a string using stack
    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    // 2. Reverse a number using stack
    public static int reverseNumber(int num) {
        Stack<Integer> stack = new Stack<>();
        while (num > 0) {
            stack.push(num % 10);
            num /= 10;
        }

        int reversed = 0;
        int placeValue = 1;
        while (!stack.isEmpty()) {
            reversed += stack.pop() * placeValue;
            placeValue *= 10;
        }

        return reversed;
    }

    // 3. Search an element in a stack and return its position (index)
    public static int searchElement(Stack<Integer> stack, int element) {
        Stack<Integer> tempStack = new Stack<>();
        int position = -1;
        int index = 0;

        // Use a temporary stack to find the element
        while (!stack.isEmpty()) {
            int current = stack.pop();
            tempStack.push(current);
            if (current == element) {
                position = index; // 0-based index
                break;
            }
            index++;
        }

        // Restore original stack order
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return position;
    }

    // 4. Create a peek() method which will return but not remove the top of the stack
    public static int peek(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return stack.peek(); // Java's built-in peek does exactly this
    }

    public static void main(String[] args) {
        // Test reverseString
        String originalString = "HelloWorld";
        System.out.println("Original String: " + originalString);
        System.out.println("Reversed String: " + reverseString(originalString));

        // Test reverseNumber
        int originalNumber = 12345;
        System.out.println("\nOriginal Number: " + originalNumber);
        System.out.println("Reversed Number: " + reverseNumber(originalNumber));

        // Test searchElement
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println("\nStack: " + stack);
        int elementToSearch = 30;
        int position = searchElement(stack, elementToSearch);
        if (position != -1) {
            System.out.println("Element " + elementToSearch + " found at index: " + position);
        } else {
            System.out.println("Element " + elementToSearch + " not found in stack.");
        }

        // Test peek
        System.out.println("\nTop of the stack (peek): " + peek(stack));
        System.out.println("Stack after peek (unchanged): " + stack);
    }
}

