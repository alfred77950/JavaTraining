/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treejoin;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alfredo Maldonado
 */
public class BinaryTreeTest {
    
    public BinaryTreeTest() {
    }

    /**
     * Test of insert method, of class BinaryTree.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        BinaryTree instance = new BinaryTree();
        instance.insert(5);
        Node<Integer> expectedResult = new Node(5);
        Assert.assertEquals(expectedResult.getValue(), instance.root.getValue());
    }

    /**
     * Test of insertTree method, of class BinaryTree.
     */
    @Test
    public void testInsertTree() throws Exception {
        System.out.println("insertTree");
        BinaryTree binaryTreeCharacter = new BinaryTree();
        binaryTreeCharacter.insert('F');
        binaryTreeCharacter.insert('H');
        binaryTreeCharacter.insert('G');
        binaryTreeCharacter.insert('I');

        BinaryTree binaryTreeCharacter2 = new BinaryTree();
        binaryTreeCharacter2.insert('C');
        binaryTreeCharacter2.insert('A');
        binaryTreeCharacter2.insert('B');
        
        binaryTreeCharacter.insertTree('F', binaryTreeCharacter2);
        
        Assert.assertEquals(4, binaryTreeCharacter.getLevel());
    }

    /**
     * Test of removeNode method, of class BinaryTree.
     */
    @Test
    public void testRemoveNode() {
        BinaryTree binaryTreeCharacter = new BinaryTree();
        binaryTreeCharacter.insert('F');
        binaryTreeCharacter.insert('H');
        binaryTreeCharacter.insert('I');
        binaryTreeCharacter.insert('J');

        binaryTreeCharacter.removeNode('H');
        
        Assert.assertEquals(null, binaryTreeCharacter.findNode('H'));
    }

    /**
     * Test of getLevel method, of class BinaryTree.
     */
    @Test
    public void testGetLevel() {
        BinaryTree binaryTreeCharacter = new BinaryTree();
        binaryTreeCharacter.insert('C');
        binaryTreeCharacter.insert('B');
        binaryTreeCharacter.insert('A');
        
        Assert.assertEquals(3, binaryTreeCharacter.getLevel());
    }

    /**
     * Test of findNode method, of class BinaryTree.
     */
    @Test
    public void testFindNode() {
        BinaryTree binaryTreeCharacter = new BinaryTree();
        binaryTreeCharacter.insert(1);
        binaryTreeCharacter.insert(3);
        binaryTreeCharacter.insert(4);
        binaryTreeCharacter.insert(6);

        Node<Integer> node = binaryTreeCharacter.findNode(4);
        Integer expectedResult = 4;
        Assert.assertEquals(expectedResult, node.getValue());
    }

    /**
     * Test of balanceTree method, of class BinaryTree.
     */
    @Test
    public void testBalanceTree() {
        BinaryTree binaryTreeCharacter = new BinaryTree();
        binaryTreeCharacter.insert('A');
        binaryTreeCharacter.insert('B');
        binaryTreeCharacter.insert('C');
        binaryTreeCharacter.insert('D');
        binaryTreeCharacter.insert('E');
        binaryTreeCharacter.insert('F');
        
        binaryTreeCharacter.balanceTree();
        
        Assert.assertEquals(3, binaryTreeCharacter.getLevel());
    }

    /**
     * Test of isEmpty method, of class BinaryTree.
     */
    @Test
    public void testIsEmpty() {
        BinaryTree binaryTreeCharacter = new BinaryTree();
        binaryTreeCharacter.insert('A');
        
        Assert.assertEquals(binaryTreeCharacter.isEmpty(), false);
    }

    /**
     * Test of control the repeatable nodes, of class BinaryTree.
     */
    @Test
    public void testControlRepetable() {
        BinaryTree binaryTreeCharacter = new BinaryTree();
        binaryTreeCharacter.insert(1);
        binaryTreeCharacter.insert(1);
        binaryTreeCharacter.insert(1);
        binaryTreeCharacter.insert(1);
        
        Assert.assertEquals(1, binaryTreeCharacter.getLevel());
    }
    
    /**
     * Test of exception message when level is greater that five, of class BinaryTree.
     */
    @Test
    public void testExceptionWhenLevelIsGreater() {
        try{ 
            BinaryTree binaryTreeCharacter = new BinaryTree();
            binaryTreeCharacter.insert('F');
            binaryTreeCharacter.insert('D');
            binaryTreeCharacter.insert('H');
            binaryTreeCharacter.insert('C');
            binaryTreeCharacter.insert('E');
            binaryTreeCharacter.insert('G');
            binaryTreeCharacter.insert('I');
            binaryTreeCharacter.insert('J');


            BinaryTree binaryTreeCharacter2 = new BinaryTree();
            binaryTreeCharacter2.insert('Q');
            binaryTreeCharacter2.insert('P');
            binaryTreeCharacter2.insert('R');

            binaryTreeCharacter.insertTree('J', binaryTreeCharacter2);
        } catch(Exception ex){
            assertEquals("Invalid operation because the level is greather than 5.", ex.getMessage());
        }
    }
    
    /**
     * Test of exception message when insert tree in node does not exist, of class BinaryTree.
     */
    @Test
    public void testExceptionWhenNodeDoesNotExist() {
        try{ 
           BinaryTree binaryTreeCharacter = new BinaryTree();
            binaryTreeCharacter.insert('F');
            binaryTreeCharacter.insert('D');
            binaryTreeCharacter.insert('H');
            binaryTreeCharacter.insert('C');
            binaryTreeCharacter.insert('E');
            binaryTreeCharacter.insert('G');
            
            BinaryTree binaryTreeCharacter2 = new BinaryTree();
            binaryTreeCharacter2.insert('Q');
            binaryTreeCharacter2.insert('P');
            binaryTreeCharacter2.insert('R');
            
            binaryTreeCharacter.insertTree('L', binaryTreeCharacter2);
        } catch(Exception ex){
            assertEquals("The value does not exit in the tree", ex.getMessage());
        }
    }
    
    /**
     * Test of exception message when insert tree in node that has two child, of class BinaryTree.
     */
    @Test
    public void testExceptionWhenNodeHasTwoChilds() {
        try{ 
            BinaryTree binaryTreeCharacter = new BinaryTree();
            binaryTreeCharacter.insert('F');
            binaryTreeCharacter.insert('D');
            binaryTreeCharacter.insert('H');
            binaryTreeCharacter.insert('C');
            binaryTreeCharacter.insert('E');
            
            BinaryTree binaryTreeCharacter2 = new BinaryTree();
            binaryTreeCharacter2.insert('Q');
            binaryTreeCharacter2.insert('P');
            binaryTreeCharacter2.insert('R');

            binaryTreeCharacter.insertTree('D', binaryTreeCharacter2);
            
        } catch(Exception ex){
            assertEquals("It can not insert, it already have a child right node.", ex.getMessage());
        }
    }
}
