/**
 * 
 */
package bst.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;


/**
 * @author dominic
 *
 */
public class BinarySearchTree<E extends Comparable<E>> implements Collection<Node<E>>{

    private Node<E> root = null;
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
    public Iterator<Node<E>> iterator() {
        return new InOrderIterator<E>(root);
    }

    /**
     * Add an object of type E to the tree.
     * @param E the object to add.
     **/
    public boolean add(E e){
        Node<E> node = new Node<>(e);
        return add(node);
    }

    @Override
    public boolean add(Node<E> e) {
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
    public Node<E> findMin(){
        if (isEmpty()) return null;
        Node<E> current = root;
        while(current.getLeft() != null){
            current = current.getLeft();
        }
        return current;
    }

    /**
     * Find the largest node.
     * @return the largest node.
     **/
    public Node<E> findMax(){
        if (isEmpty()) return null;
        Node<E> current = root;
        while(current.getRight() != null){
            current = current.getRight();
        }
        return current;
    }

    /*
    // Recursive
    public Node<E> findMin(){
        if(isEmpty()) return null;
        return findMin(root);
    }

    public Node<E> findMin(Node<E> currentNode){
        if(currentNode.getLeft() == null) return currentNode;
        return findMin(currentNode.getLeft());
    }


    public Node<E> findMax(){
        if(isEmpty()) return null;
        return findMax(root);
    }

    public Node<E> findMax(Node<E> currentNode){
        if(currentNode.getRight() == null) return currentNode;
        return findMax(currentNode.getRight());
    }
    */

    @Override
    public boolean contains(Object o) {
        if(isEmpty()) return false;
        return root.contains((Node<E>) o);
    }

    @Override
    public String toString(){
        String result = "";
        Iterator<Node<E>> it = new InOrderIterator<>(root);
        if(it.hasNext()){
            result += it.next().toString();
        }
        while(it.hasNext()){
            result += ", " + it.next().toString();
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println("Integers\n");
        BinarySearchTree<Integer> sevenBST1= new BinarySearchTree<>();
        sevenBST1.add(6);
        sevenBST1.add(10);
        sevenBST1.add(3);
        sevenBST1.add(5);
        sevenBST1.add(8);
        sevenBST1.add(1);
        sevenBST1.add(4);
        sevenBST1.test();
        

        System.out.println("\n===================\n");
        System.out.println("Strings\n");
        BinarySearchTree<String> sevenBST2 = new BinarySearchTree<>();
        sevenBST2.add("b");
        sevenBST2.add("a");
        sevenBST2.add("f");
        sevenBST2.add("h");
        sevenBST2.add("c");
        sevenBST2.add("l");
        sevenBST2.test();

    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        Iterator<Node<E>> it = new InOrderIterator<>(root);
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
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends Node<E>> c) {
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

    /**
     * @return the root
     */
    public Node<E> getRoot() {
        return root;
    }

    public void test(){
        BSTPrinter<E> printer = new BSTPrinter<>();
        printer.printNode(root);
        System.out.println("InOrder");
        System.out.println(toString());
        System.out.println("PreOrder");
        Iterator<Node<E>> it = new PreOrderIterator<>(root);
        if(it.hasNext()){
            System.out.print(it.next().toString());
        }
        while(it.hasNext()){
            System.out.print(", " + it.next().toString());
        }
        System.out.println();

        System.out.println("PostOrder");
        it = new PostOrderIterator<>(root);
        if(it.hasNext()){
            System.out.print(it.next().toString());
        }
        while(it.hasNext()){
            System.out.print(", " + it.next().toString());
        }
        System.out.println();
    }

}
