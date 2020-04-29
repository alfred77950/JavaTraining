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
public class BinaryTree<T extends Comparable<T>> implements Tree<T> {
    
    private static final int MAX_LEVEL = 5;
    
    private Node<T> node;

    public BinaryTree() {
        this.node = null;
    }
    
    @Override
    public void insert(T value) {
        if (this.isEmpty()) {
            this.node = new Node(value);
        } else {
            Node nodeFound = findNode(value);
            if (nodeFound == null) {
                insert(this.node, value);
            }
        }
    }
    
    private void insert(Node<T> node, T value) {
        if (value.compareTo(node.getValue()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(value));
            } else {
                insert(node.getLeft(), value);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new Node(value));
            } else {
                insert(node.getRight(), value);
            }
        }
    }
    
    public void insertTree(T value, BinaryTree<T> tree) throws Exception {
        this.validateLevel(tree);
        
        Node nodeFound = findNode(value);
        
        if (nodeFound == null) {
            throw new Exception("The value does not exit in the tree");
        }
        
        if (value.compareTo(tree.node.getValue()) > 0) {
            if (nodeFound.getLeft() != null) {
                throw new Exception("It can not insert, it already have a child left node.");
            }
            
            nodeFound.setLeft(tree.node);
        } else {
            if (nodeFound.getRight() != null) {
                throw new Exception("It can not insert, it already have a child right node.");
            }
            nodeFound.setRight(tree.node);
        }
    }
    
    @Override
    public int getLevel() {
        if (this.isEmpty()) {
            return 0;
        } else {
            return getLevel(this.node);
        }
    }
    
    private int getLevel(Node node) {
        if (node == null) {
            return 0;
        }
        
        int leftLevel = getLevel(node.getLeft());
        int rightLevel = getLevel(node.getRight());
        int result = (leftLevel > rightLevel) ? leftLevel : rightLevel;
        
        return result + 1;
    }
    
    public Node<T> findNode(T value) {
        return findNode(this.node, value);
    }
    
    public Node<T> findNode(Node<T> node, T value) {
        if (node == null) {
            return null;
        }
        
        T valueNode = node.getValue();
        
        if (value == node.getValue()) {
            return node;
        }
        
        if (value.compareTo(valueNode) < 0) {
            return findNode(node.getLeft(), value);
        } else {
            return findNode(node.getRight(), value);
        }
    }
    
    private void validateLevel(BinaryTree<T> tree) throws Exception {
        int totalLevel = this.getLevel() + tree.getLevel();
        
        if (totalLevel > MAX_LEVEL) {
            throw new Exception("Invalid operation because the level is greather than 5.");
        }
    }
    
    @Override
    public boolean isEmpty() {
        return node == null;
    }
    
    public void print() {
        this.node.print();
    }
}