package com.github.zipcodewilmington;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMap implements HashMapX{

    /*  The second version would be the exact same code except it would be .charAt(1) - 97.
        The third one would require a very different hasFunction. We would need to account
        for when the value is greater than or less than the alphabet ascii numbers.
        Also, we would have to modify the set function to ignore key values
        less than 2. Other than that I believe the functionality would remain the same.
     */
    Node[] arr = new Node[26];

    private int hashFunctionOne(String input) {
        if (input.length() > 0) {
            return input.toLowerCase().charAt(0) - 97;
        }
        return -1;
    }

    @Override
    public void set(String key, String value) {
        int index = hashFunctionOne(key);
        Node current = arr[index];
        if(current == null){
            arr[index] = new Node(key, value);
            return;
        }
        while(current.getNext() != null){
            current = current.getNext();
        }
        current.setNext(new Node(key, value));
    }

    @Override
    public String delete(String key) {
        int index = hashFunctionOne(key);
        Node current = arr[index];
        Node previous = null;
        if(bucketSize(key) < 2){
            arr[hashFunctionOne(key)] = null;
            return ""; //fix later
        }
        while(current != null){
            if(current.getKey().equals(key)){
                String val = current.getValue();
                current = current.getNext();
                previous.setNext(current);
                return val;
            }
            previous = current;
            current = current.getNext();
        }

        return current.getValue();
    }

    @Override
    public String get(String key) {
        int index = hashFunctionOne(key);
        Node current = arr[index];

        while(current.getNext() != null){
            if(current.getKey().equals(key)){
                return current.getValue();
            } current = current.getNext();
        }
        return current.getValue();
    }

    @Override
    public boolean isEmpty(){return size() == 0;}

    @Override
    public long size() {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            Node current = arr[i];

            while(current != null){
                count++;
                current = current.getNext();
            }
        }
        return count;
    }

    @Override
    public long bucketSize(String key) {
        long count = 0;
        int index = hashFunctionOne(key);
        Node current = arr[index];

        while(current != null){
            count++;
            current = current.getNext();
        }
        return count;
    }
}
