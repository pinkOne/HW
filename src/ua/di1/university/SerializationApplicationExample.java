package ua.di1.university;

import java.io.File;

/**
 * Created by I on 2016-02-25.
 */
public class SerializationApplicationExample {
    public static void main(String[] args) {
        File file = new File("serializedStudent.txt");
        if (file.exists()){
            ; // read from file / deserialize
        }


        Student student1 = new Student("Kolia");
        Student student2 = new Student("Vasia");
    }
}
