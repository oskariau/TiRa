package tree;


/**
 *
 * @author kamaj
 */
public class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int value) {
        data = value;
        left = right = null;
    }
    public  Node (int value, Node left, Node right) {
        data = value;
        this.left = left;
        this.right = right;
    }
    public int getData() {
        return data;
    }
    public void setData(int value) {
    	data = value;
    }
    public Node left() {
        return left;
    }
    public Node right() {
        return right;
    }
    public void setLeft(Node tree) {
        left = tree;
    }
    public void setRight(Node tree) {
        right = tree;
    }


}
