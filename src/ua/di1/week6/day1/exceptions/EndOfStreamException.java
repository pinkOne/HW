package ua.di1.week6.day1.exceptions;

/**
 * Created by I on 2016-02-27.
 */
public class EndOfStreamException extends Exception {
    public EndOfStreamException() {
        super("Reached the end of the stream!");
    }
}
