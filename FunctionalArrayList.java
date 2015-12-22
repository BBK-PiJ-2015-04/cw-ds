public class FunctionalArrayList extends ArrayList implements FunctionalList {
    
	@Override
	public ReturnObject head() {
		return get(0);
	}

    @Override
	public FunctionalList rest() {
		FunctionalList retList = new FunctionalArrayList();
		for(int i = 1; i < size(); i++) {
			retList.add(get(i).getReturnValue());		
		}
		return retList;
	}
	
	public ReturnObject resty() {
		FunctionalList retList = new FunctionalArrayList();
		for(int i = 1; i < size(); i++) {
			retList.add(get(i).getReturnValue());		
		}
		ReturnObjectImpl answer = new ReturnObjectImpl(retList);
		return answer;
	}
}
