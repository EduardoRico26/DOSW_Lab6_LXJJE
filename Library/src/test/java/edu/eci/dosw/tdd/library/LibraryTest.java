package edu.eci.dosw.tdd.library;

import org.junit.jupiter.api.Test;

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
