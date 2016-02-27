package ua.di1.library;

import java.util.Arrays;

/**
 * Created by I on 28.01.2016.
 *
 */
public class Reader {
    private String name;
    private Record [] records;
    private int maxBooksCount = 3;
    private int recordCount;

    public Reader(String name) {
        this.name = name;
        records = new Record[maxBooksCount];
        recordCount = 0;
    }

    public boolean addRecord(Record record){
        if ( recordCount >= maxBooksCount ) return false;
        records[recordCount] = record;
        recordCount++;
        return true;
    }

    public String getName() {
        return name;
    }

    public Record[] getRecords() {
        return Arrays.copyOf(records, recordCount);
    }
}
