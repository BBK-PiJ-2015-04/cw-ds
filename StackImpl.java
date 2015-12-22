public class StackImpl extends AbstractStack implements Stack {

    protected List internalList;

    public AbstractStack(List list) {
	  this.internalList = list;
    }
}
