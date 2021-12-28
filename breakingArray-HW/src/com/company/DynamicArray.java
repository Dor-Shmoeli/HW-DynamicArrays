package com.company;

public class DynamicArray {

    int[] array;
    int counter;

    // default constructor (without params);
    public DynamicArray() {
        array = new int[4];
        counter = 0;
    }

    public void add(int value) {
        if (array.length == counter) {
            createBiggerArray();
        }
        array[counter++] = value;
    }

    public void add(int index, int value) {
        if (index >= counter || index < 0) {
            throw new IndexOutOfBoundsException();  // like return it stops the method.
        }
        if (array.length == counter) {
            createBiggerArray();
        }

        for (int i = counter - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = value;
        counter++;


    }


    public int size() {
        return counter;
    }


    public void createBiggerArray() {
        // create an array with twice the space;
        int[] temp = new int[counter * 2];
        // copy the values from original array to new array;
        for (int i = 0; i < counter; i++) {
            temp[i] = array[i];
        }
        // call the new array "array";
        array = temp;
    }

    public void printArray() {
        //System.out.println("[20,50,-5,7,12]");
        System.out.print("[");
        for (int i = 0; i < counter; i++) {
            System.out.print(array[i]);
            if (i < counter - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public void set(int index, int value) {
        array[index] = value;
    }

    public void clear() {
        array = new int[4];
    }

    public boolean contains(int findNum) {

        for (int item : array) {
            if (findNum == item) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(int value) {

        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                return i;
            }

        }
        return -1;
    }

    public int get(int index) {
        if (index < array.length) {
            for (int i = 0; i < array.length; i++) {
                return array[index];
            }
        }
        System.out.println("array to short");
        return 0;
    }

    public void remove(int index) {
        for (int i = index; i < counter; i++) {
            array[i] = array[i + 1]  ;
        }
        //array[index] = 0;
        counter--;
    }
}
