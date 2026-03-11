package edu.eci.dosw.tdd.library;

import edu.eci.dosw.tdd.library.book.Book;
import edu.eci.dosw.tdd.library.loan.Loan;
import edu.eci.dosw.tdd.library.loan.LoanStatus;
import edu.eci.dosw.tdd.library.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    public void shouldAddABook(){

        Library library = new Library();
        Book book = new Book("Cien años de soledad","Gabriel García Márquez","111");

        boolean result = library.addBook(book);

        assertTrue(result);
    }

    @Test
    public void shouldLoanABook(){

        Library library = new Library();
        Book book = new Book("Cien años de soledad","Gabriel García Márquez","111");

        library.addBook(book);

        User user = new User();
        user.setId("1");

        library.addUser(user);

        Loan loan = library.loanABook("1","111");

        assertNotNull(loan);
    }

    @Test
    public void shouldReturnLoan(){

        Library library = new Library();
        Book book = new Book("Cien años de soledad","Gabriel García Márquez","111");

        library.addBook(book);

        User user = new User();
        user.setId("1");

        library.addUser(user);

        Loan loan = library.loanABook("1","111");

        Loan returned = library.returnLoan(loan);

        assertNotNull(returned);
    }


}