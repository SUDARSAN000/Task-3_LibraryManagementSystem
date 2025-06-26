package Day_3;

public class Books {
	
	private int bookId;
	private String title;
	private String author;
	private boolean isIssued;
	
	public Books(int id, String title, String author) {
		this.bookId = id;
		this.title = title;
		this.author = author;
		this.isIssued = false;
	}

	public int getBookId() { return bookId; }

	public String getTitle() { return title; }

	public String getAuthor() { return author; }
	
	public boolean isIssued() { return isIssued; }
	
	public void setIssued(boolean isIssued) { this.isIssued = isIssued; }

	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", title=" + title + ", author=" + author +
				       ", isIssued=" + (isIssued ? "(Issued)" : "(Available)")+ "]";
	}
	
	
	
}
