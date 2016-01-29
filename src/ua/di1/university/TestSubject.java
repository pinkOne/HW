package ua.di1.university;

import static ua.di1.Test.checkResult;

/**
 * Created by I on 26.01.2016.
 */
public class TestSubject {
    public static void main(String[] args) {
        testCreateSubject("Math");
        testPassExam();
        testAsString();
        testGetMark();
        testStudy(3);
    }

    private static void testStudy(int i) {
        Subject subject;
        subject = new Subject("Math", 6);
        subject.study(5);
        checkResult("testStudy",
                subject.getHoursStudied() == 5
        );
    }

    private static void testGetMark() {
        Subject subject;
        subject = new Subject("Math", 6);

        checkResult("testGetMark.Part1",
                subject.getMark() == 0
        );
        subject.study(4);
        subject.passExam();
        checkResult("testGetMark.Part2",
                subject.getMark() == 8
        );
    }

    private static void testAsString() {
        Subject subject;
        subject = new Subject("Math");
        checkResult("testAsString",
                subject.asString().length() > 0
        );
    }

    private static void testPassExam() {
        Subject subject;
        subject = new Subject("Math", 6);
        subject.study(5);

        checkResult("testPassExam",
                subject.passExam()
        );
    }

    private static void testCreateSubject(String subjectName) {
        Subject subject;
        subject = new Subject(subjectName);

        checkResult("testCreateSubject",
                subject.getName().equals(subjectName)
        );

    }

}
