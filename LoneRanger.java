public class LoneRanger {
	
	private Object item;
	private LoneRanger next;
	private LoneRanger previous;
	
	public LoneRanger(Object item) {
		this.item = item;
		next = null;
		previous = null;
	}
	
	public void setObject(Object item) {
		this.item = item;
	}
	
	public void setNext(LoneRanger next) {
		this.next = next;
	}
	
	public void setPrevious(LoneRanger previous) {
		this.previous = previous;
	}
	
	public Object getObject() {
		return item;
	}
	
	public LoneRanger getNext() {
		return next;
	}
	
	public LoneRanger getPrevious() {
		return previous;
	}
	
}
