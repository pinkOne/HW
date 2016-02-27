package ua.di1.week6.day1.io;



import ua.di1.week6.day1.exceptions.EmptyStreamException;
import ua.di1.week6.day1.exceptions.EndOfStreamException;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.util.InputMismatchException;

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
    int buffer = -1;

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
        return getNextPart();
    }

    private void readOne(){
        try {
            buffer = reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (buffer == -1) try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getNextPart() throws Exception {
        if (buffer >= 0){
            StringBuilder stringBuilder = new StringBuilder();
            while (buffer != -1){
                //TODO: multychar delimiter
                if(buffer == delimiter){
                    if (stringBuilder.length() == 0){
                        ; // ignore multy delimiter sequences
                    }else{
                        return stringBuilder.toString();
                    }
                }
                stringBuilder.append((char)buffer);
                readOne();
            }
            return stringBuilder.toString();
        }else{
            throw new EndOfStreamException();
        }
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
        return buffer >= 0;
    }

    public boolean hasNextInt(){
        boolean result = false;
        int tempPosition = -1;
        if (tempPosition >= 0){
            try {
                Integer.parseInt(getNextPart());
                return true;
            } catch (Exception e) {
                return false;
            }
        }else{
            return false;
        }
    }
}
