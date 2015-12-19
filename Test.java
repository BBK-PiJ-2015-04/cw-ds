import java.util.Scanner;

public class Test {
	
	private LinkedList[] myLists = new LinkedList[10];
	private int listCounter = 0;
	private int currentList = 0;
	
	public static void main(String[] args) {
		
		Test dummy = new Test();
		
		dummy.Launch();
		
		/*
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
		
		*/
		
		/*john.get(7);
		john.remove(1);
		john.PrintList();
		
		john.add("HKHJHH");
		john.add("sdhfhdfs");
		john.PrintList();
		john.add(0, "NEW BOY");
		john.PrintList();*/
		
	}
	
	private void Launch() {
		
		String userChoice = "0";
		
		while(!userChoice.equals("6")) {
			
			System.out.println("\nCOURSEWORK TWO - CHECKER!\n");
			System.out.println("Choose from the following:\n");
			System.out.println("(1) Create a new list.");
			System.out.println("(2) Add objects to the list.");
			System.out.println("(3) Get objects from the list.");
			System.out.println("(4) Remove objects from the list.");
			System.out.println("(5) Print the list.");
			System.out.println("(6) Exit the program.\n");
			System.out.print("Your choice: ");	
			
			Scanner scanny = new Scanner(System.in);
			userChoice = scanny.nextLine();
			
			if(userChoice.equals("1")) {
				createList();
				System.out.println("ONE");
			}
			
			else if(userChoice.equals("2")) {
				addToList();
				System.out.println("TWO");
			}
		
			else if(userChoice.equals("3")) {
				System.out.println("THREE");
			}
			
			else if(userChoice.equals("4")) {
				System.out.println("FOUR");
			}
			
			else if(userChoice.equals("5")) {
				System.out.println("FIVE");
			}
			
			else {
				if(!userChoice.equals("6")) {
					System.out.println("\n\nINVALID CHOICE!");
				}
				else {
					System.out.println("\n\nHave a nice day!");
				}
			}
		}
	}
	
	private void createList() {
		
		listCounter++;
		myLists[listCounter - 1] = new LinkedList();
		currentList = listCounter - 1;
		System.out.println("New list created." + currentList);
	
	}
	
	private void addToList() {
	
		myLists[currentList].add("John");
		
	}
	
	
}