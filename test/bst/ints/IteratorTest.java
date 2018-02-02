package bst.ints;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import bst.ints.BinarySearchTree;
import bst.ints.Node;

/**
 *
 * @author michel.mercera
 */
public class IteratorTest {
 
    BinarySearchTree sevenBST;

    @Before
    public void init(){
        sevenBST= new BinarySearchTree();
        sevenBST.add(6);
        sevenBST.add(10);
        sevenBST.add(3);
        sevenBST.add(5);
        sevenBST.add(8);
        sevenBST.add(1);
        sevenBST.add(4);
        
    }
    
    @Test
    public void testHasNext(){
        boolean result= sevenBST.iterator().hasNext();
        boolean expected = true;
        assertEquals(expected, result); 
    }
    
    @Test
    public void testNext(){
        Iterator<Node> it = sevenBST.iterator();
        Integer result= (Integer) it.next().getElement();
        Integer expected = 1;
        assertEquals(expected, result); 
    }
    @Test
    public void testNextNext(){
        Iterator<Node> it = sevenBST.iterator();
        it.next();
        Integer result= (Integer) it.next().getElement();
        Integer expected = 3;
        assertEquals(expected, result); 
    }
    
    @Test
    public void testNextNextNext(){
        Iterator<Node> it = sevenBST.iterator();
        it.next();
        it.next();
        Integer result= (Integer) it.next().getElement();
        Integer expected = 4;
        assertEquals(expected, result); 
    }
    
}
