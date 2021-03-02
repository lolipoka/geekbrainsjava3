package ru.geekbrains.java3.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericsDemo<T> {

    public void swapElements(T[] arr, int firstIndex, int secondIndex) {
        T temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    public ArrayList<T> getArrayListFromArray(T[] arr) {
        ArrayList<T> arrayList = new ArrayList<>(arr.length);
        arrayList.addAll(Arrays.asList(arr));
        return arrayList;
    }

    public static void main(String[] args) {
        String[] fruits = {"apple", "mango", "banana", "pear", "peach"};
        System.out.printf("Initial array: %s\n", Arrays.toString(fruits));

        GenericsDemo<String> gd = new GenericsDemo<>();
        gd.swapElements(fruits, 2,4);
        System.out.printf("Array after swapping elements: %s\n", Arrays.toString(fruits));

        ArrayList<String> arrayList = gd.getArrayListFromArray(fruits);
        System.out.printf("Array list from array: %s\n", arrayList);
    }
}
