/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treejoin;

import java.util.ArrayList;

/**
 *
 * @author Alfredo Maldonado
 */
public class BinaryTree<T extends Comparable<T>> implements Tree<T> {
    
    private static final int MAX_LEVEL = 5;
    
    public Node<T> root;

    public BinaryTree() {
        this.root = null;
    }
    
    @Override
    public void insert(T value) {
        if (this.isEmpty()) {
            this.root = new Node(value);
        } else {
            Node nodeFound = findNode(value);
            if (nodeFound == null) {
                insert(this.root, value);
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
        this.validateLevel(tree, value);
        
        Node nodeFound = findNode(value);
        
        if (nodeFound == null) {
            throw new Exception("The value does not exit in the tree");
        }
        
        if (value.compareTo(tree.root.getValue()) > 0) {
            if (nodeFound.getLeft() != null) {
                throw new Exception("It can not insert, it already have a child left node.");
            }
            
            nodeFound.setLeft(tree.root);
        } else {
            if (nodeFound.getRight() != null) {
                throw new Exception("It can not insert, it already have a child right node.");
            }
            nodeFound.setRight(tree.root);
        }
    }
    
    public Node<T> removeNode (T value) {
        return removeNode(this.root, value);
    }
    
    private Node<T> removeNode(Node<T> node, T value) {
        if (node == null) {
            return node;
        }
        
        if (value.compareTo(node.getValue()) < 0) {
            node.setLeft(removeNode(node.getLeft(), value));
        } else if (value.compareTo(node.getValue()) > 0) {
            node.setRight(removeNode(node.getRight(), value));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null){
                return node.getLeft();
            }
            
            Node<T> auxiliar = findMinValue(node.getRight());
            node.setValue(auxiliar.getValue());
            node.setRight(removeNode(node.getRight(), node.getValue()));
        }

        return node;
    }
    
    @Override
    public int getLevel() {
        if (this.isEmpty()) {
            return 0;
        } else {
            return getLevel(this.root);
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
    
    private int getLevelByNode(Node<T> node, T data, int level)  
    { 
        if (node == null)
            return 0;
   
        if (node.getValue().equals(data)) {
            return level;
        }
   
        int resultLevel = getLevelByNode(node.getLeft(), data, level + 1);
        
        if (resultLevel != 0)
            return resultLevel;
   
        resultLevel = getLevelByNode(node.getRight(), data, level + 1);
        
        return resultLevel; 
    } 
    
    public Node<T> findNode(T value) {
        return findNode(this.root, value);
    }
    
    private Node<T> findNode(Node<T> node, T value) {
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
    
    public void balanceTree() {
        balanceTree(this.root);
    }
    
    private void balanceTree(Node<T> node)
    {
        ArrayList<Node<T>> nodes = new ArrayList<>();
        saveNodes(node, nodes);
        this.root = null;
        int size = nodes.size();
        
        balanceTreebyMiddleNode(nodes, 0, size - 1);
    }
    
    private Node balanceTreebyMiddleNode(ArrayList<Node<T>> nodes, int start, int end)
    {
        if (start > end) {
            return null;
        }
        
        int middle = (start + end) / 2;
        Node<T> middleNode = nodes.get(middle);
        this.insert(middleNode.getValue());
        middleNode.setLeft(balanceTreebyMiddleNode(nodes, start, middle - 1));
        middleNode.setRight(balanceTreebyMiddleNode(nodes, middle + 1, end));
        
        return middleNode;
    } 
    
    private void saveNodes(Node root, ArrayList<Node<T>> nodes)
    {
        if (root == null) {
            return;
        }
        
        saveNodes(root.getLeft(), nodes);
        nodes.add(root);
        saveNodes(root.getRight(), nodes);
    }
    
    private Node<T> findMinValue(Node<T> node) 
    { 
        Node minv = node;
        while (node.getLeft() != null) 
        { 
            minv = node.getLeft();
            node = node.getLeft();
        } 
        
        return minv; 
    } 
    
    private void validateLevel(BinaryTree<T> tree, T value) throws Exception {
        int totalLevel = this.getLevelByNode(this.root, value, 1) + tree.getLevel();
        
        if (totalLevel > MAX_LEVEL) {
            throw new Exception("Invalid operation because the level is greather than 5.");
        }
    }
    
    @Override
    public boolean isEmpty() {
        return root == null;
    }
    
    @Override
    public String toString() {
        return this.root.toString();
    }
}