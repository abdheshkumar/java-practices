import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

//Find maximum level sum in Binary Tree
public class FindMaximumLevelSumInBinaryTree {
    public static void main(String[] args) {
        Node root = Node.getNode(1);
        root.left = Node.getNode(2);
        root.right = Node.getNode(3);
        root.left.left = Node.getNode(4);
        root.left.right = Node.getNode(5);
        root.right.right = Node.getNode(8);
        root.right.right.left = Node.getNode(6);
        root.right.right.right = Node.getNode(7);
        System.out.println(sumOfLeafNodesAtMinLevel(root));
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
        // push root node in the queue 'q'
        q.add(root);
        int result = 0;
        while (!q.isEmpty()) {

            // count number of nodes at the current level
            int nc = q.size();
            int sum = 0;
            // traverse the current level nodes
            while (nc-- > 0) {
                // get front element from 'q'
                Node top = q.peek();
                q.remove();
                // Add this node's value to current sum.
                sum = sum + top.data;
                if (Objects.nonNull(top.left)) q.add(top.left);
                if (Objects.nonNull(top.right)) q.add(top.right);
            }
            result = Math.max(result, sum);
        }
        return result;
    }
}

class Node {
    int data;
    Node left, right;

    private Node(int data) {
        this.data = data;
        //this.left = null;
        //this.right = null;
    }

    // function to get a new node
    static Node getNode(int data) {
        return new Node(data);
    }
}

