package com.team7;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    /**
     * @author Vagelis Giannakosian
     * method public static void main() -
     * Instantiates an object from Main
     */
    public static void main(String[] args) {
        Main mainMenu = new Main();
        mainMenu.Menu();

    }

    public void Menu(){
        boolean finished = false;

        while (!finished) {
            try {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("---- Select Functionality to perform:");
                System.out.println("1. Vehicle Insurance status");
                System.out.println("2. Forecoming Expiries");
                System.out.println("3. Expiries by plate");
                System.out.println("4. Fine calculation per owner");
                System.out.println("5. Exit");
                System.out.print("Choose:");
                int choice = keyboard.nextInt();
                Functions func = new Functions();
                switch (choice) {
                    case 1:
                        func.function1();
                        break;
                    case 2:
                        func.function2();
                        break;
                    case 3:
                        func.function3();
                        break;
                    case 4:
                        func.function4();
                        break;
                    case 5:
                        finished = func.closemenu();
                        break;
                    default:
                        System.out.println("Please select one of the given options");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input, please select one of the given options.");
            }

        }

    }

}
