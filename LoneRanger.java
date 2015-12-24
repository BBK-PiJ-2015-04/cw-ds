public class LoneRanger {
	
	private Object obj;
	private LoneRanger next;
	
	public LoneRanger(Object obj) {
		this.obj = obj;
		next = null;
	}
	
	public void setObject(Object obj) {
		this.obj = obj;
	}
	
	public void setNext(LoneRanger next) {
		this.next = next;
	}
	
	public Object getObject() {
		return obj;
	}
	
	public LoneRanger getNext() {
		return next;
	}
	
}
