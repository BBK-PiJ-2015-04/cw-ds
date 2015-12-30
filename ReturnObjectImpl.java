/**
 * An implementation of the interface ReturnObject.
 *
 * @author Birkbeck
 */ 

public class ReturnObjectImpl implements ReturnObject {
	
	private Object item;
	private ErrorMessage errorMessage;
	
	/**
	 * This constructor will take an error message and will set the item to
	 * null.
	 *
	 * @param errorMessage error message to be set
	 */
	
	public ReturnObjectImpl(ErrorMessage errorMessage) {
		this.item = null;
		this.errorMessage = errorMessage;
	}
	
	/**
	 * This constructor will take an object and set the errorMessage to no
	 * error.
	 *
	 * @param item the object to be set
	 */
	
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
