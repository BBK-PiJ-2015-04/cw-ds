public class SampleableListImpl2 implements SampleableList {
	
	private List internalList;
	
	public SampleableListImpl2() {
		internalList = new LinkedList();
    }
	
	public SampleableListImpl2(String str) {
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
		if(internalList instanceof ArrayList) {
			retList = new SampleableListImpl2("Array");
		}
		else {
			retList = new SampleableListImpl2();
		}
		for(int i = 0; i < size(); i = i + 2) {
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
