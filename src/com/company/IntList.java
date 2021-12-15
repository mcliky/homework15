package com.company;

import java.util.Arrays;

public class IntList {
    private int[] arr = new int[0];

    public void add(int value) {
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i <= arr.length - 1; i++) {
            newArr[i] += arr[i];
        }
        newArr[arr.length] = value;
        arr = newArr;

    }


    public int get(int index) {

        return arr[index];
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public int size() {

        return arr.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
    //question with domain if(true) number++;
}
