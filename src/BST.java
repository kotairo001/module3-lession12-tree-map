import java.util.LinkedList;
import java.util.Queue;

public class BST<E> {
    class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    Node root;

    public void BST_Binary() {
        root = null;
    }

    public void insert(int key) {
        root = insert_Recursive(root, key);
    }

    Node insert_Recursive(Node root, int key) {
        if (root == null) {
            root = new Node(key);
        }
        if (key < root.key) {
            root.left = insert_Recursive(root.left, key);
        }
        if (key > root.key) {
            root.right = insert_Recursive(root.right, key);
        }
        return root;
    }

    public void postOrder() {
        postOrder_Recursive(root);
    }

    public void postOrder_Recursive(Node root) {
        if (root != null) {
            postOrder_Recursive(root.left);
            postOrder_Recursive(root.right);
            System.out.print(root.key + " ");
        }
    }

    public void inOrder() {
        inOrder_Recursive(root);
    }

    public void inOrder_Recursive(Node root) {
        if (root != null) {
            inOrder_Recursive(root.left);
            System.out.print(root.key + " ");
            inOrder_Recursive(root.right);
        }
    }

    public void preOrder() {
        preOrder_Recursive(root);
    }

    public void breadthFirst() {
        breadthFirst_Recursive(root);
    }

    void breadthFirst_Recursive(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.key + " ");

            /*add left child to the queue */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public void preOrder_Recursive(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrder_Recursive(root.left);
            preOrder_Recursive(root.right);
        }
    }

    public void deleteKey(int key) {
        delete_Recursive(root, key);
    }

    Node delete_Recursive(Node root, int key) {
        if (root == null) return root;
        if (key < root.key) {
            root.left = delete_Recursive(root.left, key);
        } else if (key > root.key) {
            root.right = delete_Recursive(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.key = minValue(root.right);
            root.right = delete_Recursive(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    ;

    public boolean search(int key) {
        root = search_Recursive(root, key);
        if (root != null) {
            return true;
        } else return false;
    }

    Node search_Recursive(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }
        if (root.key > key) {
            return search_Recursive(root.left, key);
        }
        return search_Recursive(root.right, key);
    }
}
