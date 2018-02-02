package bst.generic;


/**
 * Generic node for Binary Search Tree
 * 
 * @author dominic
 **/

public class Node<E extends Comparable<E>> implements Comparable<Node<E>>{

    private E element;
    private Node<E> left = null;
    private Node<E> right = null;

    public Node(){
    
    }

    public Node(E element){
        this.element = element;
    }

    /**
     * @return the element
     */
    public E getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(E element) {
        this.element = element;
    }

    /**
     * @return the left
     */
    public Node<E> getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(Node<E> left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public Node<E> getRight() {
        return right;
    }

    /**
     * Return true if the node has a right child.
     * @return true if and only if the node has a right child.
     **/
    public boolean hasRight(){
        return right != null;
    }

    /**
     * Return true if the node has a left child.
     * @return true if and only if the node has a left child.
     **/
    public boolean hasLeft(){
        return left != null;
    }

    /**
     * @param right the right to set
     */
    public void setRight(Node<E> right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o){
        return (Integer) o == (Integer) element;
    }

    /**
     * Add a child node.
     * @param newNode the node to add.
     * @return true if and only if node is added successfully.
     **/
    public boolean add(Node<E> newNode){
        // newNode < this
        if(newNode.compareTo(this) < 0){
            if(!hasLeft()){
                left = newNode;
                return true;
            }
            return left.add(newNode);
        }
        // newNode > this
        else if(newNode.compareTo(this) > 0){
            if(!hasRight()){
                right = newNode;
                return true;
            }
            return right.add(newNode);
        }
        // equals
        return false;
    }

    /**
     * Return if the target gnode dis found in the children recursively.
     * @param target the target node.
     * @return true if and only if the node is found in the children recursively.
     **/
    public boolean contains(Node<E> target){
        // equals
        if(target.compareTo(this) == 0){
            return true;
        }
        // target > this
        else if(target.compareTo(this) > 0){
            if(!hasRight()){
                return false;
            }
            return right.contains(target);
        
        }
        // target < this 
        else{
            if(!hasLeft()){
                return false;
            }
            return left.contains(target);
        }
    }


    @Override
    public String toString(){
        return String.valueOf(element);
    }

    @Override
    public int compareTo(Node<E> o) {
        return element.compareTo(o.getElement());
    }

}
