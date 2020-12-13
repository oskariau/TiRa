package tree;

/**
 *
 * @author kamaj
 */
public class BinaryTree {

    private Node root;
    
    public BinaryTree(int rootValue) {
        root = new Node(rootValue);
    }
    public BinaryTree(){
        root = null;
    }
    /*public BinaryTree(String rootValue, BinaryTree left, BinaryTree right){
        root = new Node(rootValue, left, right);
    } */
    
    public void insert(int value){
    	// Insert value into tree
        root = addRecursive(root, value);
    }
    
    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
     
        if (value < current.getData()) {
            current.setLeft(addRecursive(current.left(), value));
        } else if (value > current.getData()) {
            current.setRight(addRecursive(current.right(), value));
        } else {
            // value already exists
            return current;
        }
     
        return current;
    }
    
    public Node find(int value){
        // Find a node with value from tree
        return findNodeRecursive(root, value);
    }
    
    private Node findNodeRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.getData()) {
            return current;
        }

        return value < current.getData()
          ? findNodeRecursive(current.left(), value)
          : findNodeRecursive(current.right(), value);
    }
    
    public void delete(int value) {
    	// Delete anode with value from tree
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.getData()) {
            // Case 1: no children
            if (current.left() == null && current.right() == null) {
                return null;
            }

            // Case 2: only 1 child
            if (current.right() == null) {
                return current.left();
            }

            if (current.left() == null) {
                return current.right();
            }

            // Case 3: 2 children
            int smallestValue = findSmallestValue(current.right());
            current.setData(smallestValue);
            current.setRight(deleteRecursive(current.right(), smallestValue));
            return current;
        }
        if (value < current.getData()) {
            current.setLeft(deleteRecursive(current.left(), value));
            return current;
        }

        current.setRight(deleteRecursive(current.right(), value));
        return current;
    }
    
    private int findSmallestValue(Node root) {
        return root.left() == null ? root.getData() : findSmallestValue(root.left());
    }
    
 // method to check if a node is leaf or not
    public static boolean isLeaf(Node a){
        if(a.right()==null && a.left()==null)
            return true;
        return false;
    }

    // function to return maximum of two numbers
    public static int getMax(int a, int b){
        return (a>b) ? a : b;
    }
    
    public int getHeight(Node a) {
    	if (a == null || isLeaf(a)) return 0;
    	
    	//height of a node will be 1+ greater among height of right subtree and height of left subtree
        return(getMax(getHeight(a.left()), getHeight(a.right())) + 1);
    }
    
    public Node root() {
    	return root;
    }
    /*
    public void preOrder() {
        if (root != null) {
            System.out.println(root.getData()+',');
            if (root.left() != null) // pääseeekö vasemmalle?
                root.left().preOrder();
            if (root.right() != null) // pääseekö oikealle?
                root.right().preOrder();
        }

    }*/
  
    public void setLeft(Node tree) {
        root.setLeft(tree);
    }

    public void setRight(Node tree) {
        root.setRight(tree);
    }
}
