
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author laptop center
 */
public class Student {
 private int Student_Age;
String Student_Name;

    public Student(int Student_Age, String Student_Name) {
        this.Student_Age = Student_Age;
        this.Student_Name = Student_Name;
    }



    public int getStudent_Age() {
        return Student_Age;
    }

    public String getStudent_Name() {
        return Student_Name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Student_Name);
    }

    @Override
    public String toString() {

        return "Student " + "[Student_Name: " + Student_Name + ",Student_Age: " + Student_Age + "]";

    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student std = (Student) o;
        return Student_Name.equals(std.Student_Name)
             ;
    }
    public void setStudent_Age(int Student_Age) {
        this.Student_Age = Student_Age;
    }

    public void setStudent_Name(String Student_Name) {
        this.Student_Name = Student_Name;
    }
}
