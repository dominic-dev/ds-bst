package bst.ints;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Pre order iterator for Node.
 *
 * @author dominic
 */

public class PreOrderIterator implements Iterator<Node> {
    private ArrayList<Node> contents;
    private int pointer = 0;

    public PreOrderIterator(Node root){
        contents = new ArrayList<>();
        if(root != null) fill(root);
    }

    private void fill(Node currentNode){
        contents.add(currentNode);
        if(currentNode.hasLeft()) fill(currentNode.getLeft());
        if(currentNode.hasRight()) fill(currentNode.getRight());
    }

	@Override
	public boolean hasNext() {
        return pointer <= contents.size() - 1;
	}

	@Override
	public Node next() {
        return contents.get(pointer++);
	}

}
