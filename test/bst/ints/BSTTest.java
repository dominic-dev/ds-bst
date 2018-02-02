package bst.ints;

import java.util.Iterator;
import org.junit.Test;

import bst.ints.BinarySearchTree;
import bst.ints.Node;

import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author michel.mercera
 */
public class BSTTest {
  
    BinarySearchTree sevenBinarySearchTree;
    
    //will run before every test... so each test has a fresh sevenBinarySearchTree instance
    @Before
    public void init(){
        sevenBinarySearchTree= new BinarySearchTree();
        sevenBinarySearchTree.add(6);
        sevenBinarySearchTree.add(10);
        sevenBinarySearchTree.add(3);
        sevenBinarySearchTree.add(5);
        sevenBinarySearchTree.add(8);
        sevenBinarySearchTree.add(1);
        sevenBinarySearchTree.add(4);
        
    }
  
    /**
     * Test of size method, of class BinarySearchTree.
     */
    @Test
    public void testZeroSize() {
        System.out.println("zero size");
        BinarySearchTree instance = new BinarySearchTree();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of size method, of class BinarySearchTree.
     */
    @Test
    public void testSevenSize() {
        System.out.println("seven size");
        int expResult = 7;
        int result = sevenBinarySearchTree.size();
        assertEquals(expResult, result);
    }


    /**
     * Test of isEmpty method, of class BinarySearchTree.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        BinarySearchTree instance = new BinarySearchTree();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
      
    }
    
    /**
     * Test of isEmpty method, of class BinarySearchTree.
     */
    @Test
    public void testIsNotEmpty() {
        System.out.println("isNotEmpty");
        boolean expResult = false;
        boolean result = sevenBinarySearchTree.isEmpty();
        assertEquals(expResult, result);
      
    }


    /**
     * Test of contains method, of class BinarySearchTree.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Node node = new Node();
        node.setElement(4);
        
        boolean expResult = true;
        boolean result = sevenBinarySearchTree.contains(node);
        assertEquals(expResult, result);
    }

   
      /**
     * Test of contains method, of class BinarySearchTree.
     */
    @Test
    public void testNotContains() {
        System.out.println("Not contains");
        Node node = new Node();
        node.setElement(2);
        
        boolean expResult = false;
        boolean result = sevenBinarySearchTree.contains(node);
        assertEquals(expResult, result);
    }



    /**
     * Test of add method, of class BinarySearchTree.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Node node = new Node();
        node.setElement(2);
        BinarySearchTree instance = new BinarySearchTree();
        boolean expResult = true;
        boolean result = instance.add(node);
        assertEquals(expResult, result);
       
    }

    
     /**
     * Test of add method, of class BinarySearchTree.
     */
    @Test
    public void testNotAdd() {
        System.out.println("not add");
        Node node = new Node();
        node.setElement(2);
        BinarySearchTree instance = new BinarySearchTree();
        boolean expResult = false;
        instance.add(node);
        boolean result= instance.add(node);
        assertEquals(expResult, result);
       
    }
    /**
     * Test of findMax method, of class BinarySearchTree.
     */
    @Test
    public void testFindMax() {
        System.out.println("findMax");
        Node expResult = new Node();
        expResult.setElement(10);
        Node result = sevenBinarySearchTree.findMax();
        assertEquals(expResult.getElement(), result.getElement());
    }

   

  
 
    /**
     * Test of in order iterator method, of class BinarySearchTree.
     */
    //@Test
    //public void testIterator() {
        //System.out.println("inorder iterator");
        //BinarySearchTree instance = new BinarySearchTree();
        //Iterator expResult = null;
        //Iterator result = instance.iterator();
        //assertEquals(expResult, result);
        //fail("TODO make a test case");
    //}

    
    
}
