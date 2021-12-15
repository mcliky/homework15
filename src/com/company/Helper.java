
package com.company;

public class Helper {

    private String word;
    private int count;

    public Helper(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Helper{" +
                "word='" + word + '\'' +
                ", count=" + count +
                '}';
    }
}