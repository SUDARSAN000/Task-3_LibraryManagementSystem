package Day_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryManagementSystem {
	
	private static final Scanner scanner = new Scanner (System.in);
	private static final Library library = new Library();
	private static int count = 1;
	
	public static void main(String[] args) {
		
		System.out.println("___Welcome to the Library Management System___\n");
		defaultDataSeed();
		
		while(true) {
			try {
				showMenu();
				int choice = getChoice();
				
				switch(choice) {
				
				case 1 -> addBook();
				case 2 -> addUser();
				case 3 -> library.viewAllBooks();
				case 4 -> library.viewAllUser();
				case 5 -> issueBook();
				case 6 -> returnBook();
				case 7 -> searchByBookTitle();
				case 8 -> {System.out.println("Exiting... Thank you ^-^\n");return;}
				default -> System.out.println("Invalid Input ! Please select from 1 to 8\n");
				}
			}
			catch(InputMismatchException e) {
				  System.out.println("Invalid Input! Please try again...\n");
				  scanner.nextLine();
			  }
		}
	}

	private static void defaultDataSeed() {
		// Seed default books
	    library.addBook(new Books(101, "Atomic Habits", "James Clear"));
	    library.addBook(new Books(102, "The Alchemist", "Paulo Coelho"));
	    library.addBook(new Books(103, "Clean Code", "Robert C. Martin"));
	    library.addBook(new Books(104, "The Power of Now", "Eckhart Tolle"));
	    library.addBook(new Books(105, "Deep Work", "Cal Newport"));

	    // Seed default users
	    library.addUser(new User(count++,"Alice","9500009654"));
	    library.addUser(new User(count++,"Bob","6543215678"));
	}

	private static void searchByBookTitle() {
		System.out.print("Enter the book title : ");
		String title = scanner.next();
		library.searchBookByTitle(title);
	}

	private static void returnBook() {
		try {
			System.out.print("Enter UserId : ");
			String userId = scanner.next();
			System.out.print("Enter BookId : ");
			int bookId = scanner.nextInt();
			library.returnBook(userId, bookId);
		}
		catch(InputMismatchException e) {
			  System.out.println("Invalid Input! BookID must be in integer...\n");
			  scanner.nextLine();
		  }	
		
	}

	private static void issueBook() {
		try {
			System.out.print("Enter UserId : ");
			String userId = scanner.next();
			System.out.print("Enter BookId : ");
			int bookId = scanner.nextInt();
			library.issueBook(userId, bookId);
		}
		catch(InputMismatchException e) {
			  System.out.println("Invalid Input! BookID must be in integer...\n");
			  scanner.nextLine();
		  }	
		
	}

	private static  void addUser() {
		System.out.print("Enter Name : ");
		String name = scanner.next();
		System.out.print("Enter MobileNumber : ");
		String mobile = scanner.next();
		String mobileNumber = "";
		if(mobile.matches("[6-9]//d{9}")) {
			mobileNumber = mobile;
		}
		else {
			System.out.println("Invalid Input ! Please enter valid mobilenumber\n");
			return;
		}
	}

	private static void addBook() {
		try {
			System.out.print("Enter BookID : ");
			int id = scanner.nextInt();
			System.out.print("Enter Title : ");
			String title = scanner.next();
			System.out.print("Enter Author : ");
			String author = scanner.next();
			library.addBook(new Books(id, title, author));
		}
		catch(InputMismatchException e) {
			  System.out.println("Invalid Input! BookID must be in integer...\n");
			  scanner.nextLine();
		  }		
	}
	
	private static int getChoice() {
		while(true) {
			try {
				return scanner.nextInt();
			}
			catch(NumberFormatException e ) {
				System.out.println("Please enter a valid input\n");
			}
		}
	}

	private static void showMenu() {
		System.out.println("1. Add Book");
		System.out.println("2. Add User");
		System.out.println("3. View All Book");
		System.out.println("4. View All User");
		System.out.println("5. Issue Book");
		System.out.println("6. Return Book");
		System.out.println("7. Search Book By Title");
		System.out.println("8. Exit\n");
		System.out.print("Enter choice : ");
	}

}
