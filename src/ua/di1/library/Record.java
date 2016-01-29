package ua.di1.library;

import java.util.Date;

/**
 * Created by I on 28.01.2016.
 */
public class Record {
    private Book book;
    private Date leaseDate;
    private Date returnDate;

    public Record(Book book, Date leaseDate, Date returnDate) {
        this.book = book;
        this.leaseDate = leaseDate;
        this.returnDate = returnDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public Date getLeaseDate() {

        return leaseDate;
    }

    public Book getBook() {

        return book;
    }
}
