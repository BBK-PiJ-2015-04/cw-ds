/**
 * An implementation of the interface List using arrays as the unerlying data
 * structures.
 *
 * @author Birkbeck
 */ 

public class ArrayList implements List {
	
	private Object[] arrList;
	private int index; // internal counter
	private int arrSize;
	
	/**
	 * Creates a list based on a array list.
	 */	
	
	public ArrayList() {
		arrList = new Object[arrSize];
		index = -1; // index of -1 means 0 elements in the list (empty)
		arrSize = 2; // we start the array with a size of 2 and then keep doubling
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
		return index + 1; // since the first element is at index 0, size is 1 more
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
		if((this.index + 1) <= (arrList.length / 3)) { // We shrink the array when one-third the size
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
		if((this.index + 2) > arrList.length) { // If the array is full we double it
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
		if((index + 2) > arrList.length) { // Check if array is full and if so double it
			DoubleIt();
		}
		index++;
		arrList[index] = item;
		ReturnObject answer = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		return answer;
	}
	
	private void DoubleIt() { // Here is where we double the array in size
		Object[] temp = new Object[arrSize * 2];
		for(int i = 0; i <= index; i++) {
			temp[i] = arrList[i];
		}
		arrList = temp;
		arrSize = arrSize * 2; // New array size is double
	}
	
	private void HalveIt() { // Here is where we halve the array in size
		Object[] temp = new Object[arrSize / 2];
		for(int i = 0; i <= index; i++) {
			temp[i] = arrList[i];
		}
		arrList = temp;
		arrSize = arrSize / 2; // New array size is half
	}
	
}
