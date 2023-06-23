package projectlinkedlist;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        studentList listOfStudent = new studentList();
        int option;
        Scanner scanner = new Scanner(System.in);
        String isContinue = "yes";
        boolean exit = false;
        do {
            System.out.println("GENIUS EDUCATION MANAGEMENT SYSTEM");
            System.out.println("1. Add New Student");
            System.out.println("2. Show List of Students");
            System.out.println("3. Find Student Information");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student Information");
            System.out.println("6. Sorting Student Ascending");
            System.out.println("7. EXIT");
            System.out.println("Select Menu: ");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    String newName, newClass, newAddress;
                    int newId;
                    System.out.println("Enter Student ID: ");
                    newId = scanner.nextInt();
                    System.out.println("Enter Student Name: ");
                    newName = scanner.next();
                    System.out.println("Enter Student Class:");
                    newClass = scanner.next();
                    System.out.println("Enter Student Address :");
                    newAddress = scanner.next();

                    studentModel newStudent = new studentModel(newId, newName, newClass, newAddress);
                    listOfStudent.addNewStudent(newStudent);
                    break;
                case 2:
                    System.out.println("------List of genius education student data------");
                    listOfStudent.showListOfStudent();
                    break;
                case 3:
                    String inputStudentName;
                    System.out.println("Enter the name of the student to search for: ");
                    inputStudentName = scanner.nextLine();
                    boolean isFound = listOfStudent.searchStudent(inputStudentName);
                    if (!isFound) {
                        System.out.println("Data doesnt exist.");
                    }
                    break;
                case 4:
                    int selectId;
                    System.out.println("Enter the id of the data to be deleted:");
                    selectId = scanner.nextInt();
                    scanner.nextLine();

                    boolean isDeletedSuccessfully = listOfStudent.deleteSelectedStudent(selectId);
                    if (isDeletedSuccessfully) {
                        System.out.println("Data deleted successfully.");
                    } else {
                        System.out.println("Data failed to delete.");
                    }
                    break;
                case 5:
                    int selectedStudentId;
                    System.out.println("Enter the id of the data to be changed");
                    selectedStudentId = scanner.nextInt();
                    scanner.nextLine();
                    boolean isUpdateSuccesfully = listOfStudent.updateSelectedStudent(selectedStudentId);
                    if (!isUpdateSuccesfully) {
                        System.out.println("Data doesnt exist.");
                    }
                    break;
                case 6:
                    String choice;
                    System.out.println("Choose which one to sort");
                    System.out.println("A. Name");
                    System.out.println("B. ID");
                    choice = scanner.next();

                    if (choice.equalsIgnoreCase("A")) {
                        listOfStudent.bubbleSortName();
                        System.out.println("Sorted names:");
                        listOfStudent.showListOfStudent();
                    } else if (choice.equalsIgnoreCase("B")) {
                        listOfStudent.bubbleSortId();
                        System.out.println("Sorted Class:");
                        listOfStudent.showListOfStudent();
                    } else {
                        System.out.println("Please choose A or B");
                    }
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong Choice!");
                    break;
            }

            System.out.print("Continue to program? (yes/no): ");
            isContinue = scanner.next();
        } while (isContinue.equalsIgnoreCase("yes"));

        scanner.close();
    }
}