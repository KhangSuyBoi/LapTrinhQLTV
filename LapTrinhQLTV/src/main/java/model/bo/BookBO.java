package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Book;
import model.dao.BookDAO;

public class BookBO {
	BookDAO bookDAO = new BookDAO();
	public Book findBook(String idBook) throws SQLException, ClassNotFoundException{
		return bookDAO.findBook(idBook);
	}
	public int insertBook(Book book) throws SQLException, ClassNotFoundException{
		int rs = 0;
		rs = bookDAO.insertBook(book);
		return rs;
	}
	public ArrayList<Book> getAllBook() throws SQLException, ClassNotFoundException{
		return bookDAO.getAllBook();
	}
	public ArrayList<Book> getSearchBook(String nameBookSearch) throws SQLException, ClassNotFoundException{
		return bookDAO.getSearchBook(nameBookSearch);
	}
	public int updateBook(Book book) throws SQLException, ClassNotFoundException{
		return bookDAO.updateBook(book);
	}
	public int deleteAllBook() throws SQLException, ClassNotFoundException{
		return bookDAO.deleteAllBook();	
	}
	public int deleteBook (String idBook) throws SQLException, ClassNotFoundException{
		return bookDAO.deleteBook(idBook);
		
	}
	public int deleteBookCategory(Integer idCategory) throws SQLException, ClassNotFoundException{
		return bookDAO.deleteBookCategory(idCategory);
	}
	public int deleteBookAuthors(int idAuthors) throws SQLException, ClassNotFoundException{
		return bookDAO.deleteBookAuthors(idAuthors);		 
	}
	public int deleteBook_BookShelf(String idBookShelf) throws SQLException, ClassNotFoundException{
		return bookDAO.deleteBook_BookShelf(idBookShelf);		
	}
	
}
