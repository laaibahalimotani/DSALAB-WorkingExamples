// Singly Linked List implementation with various operations
public class SinglyLinkedList {
        Node head;

        // Node structure
        static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        // 1. Traversal
        void traverse() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }

        // 2. Insert at the end
        void insert(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        // 3. Delete a node (by value)
        void delete(int value) {
            if (head == null) return;

            if (head.data == value) {
                head = head.next;
                return;
            }

            Node current = head;
            while (current.next != null && current.next.data != value) {
                current = current.next;
            }

            if (current.next != null) {
                current.next = current.next.next;
            }
        }

        // 4. Search for a node
        boolean search(int value) {
            Node current = head;
            while (current != null) {
                if (current.data == value) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        // Lab Assignments

        // 1. Find the length of the SLL
        int length() {
            int count = 0;
            Node current = head;
            while (current != null) {
                count++;
                current = current.next;
            }
            return count;
        }

        // 2. Print the middle node of the SLL
        void printMiddle() {
            if (head == null) return;
            Node slow = head, fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            System.out.println("Middle node: " + slow.data);
        }

        // 3. Reverse the SLL (retaining the original)
        SinglyLinkedList reverse() {
            SinglyLinkedList reversedList = new SinglyLinkedList();
            Node current = head;

            while (current != null) {
                Node newNode = new Node(current.data);
                newNode.next = reversedList.head;
                reversedList.head = newNode;
                current = current.next;
            }

            return reversedList;
        }

        // 4. Remove duplicates from a sorted SLL
        void removeDuplicates() {
            Node current = head;
            while (current != null && current.next != null) {
                if (current.data == current.next.data) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
        }

        // 5. Merge two sorted SLLs
        static SinglyLinkedList merge(SinglyLinkedList list1, SinglyLinkedList list2) {
            SinglyLinkedList mergedList = new SinglyLinkedList();
            Node dummy = new Node(0);
            Node tail = dummy;
            Node l1 = list1.head, l2 = list2.head;

            while (l1 != null && l2 != null) {
                if (l1.data <= l2.data) {
                    tail.next = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    l2 = l2.next;
                }
                tail = tail.next;
            }

            tail.next = (l1 != null) ? l1 : l2;
            mergedList.head = dummy.next;
            return mergedList;
        }

        // 6. Delete the entire SLL
        void deleteAll() {
            head = null;
        }

        public static void main(String[] args) {
            SinglyLinkedList list = new SinglyLinkedList();

            // Insert elements
            list.insert(1);
            list.insert(2);
            list.insert(3);
            list.insert(4);

            System.out.println("Original List:");
            list.traverse();

            // Find length
            System.out.println("Length of the list: " + list.length());

            // Print middle node
            list.printMiddle();

            // Reverse the list
            SinglyLinkedList reversedList = list.reverse();
            System.out.println("Reversed List:");
            reversedList.traverse();

            // Remove duplicates
            list.insert(4);
            list.insert(4);
            System.out.println("List before removing duplicates:");
            list.traverse();
            list.removeDuplicates();
            System.out.println("List after removing duplicates:");
            list.traverse();

            // Merge two sorted lists
            SinglyLinkedList list2 = new SinglyLinkedList();
            list2.insert(2);
            list2.insert(5);
            list2.insert(6);
            SinglyLinkedList mergedList = SinglyLinkedList.merge(list, list2);
            System.out.println("Merged List:");
            mergedList.traverse();

            // Delete all nodes
            list.deleteAll();
            System.out.println("List after deletion:");
            list.traverse();
        }
    }

