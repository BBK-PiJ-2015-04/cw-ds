public class FunctionalLinkedList extends LinkedList implements FunctionalList {
    
	@Override
	public ReturnObject head() {
		return get(0);
	}

    @Override
	public FunctionalList rest() {
		FunctionalList retList = new FunctionalLinkedList();
		for(int i = 1; i < size(); i++) {
			retList.add(get(i).getReturnValue());		
		}
		return retList;
	}
	
}
