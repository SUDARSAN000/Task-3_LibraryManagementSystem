package Day_3;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String userID;
	private String name;
	private String mobileNumber;
	private List<Books> issuedBooks;
	
	public User(int id, String name, String mobileNumber) {
		this.userID = "UID"+id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.issuedBooks = new ArrayList<>();
	}

	public String getUserID() { return userID; }
	
	public String getName() { return name; }
	
	public String getMobileNumber() { return mobileNumber; }
	
	public List<Books> getIssuedBooks() { return issuedBooks; }
	
	public void issuedBook(Books book) { issuedBooks.add(book); }
	
	public boolean returnBook(Books book) { return issuedBooks.remove(book); }
	
	
	@Override
	public String toString() {
		return "User [userID=" + userID + ", name=" + name + ", mobileNumber=" + mobileNumber
				+ ", issuedBooks=" + issuedBooks.size() + "]";
	}
	
	
	
}
