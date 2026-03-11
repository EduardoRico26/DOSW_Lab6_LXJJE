package edu.eci.dosw.tdd.library;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.eci.dosw.tdd.library.book.Book;
import edu.eci.dosw.tdd.library.loan.Loan;
import edu.eci.dosw.tdd.library.loan.LoanStatus;
import edu.eci.dosw.tdd.library.user.User;
import org.junit.jupiter.api.Test;

public class LibraryTest {
	@Test
	public void shouldAddMultipleCopies(){

	    Library library = new Library();
	    Book book = new Book("El amor en los tiempos del cólera","Gabriel García Márquez","222");

	    library.addBook(book);
	    library.addBook(book);

	    boolean result = library.addBook(book);

	    assertTrue(result);
	}

	@Test
	public void shouldNotLoanUnavailableBook(){

	    Library library = new Library();

	    User user = new User();
	    user.setId("2");

	    library.addUser(user);

	    Loan loan = library.loanABook("2","999");

	    assertNotNull(loan);
	}

	@Test
	public void shouldChangeStatusWhenReturned(){

	    Library library = new Library();
	    Book book = new Book("El amor en los tiempos del cólera","Gabriel García Márquez","222");

	    library.addBook(book);

	    User user = new User();
	    user.setId("2");

	    library.addUser(user);

	    Loan loan = library.loanABook("2","222");

	    Loan returned = library.returnLoan(loan);

	assertEquals(LoanStatus.RETURNED, returned.getStatus());
}

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