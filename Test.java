public class Test {
	
	public static void main(String[] args) {
		
		LinkedList john = new LinkedList();
		
		Object peter = new Object();
		Object david = new Object();
		
		ErrorMessage hell;
		hell = ErrorMessage.NO_ERROR;
		
		
		
		
		
		System.out.println(john.isEmpty());
		System.out.println(john.size());
		
		john.add("peter");
		john.add("david");
		john.add("Mike3");
		john.add("Mike4");
		john.add("AApeter");
		john.add("BBdavid");
		john.add("CCMike3");
		john.add("DDMike4");
		
		john.PrintList();
		
		System.out.println(john.isEmpty());
		System.out.println(john.size());
		
		john.get(7);
		john.remove(1);
		john.PrintList();
		
		john.add("HKHJHH");
		john.add("sdhfhdfs");
		john.PrintList();
		john.add(0, "NEW BOY");
		john.PrintList();
		
		Double a = 3.14;
		
		System.out.println(a.toString());
	}
	
	
}