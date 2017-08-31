package lab5;
import java.util.*;
class Node<T extends Comparable<T>> {
    private T value;
    private Node<T> left;
    private Node<T> right;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
} 

public class BST<T extends Comparable<T>> {
    private Node<T> root;
    ArrayList<T> list=new ArrayList<T>();

	public BST(T value) {
        root = new Node<T>(value);
    }
    public Node<T> getRoot() {
		return root;
	}
    
    public ArrayList<T> getList(){
    	return list;
    }
    
    public void insert(Node<T> node,T value) {
    	if(value.compareTo(node.getValue()) <= 0) {
            if(node.getLeft() == null)
            	node.setLeft(new Node<T>(value));
            else
                insert(node.getLeft(), value);
        }
        else {
            if(node.getRight() == null)
            	node.setRight(new Node<T>(value));
            else
                insert(node.getRight(), value);
        }
    }
    public void inorder(Node<T> node){
    	if (node==null){
    		return;
    	}
    	else{
    		inorder(node.getLeft());
    		list.add(node.getValue());
    		inorder(node.getRight());
    	}
    }
}

