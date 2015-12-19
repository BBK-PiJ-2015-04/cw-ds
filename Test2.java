import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		FunctionalLinkedList list1 = new FunctionalLinkedList();
		LinkedList list2 = new LinkedList();
	
		list1.add("one");
		list2.add("a");
		list2.add("b");
		list2.add("c");
		list1.add("two");
		
		System.out.println(list1.size());
		System.out.println(list2.size());
	
	
	}

}