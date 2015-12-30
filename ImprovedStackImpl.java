/**
 * An implementation of the interface ImprovedStack.
 *
 * @author Birkbeck
 */ 

public class ImprovedStackImpl implements ImprovedStack {
	
	private List internalList;
	
	/**
	 * A list must be provided to create the stack. The list can be based on
	 * either a linked list or an array list.
	 *
	 * @param list a list to create the stack
	 */
	
	public ImprovedStackImpl(List list) {
		internalList = list;
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

	@Override
	public ImprovedStack reverse() {
		ImprovedStack retList;
		// Again, while we can choose the new list to be based on a linked
		// list, as quality programmers we will let the user decide. If he or she
		// chose a linked list then we will return him or her a linked list and if
		// he or she chose an array list we will provide him or her with
		// exactly that!
		if(internalList instanceof ArrayList) {
			retList = new ImprovedStackImpl(new ArrayList());
		}
		else {
			retList = new ImprovedStackImpl(new LinkedList());
		}
		for(int i = internalList.size() - 1; i >= 0; i--) { // we start from the end and work backwards
			retList.push(internalList.get(i).getReturnValue());
		}
		return retList;
	}

	@Override
	public void remove(Object object) {
		for(int i = 0; i < internalList.size(); i++) {
			if(internalList.get(i).getReturnValue().equals(object)) {
				internalList.remove(i);
				i--; // since the size shrinks with remove, we must adjust for that!
			}
		}
	}

}
