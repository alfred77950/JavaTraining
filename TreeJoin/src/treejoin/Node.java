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
    
    @Override
    public String toString() {
        return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
    }
    
    private StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder stringBuilder) {
        if(getRight() != null) {
            getRight().toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, stringBuilder);
        }
        stringBuilder.append(prefix).append(isTail ? "└── " : "┌── ").append(getValue().toString()).append("\n");
        
        if(getLeft() != null) {
            getLeft().toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, stringBuilder);
        }
        
        return stringBuilder;
    }
}
