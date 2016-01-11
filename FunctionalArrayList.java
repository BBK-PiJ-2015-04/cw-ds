/**
 * An implementation of the interface FunctionalList which extends the class
 * ArrayList.
 *
 * @author Birkbeck
 */ 

public class FunctionalArrayList extends ArrayList implements FunctionalList {

	// No need for a constructor as the default constructor () is inherited
	
	@Override
	public ReturnObject head() {
		return get(0);
	}

	@Override
	public FunctionalList rest() {
		FunctionalList retList = new FunctionalArrayList();
		for(int i = 1; i < size(); i++) { // start from 1 instead of 0 to skip the head
			retList.add(get(i).getReturnValue());		
		}
		return retList;
	}
	
}
