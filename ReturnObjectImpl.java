public class ReturnObjectImpl implements ReturnObject {
	
	private Object item;
	private ErrorMessage errorMessage;
	
	public ReturnObjectImpl(ErrorMessage errorMessage) {
		this.item = null;
		this.errorMessage = errorMessage;
	}
	
	public ReturnObjectImpl(Object item) {
		this.item = item;
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
		return item;
	}

}
