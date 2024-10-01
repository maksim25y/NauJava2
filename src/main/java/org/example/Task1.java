package org.example;

import java.util.Scanner;

public class Task1
{
    public void start(Scanner scanner){
        System.out.print("Укажите размер массива: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        int min = -10000;
        int max = 10000;
        for(int i=0;i<n;i++){
            int randomNum = (int)(Math.random() * (max - min + 1)) + min;
            array[i]=randomNum;
        }
        int sum = 0;
        for(int i=0;i<n;i++){
            int element = array[i];
            if(element>0){
                sum+=element;
            }
        }
        for(int el:array){
            System.out.print(el+" ");
        }
        System.out.println("\nСумма элементов: "+sum);
    }
}
