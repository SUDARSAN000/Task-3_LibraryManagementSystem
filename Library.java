package Day_3;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Books> books = new ArrayList<>();
	private List<User> users = new ArrayList<>();
	
	public void addBook(Books book) {
		books.add(book);
		System.out.println("Book added Sucessfully...\n");
	}
	
	public void addUser(User user) {
		users.add(user);
		System.out.println("User added Sucessfully...\n");
	}
	
	public void viewAllBooks() {
		
		if(books.isEmpty()) {
			System.out.println("No books Available !\n");
			return;
		}
		System.out.println("Books List : ");
		books.forEach(System.out::println);
		System.out.println();
	}
	
	public void viewAllUser() {
		
		if(users.isEmpty()) {
			System.out.println("No user found !\n");
			return;
		}
		System.out.println("Users List : ");
		for(User user : users) {
			System.out.println(user);
			for(Books book : user.getIssuedBooks()) {
				System.out.println("-> "+book);
			}
		}
		System.out.println();
	}
	
	public Books getBookById(int id) {
		for(Books book : books) { if(book.getBookId() == id) return book;}
		return null;
	}
	
	public User getUserById(String id) {
		for(User user : users) { if(user.getUserID().equalsIgnoreCase(id)) return user;}
		return null;
	}
	
	public void issueBook(String userId, int bookId) {
		
		Books book = getBookById(bookId);
		User user = getUserById(userId);
		
		if(book == null || user == null) {
			System.out.println("Invalid Book or UserID !\n");
			return;
		}
		if(book.isIssued()) {
			System.out.println("Sorry ! Book is Isssued to Someone\n");
			return;
		}
		book.setIssued(true);
		user.issuedBook(book);
		System.out.println("Book issued successsfully...\n");
	}
	
	public void returnBook(String userId, int bookId) {
		
		Books book = getBookById(bookId);
		User user = getUserById(userId);
		
		if(book == null || user == null) {
			System.out.println("Invalid Book or UserID !\n");
			return;
		}
		if(user.returnBook(book)) {
			book.setIssued(false);
			System.out.println("User Returned the Book Successfully...\n");
		}
		else {
			System.out.println("This user didn't returned the book !\n");
		}
	}
	
	public void searchBookByTitle(String title) {
		
		boolean found =false;
		
		for(Books book : books) {
			if(book.getTitle().toLowerCase().contains(title.trim().toLowerCase())) {
				System.out.println(book);
				found = true;
			}
		}
		if(!found) {
			System.out.println("No books found with that title !\n");
		}
	}
}
