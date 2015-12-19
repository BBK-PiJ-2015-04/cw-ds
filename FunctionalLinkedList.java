public class FunctionalLinkedList extends LinkedList implements FunctionalList {
    
	@Override
	public ReturnObject head() {
		return get(0);
	}

    @Override
	public FunctionalLinkedList rest() {
		FunctionalList retList = new LinkedList();
		for(int i = 1; i < size(); i++) {
			retList.add(get(i).getReturnValue());		
		}
		return retList;
	}
}
