package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите номер задания: ");
        int numberOfTask = sc.nextInt();
        switch (numberOfTask){
            case 1:
                Task1 task1 = new Task1();
                task1.start(sc);
                break;
            case 2:
                Task2 task2 = new Task2();
                task2.start(sc);
                break;
            case 3:
                Task3 task3 = new Task3();
                task3.start();
                break;
            case 4:
                Task4 task4 = new Task4();
                task4.start();
                break;
            case 5:
                TaskImpl portsScanner = new TaskImpl("localhost", 1, 9000);
                portsScanner.start();

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ignored) {
                }

                portsScanner.stop();
                break;
            default:
                System.out.println("Задание с данным номером отсутствует");
                break;
        }
    }
}
