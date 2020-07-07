import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

//Sum of leaf nodes at minimum level
public class SumOfLeafNode {

    private static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            //this.left = null;
            //this.right = null;
        }
    }


    // function to get a new node
    static Node getNode(int data) {
        return new Node(data);
    }

    static int sumOfLeafNodesAtMinLevel(Node root) {
        // if tree is empty
        if (root == null)
            return 0;

        // if there is only one node
        if (Objects.isNull(root.left) && Objects.isNull(root.right))
            return root.data;

        // queue used for level order traversal
        Queue<Node> q = new LinkedList<>();
        int sum = 0;
        boolean f = false;

        // push root node in the queue 'q'
        q.add(root);

        while (!f) {

            // count number of nodes in the current level
            int nc = q.size();

            // traverse the current level nodes
            while (nc-- > 0) {

                // get front element from 'q'
                Node top = q.peek();
                q.remove();

                // if it is a leaf node
                if (Objects.isNull(top.left) && Objects.isNull(top.right)) {
                    sum += top.data;
                    // set flag 'f' to 1, to signify
                    // minimum level for leaf nodes
                    // has been encountered
                    f = true;
                } else {
                    // if top's left and right child exists, then push them to 'q'
                    if (Objects.nonNull(top.left)) q.add(top.left);
                    if (Objects.nonNull(top.right)) q.add(top.right);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Node root = getNode(1);
        root.left = getNode(2);
        root.right = getNode(3);
        root.left.left = getNode(4);
        root.left.right = getNode(5);
        root.right.left = getNode(6);
        root.right.right = getNode(7);
        root.left.right.left = getNode(8);
        root.right.left.right = getNode(9);

        System.out.println("Sum = " +
                sumOfLeafNodesAtMinLevel(root));
    }

}
