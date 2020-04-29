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
public class TreeJoin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            BinaryTree binaryTreeCharacter = new BinaryTree();
            binaryTreeCharacter.insert('F');
            binaryTreeCharacter.insert('D');
            binaryTreeCharacter.insert('H');
            binaryTreeCharacter.insert('C');
            binaryTreeCharacter.insert('E');
            binaryTreeCharacter.insert('G');
            binaryTreeCharacter.insert('I');
            
            BinaryTree binaryTreeCharacter2 = new BinaryTree();
            binaryTreeCharacter2.insert('Q');
            binaryTreeCharacter2.insert('P');
            binaryTreeCharacter2.insert('R');
            
            System.out.println("----------------- Join two trees of characters ----------------");
            System.out.println("\n///////First tree.");
            binaryTreeCharacter.print();
            System.out.println("Level: " + binaryTreeCharacter.getLevel());
            System.out.println("\n///////Second tree.");
            binaryTreeCharacter2.print();
            System.out.println("Level: " + binaryTreeCharacter2.getLevel());
            System.out.println("\n///////Tree Join."); 
            binaryTreeCharacter.insertTree('I', binaryTreeCharacter2);
            binaryTreeCharacter.print();
            System.out.println("Level: " + binaryTreeCharacter.getLevel());
            System.out.println("---------------------------------");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
            BinaryTree binaryTree = new BinaryTree();
            binaryTree.insert(6);
            binaryTree.insert(4);
            binaryTree.insert(8);
            binaryTree.insert(3);
            binaryTree.insert(5);
            binaryTree.insert(7);
            binaryTree.insert(9);

            BinaryTree binaryTree2 = new BinaryTree();
            binaryTree2.insert(16);
            binaryTree2.insert(18);
            
            System.out.println("----------------- Join two trees of numbers ----------------");
            System.out.println("\n///////First tree.");
            binaryTree.print();
            System.out.println("Level: " + binaryTree.getLevel());
            System.out.println("\n///////Second tree.");
            binaryTree2.print();
            System.out.println("Level: " + binaryTree2.getLevel());
            System.out.println("\n///////Tree Join."); 
            binaryTree.insertTree(5, binaryTree2);
            binaryTree.print();
            System.out.println("Level: " + binaryTree.getLevel());
            System.out.println("---------------------------------");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        try {
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
            
            System.out.println("----------------- Message when level is greather than 5 ----------------");
            System.out.println("\n///////First tree.");
            binaryTreeCharacter.print();
            System.out.println("Level: " + binaryTreeCharacter.getLevel());
            System.out.println("\n///////Second tree.");
            binaryTreeCharacter2.print();
            System.out.println("Level: " + binaryTreeCharacter2.getLevel());
            
            
            binaryTreeCharacter.insertTree('I', binaryTreeCharacter2);
            
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            System.out.println("---------------------------------");
        }
        
        try {
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
            
            System.out.println("----------------- Message when value does not exist ----------------");
            System.out.println("\n///////First tree.");
            binaryTreeCharacter.print();
            System.out.println("Level: " + binaryTreeCharacter.getLevel());
            System.out.println("\n///////Second tree.");
            binaryTreeCharacter2.print();
            System.out.println("Level: " + binaryTreeCharacter2.getLevel());
            
            
            binaryTreeCharacter.insertTree('L', binaryTreeCharacter2);
            
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            System.out.println("---------------------------------");
        }
        
        try {
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
            
            System.out.println("----------------- Message when node has childs ----------------");
            System.out.println("\n///////First tree.");
            binaryTreeCharacter.print();
            System.out.println("Level: " + binaryTreeCharacter.getLevel());
            System.out.println("\n///////Second tree.");
            binaryTreeCharacter2.print();
            System.out.println("Level: " + binaryTreeCharacter2.getLevel());
            
            
            binaryTreeCharacter.insertTree('D', binaryTreeCharacter2);
            
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            System.out.println("---------------------------------");
        }
    }
}