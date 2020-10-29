package com.goacademy.ub;

import java.util.Scanner;

public class App {

    static double result = 0.0;
    static Scanner inputStream;

    public static void main(String[] args) {
        inputStream = new Scanner(System.in);

        while (true) {
            processInput(inputStream.nextLine());
        }
    }

    public static void processInput(String input) {
        String[] splittedInput = input.split(" ");
        String command = splittedInput[0];
        int value = 0;
        if(splittedInput.length == 2) {
            value = Integer.parseInt(splittedInput[1]);
        }

        switch (command) {
            case "add":
                result += value;
                break;
            case "subtract":
                result -= value;
                break;
            case "multiply":
                result *= value;
                break;
            case "divide":
                if(value == 0) {
                    System.out.println("Cannot divide by 0");
                } else {
                    result /= value;
                }
                break;
            case "reset":
                result = 0.0;
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println();
        }

        System.out.println(result);
    }
}
