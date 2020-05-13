package DAO;

import Entity.Book;

import java.util.ArrayList;
import java.util.List;
public class BookDAO {
    private  List<Book> listBook;
    public BookDAO(){
        List<Book> listBook=new ArrayList<Book>();
    };
    public void addBook(Book book, long bookID, String bookName, String bookAuthor, String bookCaterogies,
            String bookPublisher, int bookPrice, int bookPages) {
        BookDAO b=new BookDAO();
        book.setBookName(bookName);
        book.setBookAuthor(bookAuthor);
        book.setBookCaterogies(bookCaterogies);
        book.setBookPublisher(bookPublisher);
        book.setBookPrice(bookPrice);
        book.setBookPages(bookPages);
        b.listBook.add(book);
    }
    public void edit(Book book){

    }
    public void delele(Book book){
        
    }
    public void showBook(Book book){
        book.getBookName();
        book.getBookAuthor();
    }
}
