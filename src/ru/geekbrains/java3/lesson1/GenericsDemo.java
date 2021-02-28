package ru.geekbrains.java3.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericsDemo<T> {

    public void exchangeElements(T[] arr, int firstIndex, int secondIndex) {
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
        System.out.println(Arrays.toString(fruits));

        GenericsDemo<String> gd = new GenericsDemo<>();
        gd.exchangeElements(fruits, 2,4);
        System.out.println(Arrays.toString(fruits));

        ArrayList<String> arrayList = gd.getArrayListFromArray(fruits);
        System.out.println(arrayList);
    }
}
