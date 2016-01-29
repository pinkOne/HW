package ua.di1.library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static ua.di1.Test.checkResult;

/**
 * Created by I on 28.01.2016.
 */
public class TestLibrary {
    public static void main(String[] args) {
        testAddReader();
        testGetReaders();
        testAddBook();
        testGetBooks();
        testLeaseBook();
        testShowLeasedBooks();
        testBannReader();
        testShowBooksByAuthor();
        testShowBooksByEdition();
    }

    private static void testShowBooksByEdition() {
        Library library = createLibrary();

        String showBooksByEditionView = "\n" + library.showBooksByEdition((library.getBooks()[1].getEdition()));
        System.out.println(showBooksByEditionView);

        checkResult("testShowBooksByEdition",
                showBooksByEditionView.length() > 0
        );
    }

    private static void testShowBooksByAuthor() {
        Library library = createLibrary();

        String showBooksByAuthorView = "\n" + library.showBooksByAuthor(library.getBooks()[0].getAuthor());
        System.out.println(showBooksByAuthorView);

        checkResult("testShowBooksByAuthor",
                showBooksByAuthorView.length() > 0
        );
    }

    private static void testBannReader() {
        Library library = createLibrary();

        Reader reader = new Reader("Galia");
        library.bannReader(reader);

        checkResult("testBannReader that is not a member of library",
                ! library.isBanned(reader)
        );

        library.addReader(reader);
        checkResult("testBannReader",
                library.bannReader(reader)
                    && library.isBanned(reader)
        );

        checkResult("testBannReader can not lease any book",
                library.leaseBook(reader, library.getBooks()[0]) == null
        );
    }

    private static Library createLibrary(){
        Date editionDate = null;
        try {
            editionDate = new SimpleDateFormat("yyyy-MM-dd").parse("1861-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Book book = new Book("Great expectations", "Charles Dickens", editionDate);

        Library library = new Library();
        library.addBook(book);

        try {
            editionDate = new SimpleDateFormat("yyyy-MM-dd").parse("1952-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        book = new Book("City", "Clifford Simak", editionDate);
        library.addBook(book);

        try {
            editionDate = new SimpleDateFormat("yyyy-MM-dd").parse("1986-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        book = new Book("The Name of the Rose", "Umberto Eco", editionDate);
        library.addBook(book);

        try {
            editionDate = new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        book = new Book("99 Francs", "Frederic Beigbeder", editionDate);
        library.addBook(book);

        return library;
    }

    private static void testShowLeasedBooks() {
        Library library = createLibrary();

        Reader reader = new Reader("Olesia");
        library.addReader(reader);
        library.leaseBook(reader, library.getBooks()[0]);
        library.leaseBook(reader, library.getBooks()[1]);
        library.leaseBook(reader, library.getBooks()[2]);

        Reader anotherReader = new Reader("Sofiia");
        library.addReader(anotherReader);
        library.leaseBook(anotherReader, library.getBooks()[2]);
        library.leaseBook(anotherReader, library.getBooks()[0]);

        String leasedBooksView = library.showLeasedBooks();
        System.out.println("\n" + leasedBooksView);

        checkResult("testShowLeasedBooks",
                leasedBooksView.length() > 0
        );

        leasedBooksView = library.showLeasedBooks(reader);
        System.out.println("\n" + leasedBooksView);

        checkResult("testShowLeasedBooks by user",
                leasedBooksView.length() > 0
        );

    }

    private static void testLeaseBook() {
        Date editionDate = null;
        try {
            editionDate = new SimpleDateFormat("yyyy-MM-dd").parse("1861-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Book book = new Book("Great expectations", "Charles Dickens", editionDate);

        Library library = new Library();
        library.addBook(book);

        Reader reader = new Reader("Olesia");

        Record record = library.leaseBook(reader, book);

        checkResult("testLeaseBook by unknown user",
                record == null
        );

        library.addReader(reader);
        record = library.leaseBook(reader, book);

        checkResult("testLeaseBook",
                record != null
                    && record.getBook() != null
        );

    }

    private static void testGetBooks() {
        Date editionDate = null;
        try {
            editionDate = new SimpleDateFormat("yyyy-MM-dd").parse("1861-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Book book = new Book("Great expectations", "Charles Dickens", editionDate);

        Library library = new Library();
        library.addBook(book);

        checkResult("testGetBooks",
                library.getBooks().length == 1
        );

    }

    private static void testAddBook() {
        Date editionDate = null;
        try {
            editionDate = new SimpleDateFormat("yyyy-MM-dd").parse("1861-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Book book = new Book("Great expectations", "Charles Dickens", editionDate);

        Library library = new Library();

        checkResult("testAddBook",
                library.addBook(book)
        );
    }

    private static void testGetReaders() {
        Reader reader = new Reader("Olesia");
        Library library = new Library();
        library.addReader(reader);

        int readersCount = library.getReaders().length;

        checkResult("testGetReaders",
                readersCount == 1
        );

    }

    private static void testAddReader() {
        Reader reader = new Reader("Olesia");
        Library library = new Library();

        checkResult("testAddReader",
                library.addReader(reader)
        );
    }
}
