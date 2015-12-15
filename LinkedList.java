public class LinkedList implements List {
	
	private static int indx = -1;
	
	private Object obj;
	private LinkedList next;
	
	
	@Override
	public boolean isEmpty() {
		if(indx == -1) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public int size() {
		return indx;
	}

	@Override
	public ReturnObject get(int index) {
		return null;
	}

	@Override
	public ReturnObject remove(int index) {
		return null;
	}

	@Override
	public ReturnObject add(int index, Object item) {
		return null;
	}

	@Override
	public ReturnObject add(Object item) {
		return null;
	}
	
}
