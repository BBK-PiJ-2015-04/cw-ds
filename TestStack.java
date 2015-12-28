import java.util.Scanner;

public class TestStack {
	
	private ImprovedStack[] myLists = new ImprovedStackImpl[10];
	private int listCounter = 0;
	private int currentList = -1;
	
	public static void main(String[] args) {
		
		TestStack dummy = new TestStack();
		
		dummy.Launch();
	
	}
	
	private void Launch() {
		
		System.out.println("\nCOURSEWORK TWO - CHECKER!\n");
			
		String userChoice = "0";
		
		while(!userChoice.equals("z")) {
			
			System.out.println("CURRENT LIST: " + (currentList + 1) + " OF " + listCounter + " Choose from the following:\n");
			System.out.println("(a) Create a new list.");
			System.out.println("(b) Is the list empty?");
			System.out.println("(c) The size of the list?");
			System.out.println("(d) Add objects to the end of the list.");
			System.out.println("(e) Add loads of random objects to the end of the list.");
			System.out.println("(f) Get objects from the list.");
			System.out.println("(g) Remove objects from the list.");
			System.out.println("(h) Remove loads of objects from the list.");
			System.out.println("(k) Change the current list.");
			System.out.println("(l) Remove OBJECTS!");
			System.out.println("(m) REVERSE!");
			System.out.println("\n(z) Exit the program.\n");
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
				getFromList();
			}
			
			else if(userChoice.equals("g")) {
				removeFromList();
			}
			
			else if(userChoice.equals("h")) {
				removeLoadsFromList();
			}
			
			else if(userChoice.equals("l")) {
				removeBulk();
			}
			
			else if(userChoice.equals("m")) {
				reverseTime();
			}
			
			else if(userChoice.equals("k")) {
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
		
		System.out.print("\nArray or Linked? : ");
		Scanner scanny = new Scanner(System.in);
		String userChoice = scanny.nextLine();
		listCounter++;
		currentList = listCounter - 1;
		if(userChoice.equals("Array")) {
			myLists[listCounter - 1] = new ImprovedStackImpl(new ArrayList());
		}
		else {
			myLists[listCounter - 1] = new ImprovedStackImpl(new LinkedList());
		}
		System.out.println("\nNew list created. It is list number " + listCounter + ".\n");
		
	}
	
	private void reverseTime() {
		
		listCounter++;
		myLists[listCounter - 1] = new ImprovedStackImpl(new ArrayList()); // Makes no difference as overwritten below
		myLists[listCounter - 1] = myLists[currentList].reverse();
		currentList = listCounter - 1;
		System.out.println("\nNew list created. It is list number " + listCounter + ".\n");
		
	}
	
	private void removeBulk() {
		
		System.out.print("\nWhich object to remove? : ");
		Scanner scanny = new Scanner(System.in);
		String userChoice = scanny.nextLine();
		long timey = System.currentTimeMillis();
		myLists[currentList].remove(userChoice);
		timey = System.currentTimeMillis() - timey;
		System.out.println("removed in " + (double) timey / 1000 + " seconds.");
		System.out.println();
	
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
				myLists[currentList].push(null);
			}
			else {
				myLists[currentList].push(userChoice);
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
			myLists[currentList].push(Math.random() * 1000);
		}
		timey = System.currentTimeMillis() - timey;
		System.out.println(qty + " elements added in " + (double) timey / 1000 + " seconds.");
	}
	
	private void getFromList() {
		
		System.out.println("\n" + myLists[currentList].top().getReturnValue() + "\n");
		
	}
	
	private void removeFromList() {
		
		System.out.println("\n" + myLists[currentList].pop().getReturnValue() + "\n");
		
	}
	
	private void removeLoadsFromList() {
		
		System.out.print("\nHow many elements to remove? : ");
		Scanner scanny = new Scanner(System.in);
		String userChoice = scanny.nextLine();
		int qty = Integer.parseInt(userChoice);
		long timey = System.currentTimeMillis();
		for(int i = 0; i < qty; i++) {
			myLists[currentList].pop().getReturnValue();
		}
		timey = System.currentTimeMillis() - timey;
		System.out.println(qty + " elements removed in " + (double) timey / 1000 + " seconds.");
		System.out.println();
		
	}

}
