package ua.di1.week6.day1.io;



import ua.di1.week6.day1.exceptions.EmptyStreamException;
import ua.di1.week6.day1.exceptions.EndOfStreamException;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Created by I on 2016-02-25.
 * Написать собственную реализацию класса Scanner, работающую с символьными потоками.
 Создать два конструктора в один передается объект по ссылке Reader, во второй String.

 Реализовать методы:

 String next() - чтение одного слова в строке
 int nextInt() - чтение целого числа из строки или InputMismatchException
 String nextLine() - чтение всей строки
 boolean hasNext() - определение наличия в потоке данных
 boolean hasNextInt() - определение наличия в потоке целого int числа
 useDelemiter(String) - использует разделитель
 close() - закрытие сканнера, теперь нельзя использовать и NoSuchElementException
 */
public class Scanner {
    private char delimiter = ' ';
    private Reader reader;
    String buffer = "";
    List numbers = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));

    public Scanner(String streamingString) throws EmptyStreamException {
        if (streamingString.length() < 1) throw new EmptyStreamException();
        reader = new CharArrayReader(streamingString.toCharArray());
        readOne();
    }

    public Scanner(Reader reader) throws EmptyStreamException {
        if (reader == null) throw new EmptyStreamException();
        this.reader = reader;
        readOne();
    }

    public void useDelimiter(char delimiter) {
        this.delimiter = delimiter;
    }

    public char getDelimiter() {
        return delimiter;
    }

    public String next() throws Exception {
        String result = buffer;
        buffer = getNextPart();
        return result;
    }

    private void readOne(){
        try {
            buffer = getNextPart();
        } catch (EndOfStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (buffer.length() == 0) try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getNextPart() throws EndOfStreamException, IOException {
            StringBuilder stringBuilder = new StringBuilder();
            int readChar = -1;
            try {
                while ((readChar = reader.read()) != -1){
                    //TODO: multychar delimiter
                    if(readChar == delimiter){
                        if (stringBuilder.length() == 0){
                            ; // ignore multy delimiter sequences
                        }else{
                            return stringBuilder.toString();
                        }
                    }
                    stringBuilder.append((char)readChar);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return stringBuilder.toString();
    }

    public int nextInt() throws InputMismatchException {
        int result = 0;
        try {
            result = Integer.parseInt(getNextPart());
        } catch (Exception e) {
            throw new InputMismatchException(e.getMessage());
        }
        return result;
    }

    public String nextLine() throws Exception {
        String result;
        char oldDelimiter = getDelimiter();
        //TODO: fix required for multichar separator
        useDelimiter(System.lineSeparator().charAt(0));
        result = getNextPart();
        useDelimiter(oldDelimiter);
        return result;
    }

    public boolean hasNext(){
        return buffer.length() > 0;
    }

    public boolean hasNextInt(){
        if (buffer.length() == 0) return false;
        try {
            numbers.contains(Integer.parseInt(buffer.substring(0,1)));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
