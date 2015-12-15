public class LinkedList /*implements List*/ {
	
	private String obj;
	private LinkedList next;
	
	LinkedList() {
		obj = null;
		next = null;
	}
	
	private static int indx = -1;
	private static LinkedList startList = new LinkedList();
	
	
	//@Override
	public boolean isEmpty() {
		if(indx == -1) {
			return true;
		}
		else {
			return false;
		}
	}

	//@Override
	public int size() {
		return indx + 1;
	}

	//@Override
	public ReturnObject get(int index) {
		if(index < 0 || index > indx) {
			System.out.println("ERROR");
		}
		else {
			LinkedList current = startList;
			for(int i = 0; i < index; i++) {
				current = current.next;
			}
		System.out.println(current.obj);
		}
		return null;
	}

	//@Override
	public ReturnObject remove(int index) {
		if(index < 0 || index > indx) {
			System.out.println("ERROR");
		}
		else {
			LinkedList current = startList;
			for(int i = 0; i < (index - 1); i++) {
				current = current.next;
			}
			System.out.println(current.next.obj + " is history!");
			current.next = current.next.next;
			indx--;
		}
		return null;
	}

	//@Override
	public ReturnObject add(int index, String item) {
		if(index < 0 || index > indx) {
			System.out.println("ERROR");
		}
		else {
			LinkedList current = startList;
			for(int i = 0; i < index; i++) {
				current = current.next;
			}
			System.out.println(current.obj + " has a new neighbour in " + item);
			LinkedList temp = new LinkedList();
			temp.obj = item;
			temp.next = current.next;
			current.next = temp;
			indx++;
		}
		return null;
	}

	//@Override
	public ReturnObject add(String item) {
		if(startList.obj == null) {
			startList.obj = item;
			indx++;
			//System.out.println(indx);
		}
		else {
			if(startList.next == null) {
				//System.out.println(startList.obj);
				//System.out.println(item);
				startList.next = new LinkedList();
				startList.next.obj = item;
				//System.out.println(startList.next.obj);
				indx++;
			}
			else {
				LinkedList current = startList;
				while (current.next != null) {
					current = current.next;
				}
				//System.out.println(indx);
				//System.out.println(current.obj);
				current.next = new LinkedList();
				current.next.obj = item;
				indx++;
			}
		}
		return null;
	}
	
	public void PrintList() {
		
		LinkedList current = startList;
		while(current.next != null) {
			System.out.println(current.obj);
			current = current.next;

		}
		System.out.println(current.obj);
		System.out.println(indx);
		
	}
	
}
