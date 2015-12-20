public class ArrayList implements List {
	
	private int arraySize;
	private Object[] arrList;
	private int indx = -1;
	
	public ArrayList() {
		arraySize = 2; // Start with a tiny array of just two objects and then double as needed!
		indx = -1; // no objects = -1, 1 object = 0, etc...
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
		if(index < 0 || index > indx) {
			ReturnObjectImpl answer = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return answer;
		}
		else {
			ReturnObjectImpl answer = new ReturnObjectImpl(arrList[index]);
			return answer;
		}
	}

	@Override
	public ReturnObject remove(int index) {
		if(index < 0 || index > indx) {
			ReturnObjectImpl answer = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return answer;
		}
		else {
			ReturnObjectImpl answer = new ReturnObjectImpl(arrList[index]);
			Object[] temp = new Object[arraySize];
			for(int i = 0; i < index; i++) {
				temp[i] = arrList[i];
			}
			for(int i = index; i <= indx; i++) {
				temp[i] = arrList[i + 1]; 
			}
			arrList = temp;
			indx--;
			if((indx + 1) <= (arrList.length / 3)) { // We shrink the arry when one-third the size.
				HalveIt();
			}
			return answer;
		}
	}

	@Override
	public ReturnObject add(int index, Object item) {
		if(index < 0 || index > indx) {
			ReturnObjectImpl answer = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return answer;
		}
		if(item == null) {
			ReturnObjectImpl answer = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
			return answer;
		}
		if((indx + 2) > arrList.length) {
			DoubleIt();
		}
		indx++;
		Object[] temp = new Object[arraySize];
		for(int i = 0; i < index; i++) {
			temp[i] = arrList[i];
		}
		temp[index] = item;
		for(int i = (index + 1); i <= indx; i++) {
			temp[i] = arrList[i - 1]; 
		}
		arrList = temp;
		ReturnObjectImpl answer = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		return answer;
	}

	@Override
	public ReturnObject add(Object item) {
		if(item == null) {
			ReturnObjectImpl answer = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
			return answer;
		}
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
		Object[] temp = new Object[arraySize * 2];
		for(int i = 0; i <= indx; i++) {
			temp[i] = arrList[i];
		}
		arrList = temp;
		arraySize = arraySize * 2;
		System.out.println("DOUBLE END! Array Length: " + arrList.length + "Size " + arraySize);
	}
	
	private void HalveIt() {
		System.out.println("HALF TIME! Array Length: " + arrList.length + "Size " + arraySize);
		Object[] temp = new Object[arraySize / 2];
		for(int i = 0; i <= indx; i++) {
			temp[i] = arrList[i];
		}
		arrList = temp;
		arraySize = arraySize / 2;
		System.out.println("HALF END! Array Length: " + arrList.length + "Size " + arraySize);
	}

}
