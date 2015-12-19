public class SampleableListImpl extends FunctionalLinkedList implements SampleableList {
	
	@Override
	public SampleableListImpl sample() {
		SampleableListImpl retList = new SampleableListImpl();
		for(int i = 0; i < size(); i = i + 2) {
			retList.add(get(i).getReturnValue());		
		}
		return retList;
	}
}
