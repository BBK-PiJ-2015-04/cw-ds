public class LinkedList implements List {
	
	private Object obj;
	private LinkedList next;
	
	LinkedList() {
		obj = null;
		next = null;
	}
	
	private static int indx = -1;
	private static LinkedList startList = new LinkedList();
	
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
			return null;
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
			return null;
		}
	}

	@Override
	public ReturnObject add(Object item) {
		if(startList.obj == null) {
			startList.obj = item;
			indx++;
			return null;
		}
		else {
			if(startList.next == null) {
				startList.next = new LinkedList();
				startList.next.obj = item;
				indx++;
				return null;
			}
			else {
				LinkedList current = startList;
				while (current.next != null) {
					current = current.next;
				}
				current.next = new LinkedList();
				current.next.obj = item;
				indx++;
				return null;
			}
		}
	}
	
	public void PrintList() {
		
		LinkedList current = startList;
		while(current.next != null) {
			System.out.println(current.obj);
			current = current.next;

		}
		System.out.println(current.obj);
		System.out.println();
	}
	
}
