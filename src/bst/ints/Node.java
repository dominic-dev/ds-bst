package bst.ints;


public class Node implements Comparable<Node>{

    private int element;
    private Node left = null;
    private Node right = null;

    public Node(){
    
    }

    public Node(int element){
        this.element = element;
    }

    /**
     * @return the element
     */
    public int getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(int element) {
        this.element = element;
    }

    /**
     * @return the left
     */
    public Node getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public Node getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * Return true if left is set.
     * @return true if and only if left is not null;
     **/
    public boolean hasLeft(){
        return left != null;
    }

    /**
     * Return true if right is set.
     * @return true if and only if right is not null;
     **/
    public boolean hasRight(){
        return right != null;
    }

	@Override
	public int compareTo(Node o) {
        return element - o.getElement();
	}

    @Override
    public boolean equals(Object o){
        return (Integer) o == (Integer) element;
    }

    /**
     * Add a child node to node.
     * @param newNode the node to add.
     **/
    public boolean add(Node newNode){
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
    public boolean contains(Node target){
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

}
