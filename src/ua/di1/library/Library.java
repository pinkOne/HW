package ua.di1.library;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by I on 28.01.2016.
 */
public class Library {
    private final String name;
    private Book[] books;
    private Reader[] readers;
    private Reader[] blackList;
    private final int maxBooks;
    private final int maxReaders;
    private int booksCount;
    private int readersCount;
    private int blackListCount;
    private final int leasePeriod = 3; //days

    public Library() {
        name = "VERNADSKY LIBRARY";
        maxBooks = 100;
        maxReaders = 100;
        booksCount = 0;
        readersCount = 0;
        books = new Book[maxBooks];
        readers = new Reader[maxReaders];
        blackList = new Reader[maxReaders];
    }

    public boolean addReader(Reader reader){
        if (readersCount >= maxReaders) return false;
        readers[readersCount] = reader;
        readersCount++;
        return true;
    }

    public Reader[] getReaders(){
        return Arrays.copyOf(readers,readersCount);
    }

    public boolean addBook(Book book){
        if (booksCount >= maxBooks) return false;
        books[booksCount] = book;
        booksCount++;
        return true;
    }

    public Book[] getBooks(){
        return Arrays.copyOf(books,booksCount);
    }

    public Record leaseBook(Reader reader, Book book){
        boolean readerValidated = isReaderValidated(reader);
        boolean bookValidated = isBookValidated(book);

        if (! (readerValidated && bookValidated) ) return null;

        if (isBanned(reader)) return null;

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, leasePeriod);
        Record record = new Record(book, Calendar.getInstance().getTime(), calendar.getTime());

        return (reader.addRecord(record)) ? record : null;
    }

    private boolean isBookValidated(Book book) {
        for (int i = 0; i < booksCount; i++) {
            if (books[i] == book) {
                return true;
            }
        }
        return false;
    }

    private boolean isReaderValidated(Reader reader) {
        for (int i = 0; i < readersCount; i++) {
            if (readers[i] == reader) {
                return true;
            }
        }
        return false;
    }

    public boolean isBanned(Reader reader){
        for (int i = 0; i < blackListCount; i++) {
            if (blackList[i] == reader) return true;
        }
        return false;
    }

    public String showLeasedBooks(){
        return showLeasedBooks(null);
    }

    public String showLeasedBooks(Reader reader){
        String leasedBooksView = name;
        for (int i = 0; i < readersCount; i++) {

            if ( (reader == null)
                    || ( readers[i] == reader) ) {

                leasedBooksView += String.format("\n\tReader %s. Leased books:", readers[i].getName());

                String sB;

                for (int b = 0; b < readers[i].getRecords().length; b++) {
                    Book book = readers[i].getRecords()[b].getBook();
                    leasedBooksView += String.format("\n\t\t%s", book.asString());
                }
            }
        }
        return leasedBooksView;
    }

    public boolean bannReader(Reader reader) {
        if (! (isReaderValidated(reader) && (!isBanned(reader)) ) ) return false;

        blackList[blackListCount] = reader;
        blackListCount++;

        return true;
    }

    public String showBooksByAuthor(String author) {
        String showBooksByAuthorView = String.format("%s\n\tBooks by %s:", name, author);
        for (int i = 0; i < booksCount; i++) {
            if (books[i].getAuthor().equals(author)){
                showBooksByAuthorView += String.format("\t\t%s", books[i].asString());
            }
        }
        return showBooksByAuthorView;
    }

    public String showBooksByEdition(Date edition) {
        String showBooksByEditionView = String.format("%s\n\tBooks on %s:",
                                                name,
                                                new SimpleDateFormat("yyyy").format(edition));
        for (int i = 0; i < booksCount; i++) {
            if (books[i].getEdition().after(edition)){
                showBooksByEditionView += String.format("\t\t%s", books[i].asString());
            }
        }
        return showBooksByEditionView;
    }
}
