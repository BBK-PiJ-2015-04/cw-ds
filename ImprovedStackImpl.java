public class ImprovedStackImpl implements ImprovedStack {
	
	private List internalList;
	
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
		internalList.add(item);
	}

	@Override
	public ReturnObject top() {
		return internalList.get(internalList.size() - 1);
	}
	
	@Override
	public ReturnObject pop() {
		return internalList.remove(internalList.size() - 1);
	}

	@Override
	public ImprovedStack reverse() {
		ImprovedStack answer;
		if(internalList instanceof ArrayList) {
			answer = new ImprovedStackImpl(new ArrayList());
		}
		else {
			answer = new ImprovedStackImpl(new LinkedList());
		}
		for(int i = internalList.size() - 1; i >= 0; i--) {
			answer.push(internalList.get(i).getReturnValue());
		}
		return answer;
	}

	@Override
	public void remove(Object object) {
		for(int i = 0; i < internalList.size(); i++) {
			if(internalList.get(i).getReturnValue().equals(object)) {
				internalList.remove(i);
				i--;
			}
		}
	}

	// Testing ones below
	
	public void prettyPrint() {
		for(int i = 0; i < internalList.size(); i++) {
			System.out.println(internalList.get(i).getReturnValue());
		}
	}
	
}
