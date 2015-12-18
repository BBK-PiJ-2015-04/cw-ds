public class ReturnObjectImpl implements ReturnObject {
	
	private Object obj;
	private ErrorMessage errorMessage;
	
	public ReturnObjectImpl(ErrorMessage errorMessage) {
		this.obj = null;
		this.errorMessage = errorMessage;
	}
	
	public ReturnObjectImpl(Object obj) {
		this.obj = obj;
		this.errorMessage = ErrorMessage.NO_ERROR;
	}
	
	@Override
	public boolean hasError() {
		if(errorMessage == ErrorMessage.NO_ERROR) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public ErrorMessage getError() {
		return errorMessage;
	}

	@Override
	public Object getReturnValue() {
		return obj;
	}

}
