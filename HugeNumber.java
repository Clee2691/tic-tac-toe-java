import java.util.ArrayList;

public class HugeNumber {
    private class Node {
        int digit;
        Node next;
        Node prev;

        public Node(int digit, Node next, Node prev) {
            this.digit = digit;
            this.next = next;
            this.prev = prev;
        }
    }

    public Node head;
    public Node tail;

    // Default constructor
    public HugeNumber() {
        head = null;
        tail = null;
    }

    // Copy constructor
    public HugeNumber(HugeNumber other) {
        if (other == null) {
            System.out.println("Fatal error: Empty HugeNumber");
            System.exit(0);
        }

        HugeNumber num = new HugeNumber();
        Node currentOther = other.head;

        while (currentOther != null) {
            num.addNodeRight(currentOther.digit);
            currentOther = currentOther.next;
        }
        head = num.head;
        tail = num.tail;
    }

    // Functions to add nodes at the beginning or end of linked list
    public void addNodeLeft(int digit) {
        if (head == null) {
            head = new Node(digit, null, null);
            tail = head;
        }
        else {
            head.prev = new Node(digit, head, null);
            head = head.prev;
        }
    }

    public void addNodeRight(int digit) {
        if (head == null) {
            head = new Node(digit, null, null);
            tail = head;
        }
        else {
            tail.next = new Node(digit, null, tail);
            tail = tail.next;
        }
    }

    public HugeNumber add(HugeNumber other) {
        HugeNumber sum = new HugeNumber();
        Node current = this.tail;
        Node otherCurrent = other.tail;

        int carryOver = 0;

        while (current != null && otherCurrent != null) {
            int num1 = current.digit;
            int num2 = otherCurrent.digit;

            int digitSum = num1 + num2;
            if (digitSum + carryOver >= 10) {
                int onesDigit = (digitSum + carryOver) - 10;
                carryOver = 1;
                sum.addNodeLeft(onesDigit);
            }
            else {
                sum.addNodeLeft(digitSum + carryOver);
                carryOver = 0;
            }
            current = current.prev;
            otherCurrent = otherCurrent.prev;
        }

        Node newCurrent = null;
        if (current != null) {
            newCurrent = current;
        }
        else if (otherCurrent != null) {
            newCurrent = otherCurrent;
        }

        while (newCurrent != null) {
            sum.addNodeLeft(newCurrent.digit + carryOver);
            carryOver = 0;
            newCurrent = newCurrent.prev;
        }

        return sum;
    }

    public String toString() {
        String value = "";
        Node current = head;
        while (current != null) {
            value += current.digit;
            current = current.next;
        }
        return value;
    }

    public void reset() {
        head = null;
        tail = null;
    }

    public static void main(String[] args) {
        HugeNumber num = new HugeNumber();
        num.addNodeRight(1);
        num.addNodeRight(6);
         num.addNodeRight(1);
        num.addNodeRight(8);
        num.addNodeRight(0);
        num.addNodeRight(3);
        System.out.println("Testing addNodeRight. Expected: 161803, Actual: " + num.toString());

        HugeNumber num2 = new HugeNumber();
        num2.addNodeRight(1);
        num2.addNodeLeft(4);
        System.out.println("Testing addNodeLeft(). Expected: 41, Actual: " + num2.toString());

        HugeNumber n3 = new HugeNumber(num);
        System.out.println("Testing copy constructor. Expected: 161803, Actual: " + n3);

        HugeNumber n4 = new HugeNumber();
        n4.addNodeRight(4);
        n4.addNodeRight(4);
        n4.addNodeRight(4);

        HugeNumber n5 = new HugeNumber();
        n5.addNodeRight(2);
        n5.addNodeRight(1);
        n5.addNodeRight(9);
        n5.addNodeRight(0);

        HugeNumber sum = n4.add(n5);
        System.out.println("Testing sum method. Expected: 444 + 2190 = 2634, Actual: " + n4.toString() +" + " +
                n5.toString() + " = " + sum.toString());
    }
}
