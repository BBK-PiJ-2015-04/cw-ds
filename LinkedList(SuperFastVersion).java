/**
 * An implementation of the interface List using a linked list as the
 * unerlying data structure.
 *
 * @author Birkbeck
 */ 

public class LinkedList implements List {
	
	private LoneRanger firstRanger; // pointer to the first node
	private LoneRanger lastRanger; // pointer to the last node
	private int index; // internal counter
	private List indexList;
	private boolean indexListCreate = false;
	private int nFactor = 2000;
	
	/**
	 * Creates a list based on a linked list.
	 */
	
	public LinkedList() {
		firstRanger = null;
		lastRanger = null;
		index = -1; // index of -1 means 0 elements in the list (empty)
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
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		return new ReturnObjectImpl(FindRanger(index).getObject());
	}
	
	@Override
	public ReturnObject remove(int index) {
		if(index < 0 || index > this.index) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		if(index == 0) { // is it the first element?
			ReturnObject answer = new ReturnObjectImpl(firstRanger.getObject());
			firstRanger = firstRanger.getNext();
			if(firstRanger != null) {
				firstRanger.setPrevious(null);
			}
			Decrease(0);
			return answer;
		}
		if(index == this.index) { // is it the last element?
			ReturnObject answer = new ReturnObjectImpl(lastRanger.getObject());
			lastRanger = lastRanger.getPrevious();
			lastRanger.setNext(null);
			Decrease(index);
			return answer;
		}
		LoneRanger temp = FindRanger(index);
		LoneRanger tempPrev = temp.getPrevious();
		LoneRanger tempNext = temp.getNext();
		tempPrev.setNext(tempNext);
		tempNext.setPrevious(tempPrev);
		Decrease(index);
		return new ReturnObjectImpl(temp.getObject());
	}

	@Override
	public ReturnObject add(int index, Object item) {
		if(item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		if(index < 0 || index > this.index) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		if(index == 0) { // is it at the start of the list?
			LoneRanger temp = new LoneRanger(item);
			temp.setNext(firstRanger);
			firstRanger.setPrevious(temp);
			firstRanger = temp;
			Increase(temp, 0);
			return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		}
		LoneRanger tempNew = new LoneRanger(item);
		LoneRanger temp = FindRanger(index);
		tempNew.setNext(temp);
		tempNew.setPrevious(temp.getPrevious());
		temp.getPrevious().setNext(tempNew);
		temp.setPrevious(tempNew);
		Increase(temp, index);
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
	}

	@Override
	public ReturnObject add(Object item) {
		if(item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		if(firstRanger == null) { // is the list empty?
			firstRanger = new LoneRanger(item);
			lastRanger = firstRanger;
			index++;
			return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		}
		if(firstRanger.getNext() == null) { // does the list have only one element?
			LoneRanger temp = new LoneRanger(item);
			firstRanger.setNext(temp);
			lastRanger = temp;
			lastRanger.setPrevious(firstRanger);
			index++;
			return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		}
		LoneRanger temp = new LoneRanger(item);
		lastRanger.setNext(temp);
		temp.setPrevious(lastRanger);
		lastRanger = temp;
		Increase(lastRanger);
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
	}
	
	private void Increase(LoneRanger newOne) {
		if((index + 1) % nFactor == 0 && index != -1) {
			if(indexListCreate == false) {
				indexList = new LinkedList();
				indexListCreate = true;
			}
			LoneRanger indexRanger = new LoneRanger(null);
			indexRanger = newOne;
			indexList.add(indexRanger);
			indexRanger = (LoneRanger) indexList.get(indexList.size() - 1).getReturnValue();
		}
		index++;
	}
	
	private void Increase(LoneRanger newOne, int location) {
		for(int i = (location - 1) / nFactor; i < index / nFactor; i++) {
			LoneRanger temp = new LoneRanger(null);
			temp = (LoneRanger) indexList.get(i).getReturnValue();
			temp = temp.getPrevious();
			int indexListSize = indexList.size();
			indexList.remove(i);
			if(i == indexListSize - 1) { // last element? add to end then
				indexList.add(temp);
			}
			else {
				indexList.add(i, temp);
			}
		}
		index++;
		if((index) % nFactor == 0) {
			if(indexListCreate == false) {
				indexList = new LinkedList();
				indexListCreate = true;
			}
			indexList.add(lastRanger);
		}
	}
	
	private void Decrease(int location) {
		for(int i = (location - 1) / nFactor; i < index / nFactor; i++) {
			LoneRanger temp = new LoneRanger(null);
			temp = (LoneRanger) indexList.get(i).getReturnValue();
			temp = temp.getNext();
			int indexListSize = indexList.size();
			indexList.remove(i);
			if(i == indexListSize - 1) { // last element? add to end then
				indexList.add(temp);
			}
			else {
				indexList.add(i, temp);
			}
		}
		index--;
	}
	
	private LoneRanger FindRanger(int index) {
		LoneRanger temp = firstRanger;
		if(index >= nFactor) {
			temp = (LoneRanger) indexList.get((index / nFactor) - 1).getReturnValue();
		}
		for(int i = 0; i < index % nFactor; i++) {
			temp = temp.getNext();
		}
		return temp;
	}
	
}
