package edu.eci.dosw.tdd.library;

import edu.eci.dosw.tdd.library.book.Book;
import edu.eci.dosw.tdd.library.loan.Loan;
import edu.eci.dosw.tdd.library.user.User;

import java.util.*;

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

        // TODO Implement the logic of loan a book to a user based on the UserId and the isbn.
        return null;
    }

    public Loan returnLoan(Loan loan) {

        // TODO Implement the logic to return a loan.
        return null;
    }

    public boolean addUser(User user) {
        return users.add(user);
    }

    public List<Loan> getLoans() {
        return loans;
    }
}
