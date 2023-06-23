package projectlinkedlist;

import java.util.*;

public class studentList {
    private Node head, tail;

    public studentList() {
        this.head = this.tail = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    // CASE 1
    public void addNewStudent(studentModel newStudent) {
        if (isEmpty()) {
            this.head = this.tail = new Node(newStudent);
            return;
        }
        Node newNode = new Node(newStudent);
        this.tail.setNext(newNode);
        this.tail = newNode;
    }

    // CASE 2
    public void showListOfStudent() {
        Node selectedNode = this.head;
        while (selectedNode != null) {
            System.out.println("==================================================================");
            System.out.println("ID of Student: " + selectedNode.getStudent().getid() + "\nName of Student: "
                    + selectedNode.getStudent().getName() + "\nClass of Student: "
                    + selectedNode.getStudent().getKelas()
                    + "\nAddress of Student: " + selectedNode.getStudent().getAddress());
            System.out.println("==================================================================");
            System.out.println();
            selectedNode = selectedNode.getNext();
        }
    }

    public void addManyStudent(studentModel... listOfStudent) {
        for (studentModel newStudent : listOfStudent) {
            addNewStudent(newStudent);
        }
    }

    // CASE 3
    public boolean searchStudent(String selectedStudentName) {
        boolean isFound = false;
        Node selectedNode = this.head;
        while (selectedNode != null) {
            if (selectedNode.getStudent().getName().contains(selectedStudentName)) {
                System.out.println("ID of Student: " + selectedNode.getStudent().getid() + "\nName of Student: "
                        + selectedNode.getStudent().getName() + "\nClass of Student: "
                        + selectedNode.getStudent().getKelas()
                        + "\nAddress of Student: " + selectedNode.getStudent().getAddress());
                isFound = true; // Set isFound to true when a match is found
            }
            selectedNode = selectedNode.getNext();
        }
        if (!isFound) {
            return false;
        }
        return true;
    }

    // CASE 4
    public boolean deleteSelectedStudent(int selectedId) {
        if (isEmpty()) {
            return false; // List is empty, cannot delete
        }

        if (this.head.getStudent().getid() == selectedId) {
            this.head = this.head.getNext();
            return true; // Successfully deleted
        }

        Node selectedNode = this.head;
        while (selectedNode.getNext() != null) {
            if (selectedNode.getNext().getStudent().getid() == selectedId) {
                selectedNode.setNext(selectedNode.getNext().getNext());
                return true; // Successfully deleted
            }
            selectedNode = selectedNode.getNext();
        }

        return false; // Student not found in the list
    }

    // CASE 5
    public boolean updateSelectedStudent(int selectedId) {
        Scanner scanner = new Scanner(System.in);
        Node selectedNode = this.head;
        while (selectedNode != null) {
            if (selectedNode.getStudent().getid() == selectedId) {
                String newStudentName, newAddress, newKelas;
                int newId;

                System.out.println("Input New Data");
                System.out.println("Enter a new ID student:");
                newId = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter a new student name:");
                newStudentName = scanner.next();

                System.out.println("Enter a new student address:");
                newAddress = scanner.next();

                System.out.println("Enter a new student class:");
                newKelas = scanner.next();

                selectedNode.getStudent().setid(newId);
                selectedNode.getStudent().setName(newStudentName);
                selectedNode.getStudent().setAddress(newAddress);
                selectedNode.getStudent().setKelas(newKelas);
                return true;
            }
            selectedNode = selectedNode.getNext();
        }
        scanner.close();
        return false;
    }

    // CASE 6
    public void bubbleSortName() {
        boolean isSorted = false;

        while (!isSorted) {
            Node currentNode = head;
            Node nextNode = currentNode.getNext();
            Node prevNode = null;
            boolean hasSwapped = false;

            while (nextNode != null) {
                if (currentNode.getStudent().getName().compareTo(nextNode.getStudent().getName()) > 0) {
                    hasSwapped = true;

                    if (prevNode == null) {
                        head = nextNode;
                    } else {
                        prevNode.setNext(nextNode);
                    }

                    currentNode.setNext(nextNode.getNext());
                    nextNode.setNext(currentNode);

                    prevNode = nextNode;
                    nextNode = currentNode.getNext();
                } else {
                    prevNode = currentNode;
                    currentNode = nextNode;
                    nextNode = nextNode.getNext();
                }
            }

            if (!hasSwapped) {
                isSorted = true;
            }
        }
    }

    public void bubbleSortId() {
        boolean isSorted = false;

        while (!isSorted) {
            Node currentNode = head;
            Node nextNode = currentNode.getNext();
            Node prevNode = null;
            boolean hasSwapped = false;

            while (nextNode != null) {
                if (currentNode.getStudent().getid() > nextNode.getStudent().getid()) {
                    hasSwapped = true;

                    if (prevNode == null) {
                        head = nextNode;
                    } else {
                        prevNode.setNext(nextNode);
                    }

                    currentNode.setNext(nextNode.getNext());
                    nextNode.setNext(currentNode);

                    prevNode = nextNode;
                    nextNode = currentNode.getNext();
                } else {
                    prevNode = currentNode;
                    currentNode = nextNode;
                    nextNode = nextNode.getNext();
                }
            }

            if (!hasSwapped) {
                isSorted = true;
            }
        }
    }
}