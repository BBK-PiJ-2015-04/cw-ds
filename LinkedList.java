public class LinkedList implements List {
	
	private LoneRanger firstRanger;
	private LoneRanger lastRanger;
	private int counter;
	
	public LinkedList() {
		firstRanger = null;
		lastRanger = null;
		counter = -1;
	}
	
	@Override
	public boolean isEmpty() {
		if(counter == -1) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int size() {
		return counter + 1;
	}

	@Override
	public ReturnObject get(int index) {
		if(index < 0 || index > counter) {
			ReturnObject answer = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return answer;
		}
		if(((double) index / counter) < 0.5) {
			LoneRanger current = firstRanger;
				for(int i = 0; i < index; i++) {
				current = current.getNext();
			}
			ReturnObject answer = new ReturnObjectImpl(current.getObject());
			return answer;
		}
		else {
			LoneRanger current = lastRanger;
				for(int i = 0; i < (counter - index); i++) {
				current = current.getPrevious();
			}
			ReturnObject answer = new ReturnObjectImpl(current.getObject());
			return answer;
		}
	}

	@Override
	public ReturnObject remove(int index) {
		if(index < 0 || index > counter) {
			ReturnObject answer = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return answer;
		}
		if(index == 0) {
			ReturnObject answer = new ReturnObjectImpl(firstRanger.getObject());
			firstRanger = firstRanger.getNext();
			if(firstRanger != null) {
				firstRanger.setPrevious(null);
			}
			counter--;
			return answer;
		}
		if(index == counter) {
			ReturnObject answer = new ReturnObjectImpl(lastRanger.getObject());
			lastRanger = lastRanger.getPrevious();
			lastRanger.setNext(null);
			counter--;
			return answer;
		}
		if(((double) index / counter) < 0.5) {
			LoneRanger current = firstRanger;
				for(int i = 0; i < (index - 1); i++) {
				current = current.getNext();
			}
			ReturnObject answer = new ReturnObjectImpl(current.getNext().getObject());
			current.setNext(current.getNext().getNext());
			current.getNext().setPrevious(current);
			counter--;
			return answer;
			}
		else {
			LoneRanger current = lastRanger;
				for(int i = 0; i < (counter - index - 1); i++) {
				current = current.getPrevious();
			}
			ReturnObject answer = new ReturnObjectImpl(current.getPrevious().getObject());
			current.setPrevious(current.getPrevious().getPrevious());
			current.getPrevious().setNext(current);
			counter--;
			return answer;
		}
	}

	@Override
	public ReturnObject add(int index, Object item) {
		if(item == null) {
			ReturnObject answer = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
			return answer;
		}
		if(index < 0 || index > counter) {
			ReturnObject answer = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return answer;
		}
		if(index == 0) {
			LoneRanger temp = new LoneRanger(item);
			temp.setNext(firstRanger);
			firstRanger.setPrevious(temp);
			firstRanger = temp;
			counter++;
			ReturnObject answer = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
			return answer;
		}
		LoneRanger current = firstRanger;
		for(int i = 0; i < (index - 1); i++) {
			current = current.getNext();
		}
		LoneRanger temp = new LoneRanger(item);
		temp.setNext(current.getNext());
		current.getNext().setPrevious(temp);
		current.setNext(temp);
		temp.setPrevious(current);
		counter++;
		ReturnObject answer = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		return answer;
	}

	@Override
	public ReturnObject add(Object item) {
		if(item == null) {
			ReturnObject answer = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
			return answer;
		}
		if(firstRanger == null) {
			firstRanger = new LoneRanger(item);
			lastRanger = firstRanger;
			counter++;
			ReturnObject answer = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
			return answer;
		}
		if(firstRanger.getNext() == null) {
			LoneRanger temp = new LoneRanger(item);
			firstRanger.setNext(temp);
			lastRanger = temp;
			lastRanger.setPrevious(firstRanger);
			counter++;
			ReturnObject answer = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
			return answer;
		}
		LoneRanger temp = new LoneRanger(item);
		lastRanger.setNext(temp);
		temp.setPrevious(lastRanger);
		lastRanger = temp;
		counter++;
		ReturnObject answer = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		return answer;	
	}
	
	// DELETE THESE TESTING ONES BELOW!!!
	
	@Override
	public boolean equals(Object obj) {
		LinkedList list = (LinkedList) obj;
		if(counter != (list.size() - 1)) {
			return false;
		}
		LoneRanger current = firstRanger;
		for(int i = 0; i <= counter; i++) {
			if(!current.getObject().equals(list.get(i).getReturnValue())) {
				return false;
			}
			current = current.getNext();
		}
		return true;
	}
	
	@Override
	public String toString() {
		if(counter == -1) {
			return null;
		}
		String str = "(";
		LoneRanger current = firstRanger;
		for(int i = 0; i <= counter; i++) {
			if(i == counter) {
				str = str + current.getObject() + ")";
			}
			else {
				str = str + current.getObject() + ", ";
				current = current.getNext();
			}
		}
		return str;
	}
	
}
