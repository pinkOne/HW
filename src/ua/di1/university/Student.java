package ua.di1.university;

import java.util.Map;

public class Student {

    private static double monthMoney = 790;
    private static int idCounter = 0;
    private String idNum;
    private String name;
    private int rank;


    private Subject[] subjects;
    private static final int maxSubjectCount = 3;
    private int subjectsCount = 0;

    private MyDate birthday;
    private Address address;
    private Contact contact;

    public Student() {
    }

    // run before constructors
    {
        this.idNum = String.valueOf(idCounter);
        idCounter++;

        subjects = new Subject[maxSubjectCount];
    }

    public int getSubjectsCount() {
        return subjectsCount;
    }

    public Student(String name) {
        this.name = name;

    }

    public Student(String name, MyDate birthday,
                   Address address, Contact contact) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.contact = contact;
    }

    public Subject getSubject(String subjectName){
        for (Subject subject: subjects) {
            if ((subject != null) && (subject.getName().equals(subjectName))) return subject;
        }
        return null;
    }

    public int study(String subjectName, int hours){
        return getSubject(subjectName).study(hours);
    }

    public boolean passExam(String subjectName){
        Subject subject = this.getSubject(subjectName);
        return subject.passExam();
    }

    public static double getMonthMoney() {
        return monthMoney;
    }

    public static void staticMeth(){
        //rank++;
    }

    public void nonStaticMeth(){
        monthMoney++;
    }

    public String getIdNum() {
        return idNum;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        int sumOfMarks = 0;
        for (int i = 0; i < subjectsCount; i++) {
            sumOfMarks += subjects[i].getMark();
        }
        rank = Math.round( (float)sumOfMarks / subjectsCount );
        return rank;
    }


    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String asString(){
        return String.format("id %s, name %s, birthday %s, address %s",
                                idNum, name, birthday.asString(), address.asString());
    }

    public Subject addSubject(Subject subject) {
        subjects[subjectsCount] = subject;
        subjectsCount++;
        return subject;
    }

    public Subject removeLastSubject() {
        Subject subject = subjects[subjectsCount-1];
        subjects[subjectsCount-1] = null;
        subjectsCount --;
        return subject;
    }

    public String getSubjectsAsString() {
        String subjectsAsString = String.format("Subjects for %s:\n", this.getName());
        for (int i = 0; i < subjectsCount; i++){
            if(i > 0) subjectsAsString += "\n";
            subjectsAsString += subjects[i].toString();
        }
        return subjectsAsString;
    }
}
