public class ReturnObjectImpl implements ReturnObject {
	
	// Under construction
	
	@Override
	public boolean hasError() {
		return false;
	}

	@Override
	public ErrorMessage getError() {
		ErrorMessage test = ErrorMessage.NO_ERROR;
		return test;
	}

	@Override
	public Object getReturnValue() {
		Object test = new Object();
		return test;
	}

}