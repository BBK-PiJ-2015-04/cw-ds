public class LinkedList implements List {
	
	private LoneRanger firstRanger;
	private LoneRanger lastRanger;
	private int indx;
	
	LinkedList() {
		firstRanger = null;
		lastRanger = null;
		indx = -1;
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
			LoneRanger current = firstRanger;
			for(int i = 0; i < index; i++) {
				current = current.getNext();
			}
			ReturnObjectImpl answer = new ReturnObjectImpl(current.getObject());
			return answer;
		}	
	}

	@Override
	public ReturnObject remove(int index) {
		if(index < 0 || index > indx) {
			ReturnObjectImpl answer = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return answer;
		}
		else if(index == 0) {
			ReturnObjectImpl answer = new ReturnObjectImpl(firstRanger.getObject());
			firstRanger = firstRanger.getNext();
			indx--;
			return answer;
		}
		else {
			LoneRanger current = firstRanger;
			for(int i = 0; i < (index - 1); i++) {
				current = current.getNext();
			}
			ReturnObjectImpl answer = new ReturnObjectImpl(current.getObject());
			current.setNext(current.getNext().getNext());
			indx--;
			return answer;
		}
	}

	@Override
	public ReturnObject add(int index, Object item) {
		if(item == null) {
			ReturnObjectImpl answer = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
			return answer;
		}
		else if(index < 0 || index > indx) {
			ReturnObjectImpl answer = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return answer;
		}
		else if(index == 0) {
			LoneRanger temp = new LoneRanger(item);
			temp.setNext(firstRanger);
			firstRanger = temp;
			indx++;
			ReturnObjectImpl answer = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
			return answer;
		}
		else {
			LoneRanger current = firstRanger;
			for(int i = 0; i < (index - 1); i++) {
				current = current.getNext();
			}
			LoneRanger temp = new LoneRanger(item);
			temp.setNext(current.getNext());
			current.setNext(temp);
			indx++;
			ReturnObjectImpl answer = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
			return answer;
		}
	}

	@Override
	public ReturnObject add(Object item) {
		if(item == null) {
			ReturnObjectImpl answer = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
			return answer;
		}
		else if(firstRanger == null) {
			firstRanger = new LoneRanger(item);
			indx++;
			ReturnObjectImpl answer = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
			return answer;
		}
		else {
			if(firstRanger.getNext() == null) {
				LoneRanger temp = new LoneRanger(item);
				firstRanger.setNext(temp);
				lastRanger = temp;
				indx++;
				ReturnObjectImpl answer = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
				return answer;
			}
			else {
				LoneRanger temp = new LoneRanger(item);
				lastRanger.setNext(temp);
				lastRanger = lastRanger.getNext();
				indx++;
				ReturnObjectImpl answer = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
				return answer;
			}
		}			
	}
	
	// DELETE THESE TESTING ONES BELOW!!!
	
	//@Override
	public boolean equals(LinkedList list) {
		if(indx != (list.size() - 1)) {
			return false;
		}
		LoneRanger current = firstRanger;
		for(int i = 0; i <= indx; i++) {
			if(!current.getObject().equals(list.get(i).getReturnValue())) {
				return false;
			}
			current = current.getNext();
		}
		return true;
	}
	
	//@Override
	public String toString() {
		if(indx == -1) {
			return null;
		}
		String str = "(";
		LoneRanger current = firstRanger;
		for(int i = 0; i <= indx; i++) {
			if(i == indx) {
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
