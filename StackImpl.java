public class StackImpl extends AbstractStack  {

    //protected List internalList;

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
		internalList.add(item);
	}

	@Override
	public ReturnObject top() {
		return null;
	}
	
	@Override
	public ReturnObject pop() {
		return null;
	}

}
