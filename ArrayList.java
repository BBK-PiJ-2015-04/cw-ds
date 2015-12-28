public class ArrayList implements List {
	
	private Object[] arrList;
	private int index = -1;
	private int arrSize;
	
	public ArrayList() {
		arrList = new Object[arrSize];
		index = -1;
		arrSize = 2;
	}
	
	@Override
	public boolean isEmpty() {
		if(index == -1) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int size() {
		return index + 1;
	}

	@Override
	public ReturnObject get(int index) {
		if(index < 0 || index > this.index) {
			ReturnObject answer = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return answer;
		}
		ReturnObject answer = new ReturnObjectImpl(arrList[index]);
		return answer;
	}

	@Override
	public ReturnObject remove(int index) {
		if(index < 0 || index > this.index) {
			ReturnObject answer = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return answer;
		}
		ReturnObject answer = new ReturnObjectImpl(arrList[index]);
		Object[] temp = new Object[arrSize];
		for(int i = 0; i < index; i++) {
			temp[i] = arrList[i];
		}
		for(int i = index; i < this.index; i++) {
			temp[i] = arrList[i + 1];
		}
		arrList = temp;
		this.index--;
		if((this.index + 1) <= (arrList.length / 3)) { // We shrink the arry when one-third the size.
			HalveIt();
		}
		return answer;
	}

	@Override
	public ReturnObject add(int index, Object item) {
		if(index < 0 || index > this.index) {
			ReturnObject answer = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return answer;
		}
		if(item == null) {
			ReturnObject answer = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
			return answer;
		}
		if((this.index + 2) > arrList.length) {
			DoubleIt();
		}
		this.index++;
		Object[] temp = new Object[arrSize];
		for(int i = 0; i < index; i++) {
			temp[i] = arrList[i];
		}
		temp[index] = item;
		for(int i = (index + 1); i <= this.index; i++) {
			temp[i] = arrList[i - 1]; 
		}
		arrList = temp;
		ReturnObject answer = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		return answer;
	}

	@Override
	public ReturnObject add(Object item) {
		if(item == null) {
			ReturnObject answer = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
			return answer;
		}
		if((index + 2) > arrList.length) {
			DoubleIt();
		}
		index++;
		arrList[index] = item;
		ReturnObject answer = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		return answer;
	}
	
	private void DoubleIt() {
		Object[] temp = new Object[arrSize * 2];
		for(int i = 0; i <= index; i++) {
			temp[i] = arrList[i];
		}
		arrList = temp;
		arrSize = arrSize * 2;
	}
	
	private void HalveIt() {
		Object[] temp = new Object[arrSize / 2];
		for(int i = 0; i <= index; i++) {
			temp[i] = arrList[i];
		}
		arrList = temp;
		arrSize = arrSize / 2;
	}
	
	// DELETE THESE TESTING ONES BELOW!!!
	
	@Override
	public boolean equals(Object obj) {
		ArrayList list = (ArrayList) obj;
		if(index != (list.size() - 1)) {
			return false;
		}
		for(int i = 0; i <= index; i++) {
			if(!arrList[i].equals(list.get(i).getReturnValue())) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		if(index == -1) {
			return null;
		}
		String str = "(";
		for(int i = 0; i <= index; i++) {
			if(i == index) {
				str = str + arrList[i] + ")";
			}
			else {
				str = str + arrList[i] + ", ";
			}
		}
		return str;
	}
	
}
