package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int min = -10_000;
        int max = 10_000;
        ArrayList<Double>numbersList = new ArrayList<>();
        for(int i=0;i<n;i++){
            double randomNum = (Math.random() * (max - min + 1)) + min;
            System.out.print(randomNum+" ");
            numbersList.add(randomNum);
        }
        System.out.println();
        insertionSort(numbersList);
        for(Double el:numbersList){
            System.out.print(el+" ");
        }
    }
    public static void insertionSort(ArrayList<Double>numbersList){
        for (int i = 1; i < numbersList.size(); i++) {
            double key = numbersList.get(i);
            int j = i - 1;
            while (j >= 0 && key < numbersList.get(j)) {
                numbersList.set(j + 1, numbersList.get(j));
                j--;
            }
            numbersList.set(j + 1, key);
        }
    }
}
