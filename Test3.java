import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		LinkedList list1 = new LinkedList();
		
		StackImpl stack1 = new StackImpl(list1);
		System.out.println(stack1.pop().getReturnValue());
		System.out.println(stack1.size());
		System.out.println(stack1.isEmpty());
		
		stack1.push("a");
		stack1.push("b");
		stack1.push("c");
		stack1.push("d");
		
		System.out.println(stack1.size());
		System.out.println(stack1.isEmpty());
		stack1.prettyPrint();
		System.out.println(stack1.pop().getReturnValue());
		stack1.prettyPrint();
		System.out.println("\n" + stack1.pop().getReturnValue());
		stack1.prettyPrint();
		
		
		
	}

}