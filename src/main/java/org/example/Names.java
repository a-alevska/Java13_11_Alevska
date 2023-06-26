package org.example;

public class Names {
    private final int index;
    private final String name;

    public Names(int index, String name){
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return index + ". " + name;
    }
}
