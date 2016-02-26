package ua.di1.week6.day1.io;


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
    private String data = "";
    private int endIndex = -1;
    private String delimiter = " ";
    private int delimiterLength = 1;
    private int pointer = -1;
    private int delimiterPosition = -1;

    public Scanner(String streamingString) throws Exception {
        if (streamingString.length() < 1) throw new Exception("Stream is empty!");
        this.data = streamingString;
        endIndex = data.length();
        pointer = 0;
    }

    public void useDelimiter(String delimiter) {
        this.delimiter = delimiter;
        delimiterLength = delimiter.length();
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String next() throws Exception {
        return getNextPart();
    }

    private int getNextDelimiterPosition(){
        int tempPosition = data.substring(pointer, endIndex).indexOf(delimiter);
        if (tempPosition < 0){
            if (pointer < endIndex) {
                tempPosition = endIndex;
            }else{
                tempPosition = -1;
            }
        }
        if(tempPosition == 0) {
            pointer++;
            return getNextDelimiterPosition();
        }
        return pointer + tempPosition;
    }
    private String getNextPart() throws Exception {
        int tempPosition = getNextDelimiterPosition();
        if (tempPosition < 0) throw new Exception("Reached the end of the stream!");

        delimiterPosition = tempPosition;

        String result = data.substring(pointer, delimiterPosition);
        pointer = delimiterPosition + delimiter.length();
        return result;
    }

    public int nextInt() throws Exception {
        int result = Integer.parseInt(getNextPart());
        return result;
    }

    public String nextLine() throws Exception {
        String result;
        String oldDelimiter = getDelimiter();
        useDelimiter("\n");
        result = getNextPart();
        useDelimiter(oldDelimiter);
        return result;
    }

    public boolean hasNext(){
        return getNextDelimiterPosition() >= 0;
    }

    public boolean hasNextInt(){
        boolean result = false;
        int tempPosition = getNextDelimiterPosition();
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
