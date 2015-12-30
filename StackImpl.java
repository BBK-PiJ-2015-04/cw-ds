/**
 * A class that extends AbstractStack.
 *
 * @author Birkbeck
 */ 

public class StackImpl extends AbstractStack  {

	/**
	 * A list must be provided to create the stack. The list can be based on
	 * either a linked list or an array list.
	 *
	 * @param list a list to create the stack
	 */
	
	public StackImpl(List list) {
		super(list);
	}
	
	@Override
	public boolean isEmpty() {
		return internalList.isEmpty();
	}

	@Override
	public int size() {
		return internalList.size();
	}

	@Override
	public void push(Object item) {
		internalList.add(item); // we add it to the end of the list
	}

	@Override
	public ReturnObject top() {
		return internalList.get(internalList.size() - 1); // get the end of the list
	}
	
	@Override
	public ReturnObject pop() {
		return internalList.remove(internalList.size() - 1); // remove the end of the list
	}
	
}
