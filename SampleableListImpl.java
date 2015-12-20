public class SampleableListImpl extends FunctionalLinkedList implements SampleableList {
	
	@Override
	public SampleableList sample() {
		SampleableList retList = new SampleableListImpl();
		for(int i = 0; i < size(); i = i + 2) {
			retList.add(get(i).getReturnValue());		
		}
		return retList;
	}
}
