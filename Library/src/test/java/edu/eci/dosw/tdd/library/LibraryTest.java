package edu.eci.dosw.tdd.library;

import edu.eci.dosw.tdd.library.book.Book;
import edu.eci.dosw.tdd.library.loan.Loan;
import edu.eci.dosw.tdd.library.loan.LoanStatus;
import edu.eci.dosw.tdd.library.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
	@Test
	public void shouldNotAddNullBook() {
    		Library library = new Library();
    		boolean result = library.addBook(null);
    		assertFalse(result);
	}

	@Test
	public void shouldNotLoanSameBookTwiceToSameUser() {
    		Library library = new Library();
    		Book book = new Book("Rayuela", "Julio Cortázar", "555");
    		library.addBook(book);
    		library.addBook(book); // dos copias disponibles
    		User user = new User();
    		user.setId("4");
    		library.addUser(user);
    		library.loanABook("4", "555");
    		Loan secondLoan = library.loanABook("4", "555");
    		assertNull(secondLoan);
	}

	@Test
	public void shouldSetReturnDateWhenLoanReturned() {
    	Library library = new Library();
    	Book book = new Book("Rayuela", "Julio Cortázar", "555");
    	library.addBook(book);
    	User user = new User();
    	user.setId("4");
    	library.addUser(user);
    	Loan loan = library.loanABook("4", "555");
    	Loan returned = library.returnLoan(loan);
    	assertNotNull(returned.getReturnDate());
	}
}
