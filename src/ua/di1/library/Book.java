package ua.di1.library;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by I on 28.01.2016.
 */
public class Book {
    private String name;
    private String author;
    private Date edition;

    public Book(String name, String author, Date edition) {
        this.name = name;
        this.author = author;
        this.edition = edition;
    }

    public String getAuthor() {
        return author;
    }

    public Date getEdition() {
        return edition;
    }

    public String getName() {

        return name;
    }

    public String asString(){
        return String.format("%s, %s, %s",
                name,
                author,
                new SimpleDateFormat("yyyy").format(edition));
    }
}
