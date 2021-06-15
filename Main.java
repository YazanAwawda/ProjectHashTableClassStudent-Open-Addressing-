/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laptop center
 */

//Yazan Awawda 21910967

//Tester For LinearProbing

public class Main {

    public static void main(String[] args) {
//Tester For LinearProbing

        Student Ahmad = new Student(10,"Ahmad");
        Student Omar = new Student(15,"Omar");
        Student Adnan = new Student(19,"Adnan");
        Student Ali = new Student(16,"Ali");
        Student Malak = new Student(14,"Malak");
        Student Samy = new Student(13,"Samy");

       LinearProbing ht = new LinearProbing();
//Tester For LinearProbing

        ht.put("Ahmad",Ahmad);
        ht.put("Omar",Omar);
        ht.put("Adnan",Adnan);
        ht.put("Ali",Ali);
        ht.put("Malak",Malak);
        ht.put("Samy",Samy);

 //Tester For LinearProbing

 ht.printHashtable();

        System.out.println("Retrieve value for Ahmad : "+ht.get("Ahmad"));

        System.out.println("Retrieve value for Omar : "+ht.get("Omar"));

        ht.remove("Ahmad");

        ht.printHashtable();

        ht.remove("Omar");

        ht.printHashtable();

        System.out.println("Retrieve value for Malak : "+ht.get("Malak")); 

    }
}