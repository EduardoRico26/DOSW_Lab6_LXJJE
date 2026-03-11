package edu.eci.dosw.tdd.library;

import edu.eci.dosw.tdd.library.book.Book;
import edu.eci.dosw.tdd.library.loan.Loan;
import edu.eci.dosw.tdd.library.loan.LoanStatus;
import edu.eci.dosw.tdd.library.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    @Test
    public void shouldAddBookAndKeepItInSystem() {
        Library library = new Library();
        Book book = new Book("Pedro Páramo", "Juan Rulfo", "666");
        library.addBook(book);
        // Al prestarlo exitosamente confirma que sí quedó registrado
        User user = new User();
        user.setId("5");
        library.addUser(user);
        Loan loan = library.loanABook("5", "666");
        assertNotNull(loan);
    }

    @Test
    public void shouldLoanBookWithActiveDateSet() {
        Library library = new Library();
        Book book = new Book("Ficciones", "Jorge Luis Borges", "777");
        library.addBook(book);
        User user = new User();
        user.setId("5");
        library.addUser(user);
        Loan loan = library.loanABook("5", "777");
        assertNotNull(loan.getLoanDate());
    }

    @Test
    public void shouldReturnNullWhenLoanNotInSystem() {
        Library library = new Library();
        // Se crea un préstamo manualmente sin pasar por loanABook
        Loan fakeLoan = new Loan();
        Loan result = library.returnLoan(fakeLoan);
        assertNull(result);
    }

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