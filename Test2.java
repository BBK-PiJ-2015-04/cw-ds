import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
	
		list1.add("one");
		list2.add("a");
		list2.add("b");
		list2.add("c");
		list1.add("two");
		
		System.out.println(list1.size());
		System.out.println(list2.size());
		
		LinkedList list3 = new LinkedList();
		
		list3.add(list1);
		list3.add(list2);
		
		Object[] testarr = new Object[5];
		int aaa = 5;
		testarr[0] = aaa;
		String aab = "sdassj";
		testarr[1] = aab;
		testarr[2] = list1;
		LinkedList bbb = (LinkedList) testarr[2];
		System.out.println(bbb.get(0).getReturnValue());
		System.out.println(testarr[2] instanceof List);
		
		LinkedList list4 = new LinkedList();
		//list4 = list3.get(1).getReturnValue();
		//System.out.println(list3.get(1).getReturnValue().get(2).getReturnValue());
	
	}

}