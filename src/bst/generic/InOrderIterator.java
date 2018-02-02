package bst.generic;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author dominic
 *
 */
public class InOrderIterator<E extends Comparable<E>> implements Iterator<Node<E>> {
    private ArrayList<Node<E>> contents;
    private int pointer = 0;

    public InOrderIterator(Node<E> root){
        contents = new ArrayList<>();
        if(root != null) fill(root);
    }

    /**
     * Fill the array list recursively. In order.
     * @param currentNode the currentNode
     **/
    private void fill(Node<E> currentNode){
        if(currentNode.hasLeft()) fill(currentNode.getLeft());
        contents.add(currentNode);
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
