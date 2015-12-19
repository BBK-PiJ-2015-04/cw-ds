public class LoneRanger {
	
	private Object obj;
	private LoneRanger previous;
	private LoneRanger next;
	
	public LoneRanger(Object obj) {
		this.obj = obj;
		previous = null;
		next = null;
	}
	
	public void setObject(Object obj) {
		this.obj = null;
	}
	
	public void setPrevious(LoneRanger previous) {
		this.previous = previous;
	}
	
	public void setNext(LoneRanger next) {
		this.next = next;
	}
	
	public Object getObject() {
		return obj;
	}
	
	public LoneRanger getPrevious() {
		return previous;
	}
	
	public LoneRanger getNext() {
		return next;
	}
	
}