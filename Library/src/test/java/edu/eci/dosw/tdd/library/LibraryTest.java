package edu.eci.dosw.tdd.library;

import edu.eci.dosw.tdd.library.book.Book;
import edu.eci.dosw.tdd.library.loan.Loan;
import edu.eci.dosw.tdd.library.loan.LoanStatus;
import edu.eci.dosw.tdd.library.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    public void shouldAddDifferentBooks(){

        Library library = new Library();

        Book book1 = new Book("La vorágine","José Eustasio Rivera","333");
        Book book2 = new Book("María","Jorge Isaacs","444");

        library.addBook(book1);
        boolean result = library.addBook(book2);

        assertTrue(result);
    }

    @Test
    public void shouldNotLoanBookWithoutUser(){
        Library library = new Library();
        Book book = new Book("Nivola","JMiguel de Unamuno","487");
        library.addBook(book);
        Loan loan = library.loanABook("10","487");

        assertNull(loan);
        assertEquals(0, library.getLoans().size());
    }

    @Test
    public void shouldIncreaseStockWhenReturned(){
        Library library = new Library();
        Book book = new Book("El poder de sanar", "Doctor Bayter", "456");

        library.addBook(book);

        User user = new User();
        user.setId("5");

        library.addUser(user);

        Loan loan = library.loanABook("5", "456");

        assertNotNull(loan);
        assertEquals(LoanStatus.ACTIVE, loan.getStatus());

        Loan returnedLoan = library.returnLoan(loan);

        assertNotNull(returnedLoan);
        assertEquals(LoanStatus.RETURNED, returnedLoan.getStatus());
        assertNotNull(returnedLoan.getReturnDate());

        Loan newLoan = library.loanABook("5", "456");
        assertNotNull(newLoan);
        assertEquals(LoanStatus.ACTIVE, newLoan.getStatus());
    }

}