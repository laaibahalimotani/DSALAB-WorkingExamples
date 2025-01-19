/*
Name: Laaibah Deedar Ali Motani
Id: Cs231144
Title: DSA LAB MID -> Console Notepad using 2D doubly linked list
*/


import java.io.*;
import java.util.Scanner;

class Node {
    char data;
    Node nextRow, prevRow, nextCol, prevCol;

    public Node(char data) {
        this.data = data;
        this.nextRow = null;
        this.prevRow = null;
        this.nextCol = null;
        this.prevCol = null;
    }
}

class Cursor {
    Node position;
    int row, col;

    public Cursor(Node start) {
        this.position = start;
        this.row = 0;
        this.col = 0;
    }
}

class Notepad {
    private Node head;
    private Cursor cursor;

    public Notepad() {
        head = new Node(' '); // Start with an empty space instead of '\0'
        cursor = new Cursor(head);
    }

    public void moveCursorUp() {
        if (cursor.position.prevRow != null) {
            Node colPointer = cursor.position.prevRow;
            for (int i = 0; i < cursor.col && colPointer.nextCol != null; i++) {
                colPointer = colPointer.nextCol;
            }
            cursor.position = colPointer;
            cursor.row--;
        }
    }

    public void moveCursorDown() {
        if (cursor.position.nextRow != null) {
            Node colPointer = cursor.position.nextRow;
            for (int i = 0; i < cursor.col && colPointer.nextCol != null; i++) {
                colPointer = colPointer.nextCol;
            }
            cursor.position = colPointer;
            cursor.row++;
        }
    }

    public void moveCursorLeft() {
        if (cursor.position.prevCol != null) {
            cursor.position = cursor.position.prevCol;
            cursor.col--;
        }
    }

    public void moveCursorRight() {
        if (cursor.position.nextCol != null) {
            cursor.position = cursor.position.nextCol;
            cursor.col++;
        }
    }

    public void insertChar(char c) {
        Node newNode = new Node(c);
        newNode.prevCol = cursor.position;
        if (cursor.position.nextCol != null) {
            newNode.nextCol = cursor.position.nextCol;
            cursor.position.nextCol.prevCol = newNode;
        }
        cursor.position.nextCol = newNode;
        cursor.position = newNode;
        cursor.col++;
    }

    public void deleteChar() {
        if (cursor.position != head) {
            Node toDelete = cursor.position;
            if (toDelete.prevCol != null) {
                toDelete.prevCol.nextCol = toDelete.nextCol;
            }
            if (toDelete.nextCol != null) {
                toDelete.nextCol.prevCol = toDelete.prevCol;
            }
            cursor.position = toDelete.prevCol;
            cursor.col--;
        }
    }

    public void display() {
        Node rowPointer = head;
        while (rowPointer != null) {
            Node colPointer = rowPointer;
            while (colPointer != null) {
                if (colPointer == cursor.position) {
                    System.out.print("|"); // Represent the cursor
                } else {
                    System.out.print(colPointer.data);
                }
                colPointer = colPointer.nextCol;
            }
            System.out.println();
            rowPointer = rowPointer.nextRow;
        }
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            Node rowPointer = head;
            while (rowPointer != null) {
                Node colPointer = rowPointer;
                while (colPointer != null) {
                    writer.write(colPointer.data);
                    colPointer = colPointer.nextCol;
                }
                writer.newLine();
                rowPointer = rowPointer.nextRow;
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            head = new Node(' '); // Use a space character instead of '\0'
            cursor = new Cursor(head);
            Node rowPointer = head;

            String line;
            while ((line = reader.readLine()) != null) {
                Node colPointer = rowPointer;
                for (char c : line.toCharArray()) {
                    Node newNode = new Node(c);
                    colPointer.nextCol = newNode;
                    newNode.prevCol = colPointer;
                    colPointer = newNode;
                }
                Node newRow = new Node(' '); // Use a space character
                rowPointer.nextRow = newRow;
                newRow.prevRow = rowPointer;
                rowPointer = newRow;
            }

            // Restore cursor position
            cursor.position = head;
            while (cursor.position.nextRow != null) {
                cursor.position = cursor.position.nextRow;
                cursor.row++;
            }
            while (cursor.position.nextCol != null) {
                cursor.position = cursor.position.nextCol;
                cursor.col++;
            }

        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String filename = "save.txt";
        loadFromFile(filename);

        while (true) {
            display();

            String command = scanner.nextLine();
            switch (command) {
                case "S":
                    saveToFile(filename);
                    break;
                case "L":
                    loadFromFile(filename);
                    break;
                case "E":
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                case "B":
                    deleteChar();
                    break;
                case "T": // Move cursor left
                    moveCursorLeft();
                    break;
                case "R": // Move cursor right
                    moveCursorRight();
                    break;
                case "U": // Move cursor up
                    moveCursorUp();
                    break;
                case "D": // Move cursor down
                    moveCursorDown();
                    break;
                default:
                    if (command.length() == 1) {
                        insertChar(command.charAt(0));
                    }
            }

            System.out.print("\033[H\033[2J"); // Clear the console
        }
    }
}

public class ConsoleNotepad {
    public static void main(String[] args) {
        Notepad notepad = new Notepad();
        notepad.start();
    }
}
