/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laptop center
 */



public class StoredStudent {

    private String key;
    private Student Std;

    public StoredStudent(String key, Student Std) {
        this.key = key;
        this.Std = Std;
    }

    StoredStudent(int i) {
    }

  

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Student getStudent() {
        return Std;
    }

    public void setStudent(Student Std) {
        this.Std = Std;
    }
}

