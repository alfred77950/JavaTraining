/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treejoin;

/**
 *
 * @author Alfredo Maldonado
 */
public class Node<T> {
    private T value;
    
    private Node left;
    
    private Node right;
    
    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
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
    
    public void print() {
        print("", this, false);
    }

    private void print(String prefix, Node node, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + node.value);
            print(prefix + (isLeft ? "|   " : "    "), node.left, true);
            print(prefix + (isLeft ? "|   " : "    "), node.right, false);
        }
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + ", left=" + left + ", right=" + right + '}';
    }
}
