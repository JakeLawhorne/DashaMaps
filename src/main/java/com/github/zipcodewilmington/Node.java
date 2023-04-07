package com.github.zipcodewilmington;

public class Node {

    String key;
    String value;
    Node next;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Node(String key, String data){
        this.value = data;
        this.key = key;
        next = null;
    }
}
