/**
 * A class of the node used in the class LinkedList.
 *
 * @author Birkbeck
 */ 

public class LoneRanger {
	
	private Object item;
	private LoneRanger next;
	private LoneRanger previous;
	
	/**
	 * Creates a new node.
	 *
	 * @param item the object to be assigned to the node
	 */
	
	public LoneRanger(Object item) {
		this.item = item;
		next = null;
		previous = null;
	}
	
	/**
	 * Sets the object. Next & previous are untouched.
	 *
	 * @param item the object to be assigned to the node
	 */
	
	public void setObject(Object item) {
		this.item = item;
	}
	
	/**
	 * Sets the next node. Object & previous are untouched.
	 *
	 * @param next the node to be assigned to next
	 */
	
	public void setNext(LoneRanger next) {
		this.next = next;
	}
	
	/**
	 * Sets the previous node. Object & next are untouched.
	 *
	 * @param previous the node to be assigned to previous
	 */
	
	public void setPrevious(LoneRanger previous) {
		this.previous = previous;
	}
	
	/**
	 * Gets the object from the node.
	 *
	 * @return the object from the node
	 */
	
	public Object getObject() {
		return item;
	}
	
	/**
	 * Gets the next node.
	 *
	 * @return the next node
	 */
	
	public LoneRanger getNext() {
		return next;
	}
	
	/**
	 * Gets the previous node.
	 *
	 * @return the previous node
	 */
	
	public LoneRanger getPrevious() {
		return previous;
	}
	
}
