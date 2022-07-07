public class BinarySearchTree {

    // nested class Node
    public class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

    }

    private Node root;

    public Node insertNode(Node current, int newValue){

        // If BST is empty
        if (root == null){
            root = new Node(newValue);
            return root;
        }

        if (current == null){
            return new Node(newValue);
        }

        if (newValue < current.value){
            current.left = insertNode(current.left, newValue);
        }
        else if (newValue > current.value){
            current.right = insertNode(current.right, newValue);
        }

        return current;

    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

}
