package Entity;

public class Book {
    private  long bookID;
    private int bookPrice;
    private int bookPages;
    private String bookName,bookAuthor,bookCaterogies,bookPublisher;

    public Book() {
    }

    public Book(long bookID) {
        this.bookID = bookID;
    }

    public Book(long bookID, String bookName, String bookAuthor, String bookCaterogies, String bookPublisher, int bookPrice, int bookPages) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookCaterogies = bookCaterogies;
        this.bookPublisher = bookPublisher;
        this.bookPrice = bookPrice;
        this.bookPages = bookPages;
    }

    public final long getBookID() {
        return bookID;
    }

    public final void setBookID(long bookID) {
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

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookCaterogies() {
        return bookCaterogies;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookCaterogies(String bookCaterogies) {
        this.bookCaterogies = bookCaterogies;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", bookPrice=" + bookPrice +
                ", bookPages=" + bookPages +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookCaterogies='" + bookCaterogies + '\'' +
                ", bookPublisher='" + bookPublisher + '\'' +
                '}';
    }

}
