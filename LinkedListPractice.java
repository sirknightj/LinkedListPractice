/**
 * This class allows a user to modify the yourCode method, along with the start and
 * end p and q in order to practice manipulating linked lists, and playing around with
 * each node's fields. The user should re-arrange the Nodes by changing the links, and
 * not changing the numerical data stored inside the Nodes.
 */
public class LinkedListPractice {
    /**
     * Modify the start and end to fit your needs. All of the
     * numbers in the start must appear in the end.
     */
    public static int[] startp = {1, 3};
    public static int[] startq = {2};
    public static int[] endp = {1, 2, 3};
    public static int[] endq = {};

    public static void yourCode() {
        // Insert your code here e.g. "q.next = p;"



    }

    public static Node p, q;

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
        if(yourp.equals(pFinal)) {
            System.out.println("p is correct");
        } else {
            System.out.println("Sorry, p is incorrect");
            System.out.println("Your p: " + yourp);
            System.out.println("Correct p: " + pFinal);
            yay = false;
        }
        if(yourq.equals(qFinal)) {
            System.out.println("q is correct");
        } else {
            System.out.println("Sorry, q is incorrect");
            System.out.println("Your q: " + yourq);
            System.out.println("Correct q: " + qFinal);
            yay = false;
        }
        if(yay) {
            System.out.println("Congrats! You did it!");
        }
    }

    public static Node construct(int[] array) {
        return construct(array, 0);
    }

    private static Node construct(int[] array, int n) {
        if(n == array.length) {
            return null;
        } else {
            return new Node(array[n], construct(array, n + 1));
        }
    }

    public static String check(Node n) {
        return check(n, "");
    }

    private static String check(Node n, String soFar) {
        if(n == null) {
            return "/";
        } else {
            return "" + n.data + " -> " + check(n.next);
        }
    }
}

/**
 * The nodes that make up the Linked List.
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
     * @param data  The data for this Node to store.
     */
    public Node(int data) {
        this(data, null);
    }

    /**
     * Creates a new Node with data, and a next Node.
     * @param data  The data for this Node to store.
     * @param next  The next node that this should point to.
     */
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
