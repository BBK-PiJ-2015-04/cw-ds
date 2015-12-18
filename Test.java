public class Test {
	
	public static void main(String[] args) {
		
		FunctionalLinkedList john = new FunctionalLinkedList();
		
		//ErrorMessage hell;
		//hell = ErrorMessage.NO_ERROR;
		
		System.out.println(john.isEmpty());
		System.out.println(john.size());
		
		System.out.println(john.add(null).getError());
		john.add(0, "First boy");
		john.add(2.718281828);
		john.add("Mike3");
		john.add(null);
		john.add(1, "Mikey");
		
		john.PrintList();
		
		System.out.println(john.isEmpty());
		System.out.println(john.size());
		
		ReturnObject test1 = john.remove(4);
		System.out.println(test1.getError());
		System.out.println(test1.hasError());
		System.out.println(test1.getReturnValue());
		
		john.PrintList();
		System.out.println(john.head().getReturnValue());
		john.rest();
		
		/*john.get(7);
		john.remove(1);
		john.PrintList();
		
		john.add("HKHJHH");
		john.add("sdhfhdfs");
		john.PrintList();
		john.add(0, "NEW BOY");
		john.PrintList();*/
		
	}
	
}