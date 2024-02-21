package com.thetestingacademy.vwo.coreJava;

import java.util.Scanner;

public class FibonacciSeriesEasy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the max length to print FibonacciSeriesEasy ::");
        int fiblength = scanner.nextInt();
        int[] num = new int[fiblength];
        num[0] = 0;
        num[1] = 1;
        for (int i = 2; i <= num.length-1; i++) {
            num[i] = num[i - 1] + num[i - 2];


        }
        System.out.print("FibonacciSeries::");
        for(Integer numb:num){

            System.out.print(numb+",");
        }

    }
}
