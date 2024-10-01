package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    public void start(Scanner scanner){
        System.out.print("Укажите размер коллекции: ");
        int n = scanner.nextInt();
        int min = -10000;
        int max = 10000;
        ArrayList<Double>numbersList = new ArrayList<>();
        System.out.print("Начальная коллекция: ");
        for(int i=0;i<n;i++){
            double randomNum = (Math.random() * (max - min + 1)) + min;
            System.out.print(randomNum+" ");
            numbersList.add(randomNum);
        }
        System.out.print("\nОтсортированная коллекция: ");
        insertionSort(numbersList);
        for(Double el:numbersList){
            System.out.print(el+" ");
        }
    }
    private void insertionSort(ArrayList<Double>numbersList){
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
