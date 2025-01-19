import java.util.Scanner;
class Node {
    char data;
    Node prev, next;

    Node(char data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
class DLL {
    private Node head, tail;

    // Add a character at the end
    public void addChar(char c) {
        Node newNode = new Node(c);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Delete a character at a specific position (1-based index)
    public void deleteChar(int pos) {
        if (head == null || pos <= 0) return;

        Node current = head;
        for (int i = 1; current != null && i < pos; i++) {
            current = current.next;
        }

        if (current == null) return;

        if (current == head) {
            head = current.next;
            if (head != null) head.prev = null;
        } else if (current == tail) {
            tail = current.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    // Modify a character at a specific position (1-based index)
    public void modifyChar(int pos, char newChar) {
        Node current = head;
        for (int i = 1; current != null && i < pos; i++) {
            current = current.next;
        }
        if (current != null) {
            current.data = newChar;
        }
    }

    // Display the entire text
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
        }
        System.out.println();
    }
}
public class TextEditor {


        public static void main(String[] args) {
            DLL text = new DLL();
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n--- Text Editor ---");
                System.out.println("1. Add Character");
                System.out.println("2. Delete Character");
                System.out.println("3. Modify Character");
                System.out.println("4. Display Text");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter character to add: ");
                        char c = sc.nextLine().charAt(0);
                        text.addChar(c);
                    }
                    case 2 -> {
                        System.out.print("Enter position to delete: ");
                        int pos = sc.nextInt();
                        text.deleteChar(pos);
                    }
                    case 3 -> {
                        System.out.print("Enter position to modify: ");
                        int pos = sc.nextInt();
                        sc.nextLine(); // Consume newline
                        System.out.print("Enter new character: ");
                        char newChar = sc.nextLine().charAt(0);
                        text.modifyChar(pos, newChar);
                    }
                    case 4 -> {
                        System.out.println("Current Text: ");
                        text.display();
                    }
                    case 5 -> {
                        System.out.println("Exiting editor...");
                        sc.close();
                        return;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }


