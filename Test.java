import java.util.Scanner;

public class Test {
	
	private LinkedList[] myLists = new LinkedList[10];
	private int listCounter = 0;
	private int currentList = 0;
	
	public static void main(String[] args) {
		
		Test dummy = new Test();
		
		dummy.Launch();
	
	}
	
	private void Launch() {
		
		System.out.println("\nCOURSEWORK TWO - CHECKER!\n");
			
		String userChoice = "0";
		
		while(!userChoice.equals("z")) {
			
			System.out.println("Choose from the following:\n");
			System.out.println("(a) Create a new list.");
			System.out.println("(b) Is the list empty?");
			System.out.println("(c) The size of the list?");
			System.out.println("(d) Add objects to the end of the list.");
			System.out.println("(e) Add loads of random objects to the end of the list.");
			System.out.println("(f) Add objects to a specific part of the list.");
			System.out.println("(g) Add loads of random objects to a specific part of the list.");
			System.out.println("(h) Get objects from the list.");
			System.out.println("(i) Get loads of objects from the list.");
			System.out.println("(j) Remove objects from the list.");
			System.out.println("(k) Remove loads of objects from the list.");
			System.out.println("(l) Print the list.");
			System.out.println("(m) Change the current list.");
			System.out.println("(z) Exit the program.\n");
			System.out.print("Your choice: ");	
			
			Scanner scanny = new Scanner(System.in);
			userChoice = scanny.nextLine();
			
			if(userChoice.equals("a")) {
				createList();
			}
			
			else if(userChoice.equals("b")) {
				if(listCounter == 0) {
					System.out.println("\nNo list created yet!\n");
				}
				else {
					System.out.println(myLists[currentList].isEmpty()? "\nIt is empty.\n" : "\nIt is NOT empty!\n");
				}
			}
		
			else if(userChoice.equals("c")) {
				if(listCounter == 0) {
					System.out.println("\nNo list created yet!\n");
				}
				else {
					System.out.println("\nThere are " + myLists[currentList].size() + " elements in the list.\n");
				}
			}
		
			else if(userChoice.equals("d")) {
				addToList();
			}
		
			else if(userChoice.equals("e")) {
				addLoadsToList();
			}
			
			else if(userChoice.equals("f")) {
				addToListX();
			}
			
			else if(userChoice.equals("l")) {
				printList();
			}
			
			else if(userChoice.equals("m")) {
				System.out.print("Enter the desired list number: ");
				userChoice = scanny.nextLine();
				currentList = Integer.parseInt(userChoice) - 1;
				System.out.println("\nThe current list is list number " + (currentList + 1) + ".\n");
			}
			
			else {
				if(userChoice.equals("z")) {
					System.out.println("\nHave a nice day!\n");
				}
				else {
					System.out.println("\nINVALID CHOICE!\n");
				}
			}
		}
	}
	
	private void createList() {
		
		listCounter++;
		myLists[listCounter - 1] = new LinkedList();
		currentList = listCounter - 1;
		System.out.println("\nNew list created. It is list number " + listCounter + ".\n");
	
	}
	
	private void addToList() {
	
		String userChoice = "1";
		
		while(true) {
			System.out.print("\nEnter a String ('0' to end, 'null' for null) : ");
			Scanner scanny = new Scanner(System.in);
			userChoice = scanny.nextLine();
			if(userChoice.equals("0")) {
				break;
			}
			if(userChoice.equals("null")) {
				System.out.println("\nStatus: " + myLists[currentList].add(null).getError());
			}
			else {
				System.out.println("\nStatus: " + myLists[currentList].add(userChoice).getError());
			}
		}
	}
	
	private void addLoadsToList() {
		
		System.out.print("\nHow many elements to add? : ");
		Scanner scanny = new Scanner(System.in);
		String userChoice = scanny.nextLine();
		int qty = Integer.parseInt(userChoice);
		long timey = System.currentTimeMillis();
		for(int i = 0; i < qty; i++) {
			myLists[currentList].add(Math.random() * 1000);
		}
		timey = System.currentTimeMillis() - timey;
		System.out.println(qty + " elements added in " + timey + " milliseconds.");
	}
	
	private void addToListX() {
		
		System.out.print("\nEnter the index: ");
		Scanner scanny = new Scanner(System.in);
		String userChoice = scanny.nextLine();
		int indx = Integer.parseInt(userChoice);
		System.out.print("\nEnter a String ('null' for null) : ");
		userChoice = scanny.nextLine();
		if(userChoice.equals("null")) {
			System.out.println("\nStatus: " + myLists[currentList].add(indx, null).getError() + "\n");
		}
		else {
			System.out.println("\nStatus: " + myLists[currentList].add(indx, userChoice).getError() + "\n");
		}
		
	}
	
	private void printList() {
		
		for(int i = 0; i < myLists[currentList].size(); i++) {
			System.out.println(myLists[currentList].get(i).getReturnValue());
		}
		System.out.println();
		
	}
	
}
