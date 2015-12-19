public class FunctionalLinkedList extends LinkedList implements FunctionalList {
    
	@Override
	public ReturnObject head() {
		return get(0);
	}

    @Override
	public FunctionalLinkedList rest() {
		FunctionalLinkedList retList = new FunctionalLinkedList();
		int aaa = size();
		System.out.println(aaa);
		for(int i = 1; i < aaa; i++) {
			retList.add(get(i).getReturnValue());		
			System.out.println(get(i).getReturnValue());		
			System.out.println("Hello");
		}
		
		return retList;
	}
}
