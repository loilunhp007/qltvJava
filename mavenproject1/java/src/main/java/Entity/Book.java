package Entity;
public class Book {
    private int bookID;
    private int bookPrice;
    private int bookPages;
    private int bookAuthorID,bookCategoryID;
    private String bookName,bookPublisher,bookAuthor,bookCategory;

    public Book() {
    }

    public Book(int bookID) {
        this.bookID = bookID;
    }

    public Book(int bookID, String bookName, int bookAuthorID, int bookCategoryID,String bookPublisher,int bookPrice,int bookPages) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookAuthorID = bookAuthorID;
        this.bookCategoryID = bookCategoryID;
        this.bookPublisher = bookPublisher;
        this.bookPrice = bookPrice;
        this.bookPages = bookPages;
    }
    public Book(int bookID, String bookName, String bookAuthor, String bookCategory,String bookPublisher,int bookPrice,int bookPages) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookCategory = bookCategory;
        this.bookPublisher = bookPublisher;
        this.bookPrice = bookPrice;
        this.bookPages = bookPages;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookPages() {
        return bookPages;
    }

    public void setBookPages(int bookPages) {
        this.bookPages = bookPages;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
    public int getBookAuthorID() {
        return bookAuthorID;
    }

    public void setBookAuthorID(int bookAuthorID) {
        this.bookAuthorID = bookAuthorID;
    }

    public int getBookCategoryID() {
        return bookCategoryID;
    }
    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public void setBookCategoryID(int bookCategoryID) {
        this.bookCategoryID = bookCategoryID;
    }


    @Override
    public String toString() {
        return "Book [ bookID=" + bookID + ", bookName=" + bookName + ", bookAuthorID=" + bookAuthorID + ", bookCategoryID=" + bookAuthorID
        + ", bookPages=" + bookPages + ", bookPrice=" + bookPrice + ", bookPublisher=" + bookPublisher + "]";
    }

    

    

}
