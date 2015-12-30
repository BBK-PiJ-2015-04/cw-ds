/**
 * An implementation of the interface SampleableList. This implementation
 * will work with both LinkedList and ArrayList. Since linked lists are more
 * efficient, that is chosen as the defualt underlying data structure. However,
 * if arrays are prefered, an optional constructor is provided. Consider this
 * a bonus feature if you will.
 *
 * @author Birkbeck
 */ 

public class SampleableListImpl implements SampleableList {
	
	private List internalList;
	
	/**
	 * The default constructor will create a new list based on a linked list.
	 */
	
	public SampleableListImpl() {
		internalList = new LinkedList();
	}
	
	/**
	 * Alternative constructor if arrays are desired instead. You must specify
	 * clearly "Array" or "array" as the string in the parameter, otherwise
	 * the list will be based on a linked list.
	 *
	 * @param str the string must be "Array" or "array" to create an array list
	 * otherwise a linked list will be created
	 */
	
	public SampleableListImpl(String str) {
		if(str.equals("Array") || str.equals("array")) {
			internalList = new ArrayList();
		}
		else {
			internalList = new LinkedList();
		}
	}
	
	@Override
	public SampleableList sample() {
		SampleableList retList;
		// Below we check to see if the list was based on ArrayList or
		// LinkedList and we return a new list of the same type. While we can
		// choose ourselves and we would probably choose LinkedList for
		// efficency, we feel it is better to keep the new list of the same
		// structure as the original list.
		if(internalList instanceof ArrayList) {
			retList = new SampleableListImpl("Array");
		}
		else {
			retList = new SampleableListImpl();
		}
		for(int i = 0; i < size(); i = i + 2) { // we skip every other element
				retList.add(get(i).getReturnValue());
		}
		return retList;
	}
	
	public boolean isEmpty() {
		return internalList.isEmpty();
	}

	public int size() {
		return internalList.size();
	}

	public ReturnObject get(int index) {
		return internalList.get(index);
	}

	public ReturnObject remove(int index) {
		return internalList.remove(index);
	}

	public ReturnObject add(int index, Object item) {
		return internalList.add(index, item);
	}

	public ReturnObject add(Object item) {
		return internalList.add(item);
	}
	
}
