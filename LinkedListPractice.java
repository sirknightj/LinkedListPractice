import java.util.HashSet;
import java.util.Set;

/**
 * This class allows a user to modify the yourCode method, along with the start and
 * end p and q in order to practice manipulating linked lists, and playing around with
 * each node's fields. The user should re-arrange the Nodes by changing the links, and
 * not changing the numerical data stored inside the Nodes.
 */
public class LinkedListPractice {
    /**
     * Modify the start and end to fit your needs. All of the
     * numbers in the start must appear in the end. Insert your
     * code in the yourCode method.
     */
    public static int[] startp = {1, 3};
    public static int[] startq = {2};
    public static int[] endp = {1, 2, 3};
    public static int[] endq = {};

    public static void yourCode() {
        // Insert your code here e.g. "q.next = p;"


    }

    public static Node p, q;

    /**
     * This will print out the initial p and q, then it will print out the
     * correct p and q. Afterwards, it will compare your p and q to the correct
     * answers, and tell you if you got it right.
     */
    public static void main(String[] args) {
        p = construct(startp);
        System.out.println("Initial p: " + check(p));
        q = construct(startq);
        System.out.println("Initial q: " + check(q));
        yourCode();
        String yourp = check(p);
        String yourq = check(q);
        Node correctp = construct(endp);
        String pFinal = check(correctp);
        System.out.println("Correct p: " + pFinal);
        Node correctq = construct(endq);
        String qFinal = check(correctq);
        System.out.println("Correct q: " + qFinal + "\n");
        boolean yay = true;
        if (yourp.equals(pFinal)) {
            System.out.println("p is correct");
        } else {
            System.out.println("Sorry, p is incorrect");
            System.out.println("Your p:    " + yourp);
            System.out.println("Correct p: " + pFinal);
            yay = false;
        }
        if (yourq.equals(qFinal)) {
            System.out.println("q is correct");
        } else {
            System.out.println("Sorry, q is incorrect");
            System.out.println("Your q:    " + yourq);
            System.out.println("Correct q: " + qFinal);
            yay = false;
        }
        if (yay) {
            System.out.println("Congrats! You did it!");
        }
    }

    /**
     * This will construct a Node from a given array of integers, with each
     * sequential node in the array being linked to each other.
     *
     * @param array     The array with the data fields to put in each Node
     * @return          A new Node linked to the rest of the values in the array.
     */
    public static Node construct(int[] array) {
        return construct(array, 0);
    }

    /**
     * This will construct a Node from a given array of integers, with each
     * sequential node in the array being linked to each other.
     *
     * @param array     The array with the data fields to put in each Node.
     * @param n         The current index of the array the program is constructing.
     * @return          A new Node linked to the rest of the values in the array.
     */
    private static Node construct(int[] array, int n) {
        if (n == array.length) {
            return null;
        } else {
            return new Node(array[n], construct(array, n + 1));
        }
    }

    /**
     * This will create a String representation of the linked list, the data of each
     * Node pointing to the next data of the next Node. A null next is represented with
     * a "/" and this will check for a circular linked list.
     *
     * @param n     The start of the linked list
     * @return      A string representation of all of what all the nodes are pointing to in the
     *              linked list.
     */
    public static String check(Node n) {
        return check(n, "", new HashSet<>());
    }

    /**
     * This will create a String representation of the linked list, the data of each
     * Node pointing to the next data of the next Node. A null next is represented with
     * a "/" and this will check for a circular linked list. Checks for circular linked lists,
     * and will add the String "Circular Linked List Error!" to the end of the String
     * representation of the linked list.
     *
     * @param n                 The Node that this should continue writing till the end for.
     * @param soFar             The String representation of the linked list so far.
     * @param circularCheck     A set that contains all of the nodes that have been considered
     *                          so far.
     * @return                  A string representation of the linked list from this node until
     *                          it runs out of next's.
     */
    private static String check(Node n, String soFar, Set<Node> circularCheck) {
        if (n == null) {
            return "/";
        } else if (circularCheck.contains(n)) {
            return n.data + " Circular Linked List Error!";
        } else {
            circularCheck.add(n);
            return "" + n.data + " -> " + check(n.next);
        }
    }
}

/**
 * The nodes that make up the Linked List. This node stores a single integer, and
 * a reference to another Node.
 */
class Node {
    public int data;
    public Node next;

    /**
     * Creates a new Node with 0 as the data, and no next Node.
     */
    public Node() {
        this(0, null);
    }

    /**
     * Creates a new Node with data, and no next Node.
     *
     * @param data  The data for this Node to store.
     */
    public Node(int data) {
        this(data, null);
    }

    /**
     * Creates a new Node with data, and a next Node.
     *
     * @param data  The data for this Node to store.
     * @param next  The next node that this should point to.
     */
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
