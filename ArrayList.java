public class ArrayList implements List {
	
	private int arraySize;
	private Object[] arrList;
	private int indx = -1;
	
	public ArrayList() {
		arraySize = 2;
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
			for(int i = index; i < indx; i++) {
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
		Object[] temp = new Object[arraySize * 2];
		for(int i = 0; i <= indx; i++) {
			temp[i] = arrList[i];
		}
		arrList = temp;
		arraySize = arraySize * 2;
	}
	
	private void HalveIt() {
		Object[] temp = new Object[arraySize / 2];
		for(int i = 0; i <= indx; i++) {
			temp[i] = arrList[i];
		}
		arrList = temp;
		arraySize = arraySize / 2;
	}
	
	// DELETE THESE TESTING ONES BELOW!!!
	
	@Override
	public boolean equals(Object obj) {
		ArrayList list = (ArrayList) obj;
		if(indx != (list.size() - 1)) {
			return false;
		}
		for(int i = 0; i <= indx; i++) {
			if(!arrList[i].equals(list.get(i).getReturnValue())) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		if(indx == -1) {
			return null;
		}
		String str = "(";
		for(int i = 0; i <= indx; i++) {
			if(i == indx) {
				str = str + arrList[i] + ")";
			}
			else {
				str = str + arrList[i] + ", ";
			}
		}
		return str;
	}
	
}
