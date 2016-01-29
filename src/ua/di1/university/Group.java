package ua.di1.university;

import java.util.Arrays;

/**
 * Created by serhii on 23.01.16.
 */
public class Group {

    private int freePlace = 0;
    private String groupName;
    private Student[] students = new Student[24];

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public void addStudent(Student greenStudent){
        students[freePlace] = greenStudent;
        freePlace++;
    }

    public Student deleteLastStudent(){
        freePlace--;
		Student student = students[freePlace];
        students[freePlace] = null;
		return student;
    }





    public Student findById(String studentID){
        for (Student student: students) {
            if (student != null) {
                String currentStudentID = student.getIdNum();
                if (currentStudentID.equals(studentID)){
                    return student;
                }
            }
        }
        return null;
    }

    public Student[] filterByName(String name){
        Student[] res = new Student[freePlace];

        int curr = 0;
        for (int i = 0; i < freePlace; i++) {
            if(students[i].getName().equals(name)){
                res[curr] = students[i];
                curr++;
            }
        }

        return Arrays.copyOf(res,curr);
    }

    public Student[] filterByCity(String cityName){
        Student[] filteredStudents = new Student[freePlace];
        int pointer = 0;
        for (int i=0; i < freePlace; i++){
            if (students[i].getAddress().getCity().equals(cityName)){
                filteredStudents[pointer] = students[i];
                pointer++;
            }
        }

        return Arrays.copyOf(filteredStudents,pointer);
    }

    public Student findByName(String studentName){
        for (Student student: students) {
            if (student != null) {
                String currentStudentName = student.getName();
                if (currentStudentName.equals(studentName)){
                    return student;
                }
            }
        }
        return null;
    }
	public String asString(){
        String res = "GROUP NAME " + groupName +
                "\n"+ "Count " + freePlace + "\n";

        for (int i = 0; i < freePlace; i++) {
            Student student = students[i];
            res += student.asString() + "\n";
        }


        return res;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getSize(){
        return freePlace;
    }

    public Student[] sort() {
        return null;
    }


}
