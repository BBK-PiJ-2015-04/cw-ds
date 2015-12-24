import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		SampleableList list1 = new SampleableListImpl2("array");
		ArrayList list2 = new ArrayList();
	
		list1.add("a");
		list1.add("b");
		list1.add("c");
		list2.add("a");
		list2.add("b");
		list2.add("c");
		list1.add("d");
		list2.add("d");
		list1.add("e");
		
		SampleableList listx = list1.sample();
		
		System.out.println("\n" + list1.get(0).getReturnValue());
		System.out.println(list1.get(1).getReturnValue());
		System.out.println(list1.get(2).getReturnValue());
		System.out.println(list1.get(3).getReturnValue() + "\n");
		
		System.out.println("\n" + listx.get(0).getReturnValue());
		System.out.println(listx.get(1).getReturnValue());
		System.out.println(listx.get(2).getReturnValue());
		System.out.println(listx.get(3).getReturnValue() + "\n");
		
		System.out.println(list1.remove(3).getReturnValue() + " removed");
		
		
		System.out.println(list1.size());
		System.out.println(list2.size());
		System.out.println(list1.equals(list2));
		System.out.println(list1);
		
		ArrayList list3 = new ArrayList();
		
		list3.add(list1);
		list3.add(list2);
		
		System.out.println(list3);
		
		list2.add("Another one.");
		System.out.println(list3);
		
		ArrayList temp = new ArrayList();
		temp = (ArrayList) list3.get(1).getReturnValue();
		System.out.println(temp.get(4).getReturnValue());
		
		temp.add("first one");
		System.out.println(temp);
		System.out.println(list2);
		
		
		
		/*Object[] testarr = new Object[5];
		int aaa = 5;
		testarr[0] = aaa;
		String aab = "sdassj";
		testarr[1] = aab;
		testarr[2] = list1;
		testarr[3] = list2;
		LinkedList bbb = (LinkedList) testarr[2];
		System.out.println(bbb.get(0).getReturnValue());
		System.out.println(testarr[2] instanceof List);
		System.out.println(testarr[3]);
		System.out.println(list1 == list2);
		System.out.println(list1.equals(list2));
		System.out.println(testarr[2] == testarr[3]);
		System.out.println(testarr[2].equals(testarr[3]));
		
		LinkedList list4 = new LinkedList();
		//list4 = list3.get(1).getReturnValue();
		//System.out.println(list3.get(1).getReturnValue().get(2).getReturnValue());
	*/
	}

}