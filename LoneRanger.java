public class LoneRanger {
	
	private Object obj;
	private LoneRanger next;
	private LoneRanger previous;
	
	public LoneRanger(Object obj) {
		this.obj = obj;
		next = null;
		previous = null;
	}
	
	public void setObject(Object obj) {
		this.obj = obj;
	}
	
	public void setNext(LoneRanger next) {
		this.next = next;
	}
	
	public void setPrevious(LoneRanger previous) {
		this.previous = previous;
	}
	
	public Object getObject() {
		return obj;
	}
	
	public LoneRanger getNext() {
		return next;
	}
	
	public LoneRanger getPrevious() {
		return previous;
	}
	
}
