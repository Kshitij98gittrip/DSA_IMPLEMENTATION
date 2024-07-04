package SearchingAndSorting.searching;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * Hashing is another type of searching technique
 * other searching methods are 
 * Linear search
 * Binary search
 * fibbonoci search
 * 
 * To avoid collision in hash table  we use 
 * 1-> Open addressing technique - in which we use another hashing function to find the next possible slot like r(k) =slot +1 
 * and it will be used again and again untill the next slot is not found (also known as probing method)
 * rehash fn linear(linear probing) or quaadratic (quadaratic probing) or polynomial fn (polynomial probing) 
 * it is internal storage data stored within array/table
 * 
 * Load factor - > no of key value pairs /num of slots
 * if no of kv pairs < no of slots ---> load factor  < 1
 *  if no of kv pairs = no of slots ---> load factor  = 1
 *  if no of kv pairs >  no of slots ---> load factor  > 1 (OPEN ADDRESSING CAN'T BE USED HERE)
 * 
 * 
 * 2-> Chaining
 * 
 * 
 * 
 * WATCH VIDEO 6
 */

 class HashTable{
    static class Pair{
        private int key;//key = roll
        private String value; //value = name

        public Pair(){
            this.key = 0;
            this.value = "";
        }

        public Pair(int key, String value){
            this.key = key;
            this.value = value;
        }

        public String toString(){
            return "Pair [key =" +key+",value = "+value + "]";

        }

    } 
    private static final int SLOTS = 10;
    
    private LinkedList<Pair> table[]; 

    public int hash(int key){
        return key % SLOTS;
    }
    public HashTable(){

        //an array of size 10 that has the refernces of liinkedlist and by default all are null
        table = new LinkedList[SLOTS];
        for(int i = 0; i < SLOTS; i++){
            //to avoid null point exception initialising it with empty linked list
            table[i] = new LinkedList<>();
        }
    }


    public void put(int key, String value){
        int slot = hash(key);

            LinkedList<Pair> bucket = table[slot]; 
            for (Pair p: bucket ){
                if (key == p.key){
                    p.value = value;
                    return;
                }
            }
            //if key not found
            Pair pair = new Pair(key, value);
            bucket.add(pair); 
        }

        public String get(int key){
            //find slot for given key using function
            //access the bucket(linekd list) in that slot
            //find the element in that bucket- linear search 
            int slot = hash(key);

            LinkedList<Pair> bucket = table[slot]; 
            for (Pair p: bucket ){
                if (key == p.key){
                    return p.value;
                }
            }
            //if key not found
            return null;
        }
    

 }
public class HashTableMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashTable ht = new HashTable();
        ht.put(1, "one");
        ht.put(4, "four");
        ht.put(8, "eight");
        ht.put(5, "five");
        ht.put(24, "twentyfour");
        ht.put(34, "thirtyfour");
        ht.put(25, "twentyfive");
        System.out.println("Enter roll no to find");
        int roll = sc.nextInt();
        String name = ht.get(roll);
        System.out.println("Name corresponding to roll "+roll+" = "+name);
        sc.close();


    }
}
