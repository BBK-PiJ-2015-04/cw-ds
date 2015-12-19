public class LinkedList implements List {
	
	private Object obj;
	private LinkedList next;
	
	LinkedList() {
		obj = null;
		next = null;
	}
	
	private static int indx = -1;
	private static LinkedList startList = new LinkedList();
	private static LinkedList lastMan; // Pointer to the last element of the list.
	//                                    To speed up adding at the end of the list.
	
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
			LinkedList current = startList;
			for(int i = 0; i < index; i++) {
				current = current.next;
			}
			ReturnObjectImpl answer = new ReturnObjectImpl(current.obj);
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
			ReturnObjectImpl answer = new ReturnObjectImpl(startList.obj);
			startList = startList.next;
			indx--;
			return answer;
		}
		else {
			LinkedList current = startList;
			for(int i = 0; i < (index - 1); i++) {
				current = current.next;
			}
			ReturnObjectImpl answer = new ReturnObjectImpl(current.next.obj);
			current.next = current.next.next;
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
			LinkedList temp = new LinkedList();
			temp.obj = item;
			temp.next = startList;
			startList = temp;
			indx++;
			ReturnObjectImpl answer = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
			return answer;
		}
		else {
			LinkedList current = startList;
			for(int i = 0; i < (index - 1); i++) {
				current = current.next;
			}
			LinkedList temp = new LinkedList();
			temp.obj = item;
			temp.next = current.next;
			current.next = temp;
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
		else if(startList.obj == null) {
			startList.obj = item;
			indx++;
			ReturnObjectImpl answer = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
			return answer;
		}
		else {
			if(startList.next == null) {
				startList.next = new LinkedList();
				startList.next.obj = item;
				indx++;
				lastMan = startList.next; // New line
				ReturnObjectImpl answer = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
				return answer;
			}
			else {
				lastMan.next = new LinkedList();
				lastMan.next.obj = item;
				lastMan = lastMan.next;
				indx++;
				
				/*LinkedList current = startList;
				while (current.next != null) {
					current = current.next;
				}
				current.next = new LinkedList();
				current.next.obj = item;
				indx++;*/
				ReturnObjectImpl answer = new ReturnObjectImpl(ErrorMessage.NO_ERROR);
				return answer;
			}
		}
	}
	
	// Testing method. REMOVE when done!
	public void PrintList() {
		
		LinkedList current = startList;
		System.out.println();
		System.out.println("The List With " + (indx + 1) + " Elements");
		while(current.next != null) {
			System.out.println(current.obj);
			current = current.next;

		}
		System.out.println(current.obj);
		System.out.println();
	}
	
}
