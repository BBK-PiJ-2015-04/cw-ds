import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		ArrayList list1 = new ArrayList();
		
		ImprovedStackImpl stack1 = new ImprovedStackImpl(list1);
		System.out.println(stack1.pop().getReturnValue());
		System.out.println(stack1.size());
		System.out.println(stack1.isEmpty());
		
		stack1.push("a");
		stack1.push("b");
		stack1.push("c");
		stack1.push("d");
		stack1.push("a");
		stack1.push("a");
		stack1.push("e");
		stack1.push("f");
		stack1.push("b");
		stack1.push("a");
		
		System.out.println(stack1.size());
		System.out.println(stack1.isEmpty());
		System.out.println();
		stack1.prettyPrint();
		System.out.println(stack1.pop().getReturnValue());
		System.out.println();
		stack1.prettyPrint();
		stack1.push("new");
		stack1.remove("a");
		System.out.println();
		stack1.prettyPrint();
		
		
		
		
	}

}