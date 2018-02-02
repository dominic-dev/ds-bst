package bst.ints;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author dominic
 *
 */
public class InOrderIterator implements Iterator<Node> {
    private ArrayList<Node> contents;
    private int pointer = 0;

    public InOrderIterator(Node root){
        contents = new ArrayList<>();
        if(root != null) fill(root);
    }

    private void fill(Node currentNode){
        if(currentNode.hasLeft()) fill(currentNode.getLeft());
        contents.add(currentNode);
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
