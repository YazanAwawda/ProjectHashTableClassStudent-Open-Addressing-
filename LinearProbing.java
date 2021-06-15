/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laptop center
 */
public class LinearProbing {

    private StoredStudent[] hashtable;

    public LinearProbing(){
        hashtable = new StoredStudent[100];
    }

    private int hashKey(String key){
        return key.length()%hashtable.length;
    }

    private boolean occupied(int hashedKey){
        return hashtable[hashedKey]!= null;
    }

    public void put(String key, Student std){
        int hashedKey = hashKey(key);
        if(occupied(hashedKey)){
            int stopIndex = hashedKey;
            if(hashedKey == (hashtable.length - 1)){
                hashedKey = 0;
            }
            else {
                hashedKey++;
            }
            while (occupied(hashedKey) && hashedKey!=stopIndex){
                hashedKey = (hashedKey + 1)% hashtable.length;
            }

        }


        if(occupied(hashedKey)){
            System.out.println("Sorry, can't add ! An item already exists at "+hashedKey);
        } else{
            hashtable[hashedKey] = new StoredStudent(key,std);
        }

    }

    public Student get(String key){
        int hashedKey = findKey(key);
        if(hashedKey == -1){
            return null;
        } else {
            return hashtable[hashedKey].getStudent();
        }
    }

    public Student remove(String key){
        int hashedKey = findKey(key);
        if(hashedKey == -1){
            return null;
        } else {
           Student Std = hashtable[hashedKey].getStudent();
            hashtable[hashedKey] = null;
            StoredStudent[] oldHashtable = hashtable;
            hashtable = new StoredStudent[oldHashtable.length];
            for(int i = 0; i < oldHashtable.length;i++){
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