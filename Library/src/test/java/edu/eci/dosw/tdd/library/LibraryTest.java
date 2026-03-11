package edu.eci.dosw.tdd.library;

import org.junit.jupiter.api.Test;

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

}