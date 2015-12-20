public class ArrayList implements List {
	
	private int arraySize;
	private Object[] arrList;
	private int indx = -1;
	
	public ArrayList() {
		arraySize = 8;
		indx = -1;
		arrList = new Object[arraySize];
	}
	
	@Override
	public boolean isEmpty() {
		if(indx == -1) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int size() {
		return indx + 1;
	}

	@Override
	public ReturnObject get(int index) {
		return null;
	}

	@Override
	public ReturnObject remove(int index) {
		return null;
	}

	@Override
	public ReturnObject add(int index, Object item) {
		return null;
	}

	@Override
	public ReturnObject add(Object item) {
		if((indx + 2) > arrList.length) {
			DoubleIt();
		}
		indx++;
		arrList[indx] = item;
		ReturnObjectImpl answer = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		return answer;
	}
	
	private void DoubleIt() {
		System.out.println("DOUBLE TIME! Array Length: " + arrList.length + "Size " + arraySize);
		Object[] newArray = new Object[arraySize * 2];
		for(int i = 0; i < indx; i++) {
			newArray[i] = arrList[i];
		}
		arrList = newArray;
		arraySize = arraySize * 2;
		System.out.println("DOUBLE END! Array Length: " + arrList.length + "Size " + arraySize);
		
	}

}
