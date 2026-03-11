package edu.eci.dosw.tdd.library;

import edu.eci.dosw.tdd.library.book.Book;
import edu.eci.dosw.tdd.library.loan.Loan;
import edu.eci.dosw.tdd.library.loan.LoanStatus;
import edu.eci.dosw.tdd.library.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;

/**
 * Library responsible for manage the loans and the users.
 */
public class Library {

    private final List<User> users;
    private final Map<Book, Integer> books;
    private final List<Loan> loans;

    public Library() {
        users = new ArrayList<>();
        books = new HashMap<>();
        loans = new ArrayList<>();
    }

    public boolean addBook(Book book) {
        if (book == null) return false;
    
        if (books.containsKey(book)) {
           books.put(book, books.get(book) + 1);
        } else {
           books.put(book, 1);
        }
        return true;
    }

    public Loan loanABook(String userId, String isbn) {
    
       // 1. Buscar que el usuario exista
       User foundUser = null;
       for (User u : users) {
           if (u.getId().equals(userId)) {
               foundUser = u;
               break;
           }
       }
       if (foundUser == null) return null;

       // 2. Buscar el libro y verificar disponibilidad
       Book foundBook = null;
       for (Book b : books.keySet()) {
           if (b.getIsbn().equals(isbn)) {
               foundBook = b;
               break;
           }
       }
       if (foundBook == null || books.get(foundBook) < 1) return null;

       // 3. Verificar que el usuario no tenga ese libro prestado actualmente
       for (Loan l : loans) {
           if (l.getUser().getId().equals(userId) &&
               l.getBook().getIsbn().equals(isbn) &&
               l.getStatus() == LoanStatus.ACTIVE) {
               return null;
           }
       }
        
       // 4. Crear el préstamo
       books.put(foundBook, books.get(foundBook) - 1);

       Loan loan = new Loan();
       loan.setBook(foundBook);
       loan.setUser(foundUser);
       loan.setLoanDate(LocalDateTime.now());
       loan.setStatus(LoanStatus.ACTIVE);
       loans.add(loan);

       return loan;
   }

    public Loan returnLoan(Loan loan) {

       // 1. Verificar que el préstamo exista en el sistema
       if (!loans.contains(loan)) return null;

       // 2. Aumentar el stock del libro
       books.put(loan.getBook(), books.get(loan.getBook()) + 1);

       // 3. Actualizar estado y fecha de devolución
       loan.setStatus(LoanStatus.RETURNED);
       loan.setReturnDate(LocalDateTime.now());

       return loan;
    }


    public boolean addUser(User user) {
        return users.add(user);
    }

    public List<Loan> getLoans() {
        return loans;
    }
}
