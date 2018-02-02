/**
 * 
 */
package bst.ints;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author dominic
 *
 */
public class BinarySearchTree implements Collection<Node>{

    private Node root = null;
    private int size = 0;


    public BinarySearchTree() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Iterator<Node> iterator() {
        return new InOrderIterator(root);
    }


    /**
     * Add an integer to the tree.
     * @param i the integer to add.
     * @return true if and only if addition is successful.
     **/
    public boolean add(int i) {
        Node node = new Node(i);
        return add(node);
    }

    @Override
    public boolean add(Node e) {
        size++;
        if(isEmpty()){
            root = e;
            return true;
        }
        return root.add(e);
    }

    /**
     * Find the smallest node.
     * @return the smallest node.
     **/
    public Node findMin(){
        if(isEmpty()) return null;
        return findMin(root);
    }

    /**
     * Recursive helper function.
     * @param currentNode the current node.
     * @return the smallest node.
     **/
    public Node findMin(Node currentNode){
        if(currentNode.getLeft() == null){
            return currentNode;
        }
        return findMin(currentNode.getLeft());
    }


    /**
     * Find the largest node.
     * @return the largest node.
     **/
    public Node findMax(){
        if(isEmpty()) return null;
        return findMax(root);
    }

    /**
     * Recursive helper function.
     * @param currentNode the current node.
     * @return the largest node.
     **/
    public Node findMax(Node currentNode){
        if(currentNode.getRight() == null){
            return currentNode;
        }
        return findMax(currentNode.getRight());
    }

    @Override
    public boolean contains(Object o) {
        if(isEmpty()) return false;
        return root.contains((Node) o);
    }


    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        Iterator<Node> it = new InOrderIterator(root);
        int i = 0;
        while(it.hasNext()){
            result[i++] = it.next();
        }
        return result;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        size--;
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends Node> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public String toString(){
        String result = "";
        Iterator<Node> it = new InOrderIterator(root);
        if(it.hasNext()){
            result += it.next().toString();
        }
        while(it.hasNext()){
            result += ", " + it.next().toString();
        }
        return result;
    }

    public void test(){
        System.out.println("InOrder");
        System.out.println(toString());
        System.out.println("PreOrder");
        Iterator<Node> it = new PreOrderIterator(root);
        if(it.hasNext()){
            System.out.print(it.next().toString());
        }
        while(it.hasNext()){
            System.out.print(", " + it.next().toString());
        }
        System.out.println();

        System.out.println("PostOrder");
        it = new PostOrderIterator(root);
        if(it.hasNext()){
            System.out.print(it.next().toString());
        }
        while(it.hasNext()){
            System.out.print(", " + it.next().toString());
        }
        System.out.println();
    }


    /**
     * Testing.
     **/
    public static void main(String[] args) {
        BinarySearchTree sevenBST= new BinarySearchTree();
        sevenBST.add(6);
        sevenBST.add(10);
        sevenBST.add(3);
        sevenBST.add(5);
        sevenBST.add(8);
        sevenBST.add(1);
        sevenBST.add(4);
        sevenBST.test();
    }

}
