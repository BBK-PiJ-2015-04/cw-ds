public class ReturnObjectImpl implements ReturnObject {
	
	// Under construction
	
	public boolean hasError() {
		return false;
	}

	public ErrorMessage getError() {
		ErrorMessage test = ErrorMessage.NO_ERROR;
		return test;
	}

	public Object getReturnValue() {
		Object test = new Object();
		return test;
	}

}