/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laptop center
 */
public class DoubleProbing {
    private final StoredStudent[] hashArray;
    private final int arraySize;
    private final StoredStudent nonItem;

    public DoubleProbing(int size){
        arraySize = size;
        hashArray = new StoredStudent[arraySize];
        nonItem = new StoredStudent(-1);
    }

    public void displayTable(){
        System.out.println("Table: ");
        for (int i = 0; i < arraySize; i++){
            if(hashArray[i] != null)
                System.out.print(hashArray[i].getKey()+" ");
            else
                System.out.print("*****");
        }
        System.out.println("");
    }

    public int hashFunc1(String key){
        return key.length() % arraySize;
    }


    public int hashFunc2(String key){
        return 5 - key.length() % 5;
    }

    public void insert(String key, StoredStudent item){
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);

        while(hashArray[hashVal] != null &&
                hashArray[hashVal].getKey() != null){
            hashVal += stepSize;
    }

    }
    public StoredStudent delete(String key){
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);

        while (hashArray[hashVal] != null){
            if(hashArray[hashVal].getKey().equals(key)){
      StoredStudent temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }

    public StoredStudent find(String key) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].equals(key)) {
                return hashArray[hashVal];
            }
            hashVal = hashVal + stepSize;
            hashVal = hashVal % arraySize;

        }
        return hashArray[hashVal];
    }
}

