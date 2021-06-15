/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laptop center
 */
public class Quadratic_Probing {

    private StoredStudent[] hashtable;

    public Quadratic_Probing(){
        hashtable = new StoredStudent[100];
    }

    private int hashKey(String key){
        return key.length()%hashtable.length;
    }

    private boolean occupied(int hashedKey){
        return hashtable[hashedKey]!= null;
    }

    public void put(String key, Student std){
         int i = 1;
        int hashedKey = hashKey(key);
        if(occupied(hashedKey)){
            int stopIndex = hashedKey  ;
            while (occupied(hashedKey) && hashedKey!=stopIndex){
                hashedKey = (i=hashedKey + i  * i++)% hashtable.length;
            }

        }

        if(occupied(hashedKey)){
            System.out.println("Sorry, can't add ! An item already exists at "+hashedKey);
        } else{
            hashtable[hashedKey] = new StoredStudent(key,std);
        }

    }

    public Student get(String key){
        int hashedKey = hashKey(key);
        int i = 1;
        while (hashtable[1] != null ){
        if(hashtable[i].equals(key))
           hashedKey = (hashedKey + i  * i++)% hashtable.length;
                       System.out.println("i "+ i);

        }
        if(hashedKey == -1){
            return null;
        } else {
            return hashtable[hashedKey].getStudent();
        }
    }

    public Student remove(String key){
        int hashedKey = findKey(key);
        int i = 1;
        int hashedKeyy = hashKey(key);
        if(hashedKey == -1){
            return null;
        } else {
           Student Std = hashtable[hashedKey].getStudent();
            hashtable[hashedKey] = null;
            StoredStudent[] oldHashtable = hashtable;
            hashtable = new StoredStudent[oldHashtable.length];
            for( i = (hashedKeyy + i  * i++)% hashtable.length ; hashtable[i] != null ; i = (hashedKeyy + i  * i++)% hashtable.length ){
                if(oldHashtable[i]!=null) {
                    put(oldHashtable[i].getKey(), oldHashtable[i].getStudent());
                }
            }
            return Std;
        }

    }

    public int findKey(String key){
        int hashedKey = hashKey(key);
        if(hashtable[hashedKey]!= null &&
            hashtable[hashedKey].getKey().equals(key)){
            return hashedKey;
        }
        int stopIndex = hashedKey;
        if(hashedKey == (hashtable.length - 1)){
            hashedKey = 0;
        }
        else {
            hashedKey++;
        }

        while (hashtable[hashedKey]!= null
                && hashedKey!= stopIndex
                && !(hashtable[hashedKey].getKey().equals(key))){
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if(hashtable[hashedKey]!= null
            && hashtable[hashedKey].getKey().equals(key)){
            return hashedKey;
        }
        else {
            return -1;
        }

    }

    public void printHashtable(){
        for(int i = 0; i < hashtable.length; i++){
            if(hashtable[i] == null){
                System.out.println("******");
            } else {
                System.out.println(hashtable[i].getStudent());
            }
        }
    }


}