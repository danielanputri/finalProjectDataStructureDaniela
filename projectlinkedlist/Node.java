package projectlinkedlist;

public class Node {
    private studentModel student;
    private Node next;
    int id;

    public Node(studentModel student) {
        this.student = student;
        this.next = null;
    }

    public studentModel getStudent() {
        return student;
    }

    public void setStudent(studentModel student) {
        this.student = student;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
