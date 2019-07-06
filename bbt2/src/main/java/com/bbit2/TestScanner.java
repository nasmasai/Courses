package com.bbit2;


import java.util.InputMismatchException;
import java.util.Scanner;

public class TestScanner {

    public static void main(String args[]){

    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter a numerator: ");
    try{
    int x = scanner.nextInt();

        System.out.println("Enter denominator:");

        int y = scanner.nextInt();

        double divident =x/y;

    System.out.println("The result is" + y);

    }
    catch (InputMismatchException ex) {
        System.out.println("Invalid integer");

    }
    catch (ArithmeticException ex){
        System.out.println("You cannot divide by zero");

    }
    }
}
