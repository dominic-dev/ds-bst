package bst.generic;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Pre order iterator for Node<E>
 * 
 * @author dominic
 */

public class PreOrderIterator<E extends Comparable<E>> implements Iterator<Node<E>> {
    private ArrayList<Node<E>> contents;
    private int pointer = 0;

    public PreOrderIterator(Node<E> root){
        contents = new ArrayList<>();
        if(root != null) fill(root);
    }

    /**
     * Fill the array list recursively. In order.
     * @param currentNode the currentNode
     **/
    private void fill(Node<E> currentNode){
        contents.add(currentNode);
        if(currentNode.hasLeft()) fill(currentNode.getLeft());
        if(currentNode.hasRight()) fill(currentNode.getRight());
    }

	@Override
	public boolean hasNext() {
        return pointer <= contents.size() - 1;
	}

	@Override
	public Node<E> next() {
        return contents.get(pointer++);
	}

}
