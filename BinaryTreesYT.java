import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreesYT {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public Node buildtree(int node[]) {
            idx++;
            if (node[idx] == -1) {
                return null;
            }
            Node newNode = new Node(node[idx]);
            newNode.left = buildtree(node);
            newNode.right = buildtree(node);
            return newNode;
        }
    }
    
    public static void  preOrder(Node root){
        if(root == null){
            System.out.print(-1+" ");
           return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void  inOrder(Node root){
        if(root == null){
            System.out.print(-1+" ");
           return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void  postOrder(Node root){
        if(root == null){
            System.out.print(-1+" ");
           return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    public static void levelOrder(Node root){
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currentNode = q.remove();
            if (currentNode==null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                }
                else{
                    q.add(null);
                }
            } else {
                System.out.println(currentNode.data+" ");
                q.add(currentNode.left);
                q.add(currentNode.right);
                // need to write remaining code........
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildtree(nodes);
        System.out.println(root.data);
        System.out.println("\nPre-order traversal");
        preOrder(root);
        System.out.println("\nIn-order traversal");
        inOrder(root);
        System.out.println("\nPost-order traversal");
        postOrder(root);
        System.out.println("\nLevel Order Traversal");
        levelOrder(root);
    }
}
