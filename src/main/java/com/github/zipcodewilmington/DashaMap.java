package com.github.zipcodewilmington;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMap implements HashMapX{

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
            current = new Node(key, value);
        }
        while(current.getNext() != null){
            current = current.getNext();
        }
        current.setNext(new Node(key, value));
    }

    @Override
    public String delete(String key) {

        return null;
    }

    @Override
    public String get(String key) {

        return null;
    }

    @Override
    public boolean isEmpty() {

        return false;
    }

    @Override
    public long size() {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            Node current = arr[i];

            while(current.next != null){
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

        while(current.next != null){
            count++;
            current = current.getNext();
        }
        return count;
    }
}
