public class ArrayList implements List {
	
	private static int arraySize = 8;
	private Object[] arrList = new arrList[arraySize];
	
	
	private static int indx = -1;
	private static ArrayList startList = new ArrayList();
	
	
	
	
	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int size() {
		return 0;
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
		if(startList.obj == null) {
			startList.obj = item;
			indx++;
			//System.out.println(indx);
		}
		else {
			if(startList.next == null) {
				//System.out.println(startList.obj);
				//System.out.println(item);
				startList.next = new ArrayList();
				startList.next.obj = item;
				//System.out.println(startList.next.obj);
				indx++;
			}
			else {
				ArrayList current = startList;
				while (current.next != null) {
					current = current.next;
				}
				//System.out.println(indx);
				//System.out.println(current.obj);
				current.next = new ArrayList();
				current.next.obj = item;
				indx++;
			}
		}
		return null;
	}

}
