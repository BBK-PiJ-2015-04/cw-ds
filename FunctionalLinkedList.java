public class FunctionalLinkedList extends LinkedList implements FunctionalList {
    
	@Override
	public ReturnObject head() {
		return get(0);
	}

    @Override
	public FunctionalList rest() {
		FunctionalLinkedList retList = new FunctionalLinkedList();
		int aaa = size();
		for(int i = 0; i < aaa; i++) {
			retList.add(get(i).getReturnValue());		
			System.out.println(get(i).getReturnValue());		
			System.out.println("Hello");
		}
		
		return null;
	}
}
