package edu.eci.dosw.tdd.library;

import edu.eci.dosw.tdd.library.book.Book;
import edu.eci.dosw.tdd.library.loan.Loan;
import edu.eci.dosw.tdd.library.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        // TODO Implement the logic to add a new book into the map.
        return false;
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
    public Loan returnLoan(Loan loan) {

        // TODO Implement the logic to return a loan.
        return null;
    }

    public boolean addUser(User user) {
        return users.add(user);
    }
}
