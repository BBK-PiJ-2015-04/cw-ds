public class SampleableListImpl implements SampleableList, List {
	
	public SampleableListImpl() {
		super();
	}
	
	/*@Override
	public ReturnObject add(int index) {
		super(index);
	}*/
	
	@Override
	public SampleableList sample() {
		SampleableList retList = new SampleableListImpl();
		for(int i = 0; i < size(); i = i + 2) {
			retList.add(get(i).getReturnValue());		
		}
		return retList;
	}
}
