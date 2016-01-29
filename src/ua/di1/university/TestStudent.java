package ua.di1.university;

import static ua.di1.Test.checkResult;

/**
 * Created by serhii on 23.01.16.
 */
public class TestStudent {


    public static void main(String[] args) {
        Student student1 = new Student("Kolia");
        Student student2 = new Student("Vasia");

        double money = Student.getMonthMoney();

        testAddStudent();
        testSearchStudent("5");
        testSearchStudentByName("Ivanov");
        testSearchByCity("Kiev");


        testAddSubject("Math");
        testLearn("Math", 3);
        testRemoveLastSubject();
        testShowSubjects();
        testGetRate();

    }

    private static void testGetRate() {
        MyDate birthDate = new MyDate(2001,01,02);
        Contact contact = new Contact("097xxxxxx", "1@1.com");

        Student student = new Student("Petrov",
                birthDate,
                new Address("Ukraine", "Kiev", "Peremohy", 10),
                contact
        );

        String subjectName = "Math";
        Subject subject = new Subject(subjectName, 6);
        student.addSubject(subject);
        student.study(subjectName, 5);
        student.passExam(subjectName);

        subjectName = "Biology";
        subject = new Subject(subjectName, 10);
        student.addSubject(subject);
        student.study(subjectName, 6);
        student.passExam(subjectName);

        checkResult("testGetRate",
                student.getRank() == 9
        );
    }

    private static void testShowSubjects() {
        MyDate birthDate = new MyDate(2001,01,02);
        Contact contact = new Contact("097xxxxxx", "1@1.com");

        Student student = new Student("Petrov",
                birthDate,
                new Address("Ukraine", "Kiev", "Peremohy", 10),
                contact
        );

        Subject subject = new Subject("Math", 6);
        student.addSubject(subject);

        String subjectsString = student.getSubjectsAsString();

        checkResult("testShowSubjects",
                subjectsString.length() > 0
        );
    }

    private static void testRemoveLastSubject() {
        MyDate birthDate = new MyDate(2001,01,02);
        Contact contact = new Contact("097xxxxxx", "1@1.com");

        Student student = new Student("Petrov",
                birthDate,
                new Address("Ukraine", "Kiev", "Peremohy", 10),
                contact
        );

        Subject subject = new Subject("Math", 6);
        student.addSubject(subject);

        subject = new Subject("Astronomy", 3);
        student.addSubject(subject);

        int count = student.getSubjectsCount();

        student.removeLastSubject();

        int newCount = student.getSubjectsCount();

        checkResult("testRemoveLastSubject",
                (count - newCount) == 1
        );
    }

    private static void testSetMark(String subject, int mark) {
        checkResult("testSetMark",
                false
        );
    }

    private static void testLearn(String subjectName, int hours) {
        MyDate birthDate = new MyDate(2001,01,02);
        Contact contact = new Contact("097xxxxxx", "1@1.com");

        Student student = new Student("Petrov",
                birthDate,
                new Address("Ukraine", "Kiev", "Peremohy", 10),
                contact
        );

        Subject subject = new Subject(subjectName, 6);
        student.addSubject(subject);
        student.study(subjectName, 5);

        checkResult("testLearn",
                subject.getHoursStudied() == 5
        );
    }


    private static void testAddSubject(String subjectName) {
        MyDate birthDate = new MyDate(2001,01,02);
        Contact contact = new Contact("097xxxxxx", "1@1.com");

        Student student = new Student("Petrov",
                birthDate,
                new Address("Ukraine", "Kiev", "Peremohy", 10),
                contact
        );

        Subject subject = new Subject(subjectName);
        student.addSubject(subject);

        checkResult("testAddSubject",
                student.getSubject(subjectName).getName().equals(subjectName)
        );
    }

    private static void testSearchByCity(String cityName) {
        Group group = new Group("ACO11");

        MyDate birthDate = new MyDate(2001,01,02);
        Contact contact = new Contact("097xxxxxx", "1@1.com");

        Student student = new Student("Petrov",
                birthDate,
                new Address("Ukraine", "Kiev", "Peremohy", 10),
                contact
        );
        group.addStudent(student);

        student = new Student("Ivanov",
                birthDate,
                new Address("Ukraine", "Sumy", "Peremohy", 5),
                contact);
        group.addStudent(student);

        Student st;
        checkResult("testSearchByCity",
                (group.filterByCity(cityName)).length == 1
        );
    }

    private static void testSearchStudentByName(String studentName) {
        Group group = new Group("ACO11");
        group.addStudent(new Student("Petrov"));
        group.addStudent(new Student("Ivanov"));
        group.addStudent(new Student("Kolesnikov"));
        group.addStudent(new Student("Volodarov"));
        Student st;
        checkResult("testSearchStudentByName",
                ( (st = group.findByName(studentName)) != null )
                        && (st.getName().equals(studentName))
        );
    }

    private static void testSearchStudent(String studentID) {
        Group group = new Group("ACO11");
        group.addStudent(new Student("Petrov"));
        group.addStudent(new Student("Ivanov"));
        group.addStudent(new Student("Kolesnikov"));
        group.addStudent(new Student("Volodarov"));

        Student st;
        checkResult("testSearchStudent",
                ( (st = group.findById(studentID)) != null )
                && (st.getName().equals("Kolesnikov"))
        );
    }


    private static void testAddStudent() {
        Group group = new Group("ACO11");
        Student student = new Student("me");

        int groupSize = group.getSize();

        group.addStudent(student);

        checkResult("testAddStudent", (group.getSize() - groupSize) == 1);
    }
}
