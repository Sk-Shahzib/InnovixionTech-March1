package mypackage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    Scanner sc = new Scanner(System.in);
    public double numcontainer[] = new double[20];
    public int inputnum;

    public void welcomePage() {
        System.out.println("Welcome to MyCalculator");
        System.out.println("7   8   9   /");
        System.out.println("4   5   6   *");
        System.out.println("1   2   3   -");
        System.out.println("0   .   =   +");
    }

    // Get multiple values input.
    public void numInput() {
        System.out.println("\nEnter a number, How many values do you want to perform operations on?");
        try {
            inputnum = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            sc.nextLine(); // Clear the input buffer
            numInput(); // Recursively call numInput method until valid input is provided
            return;
        }
        sc.nextLine(); // Clear the input buffer
        System.out.println("Enter (" + inputnum + ") values ");
        System.out.println("(Alert..!) If you want to do Division then, Please do not enter zero '0'");
        for (int i = 0; i < inputnum; i++) {
            try {
                numcontainer[i] = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine(); // Clear the input buffer
                i--; // Decrement i to re-enter the current value
            }
        }
        System.out.println(); // Blank Space
        sc.nextLine(); // Clear the input buffer
        mainPag();
    }

    public double addition(double numcontainer[], int inputnum) {
        double sum = 0.0;
        for (int i = 0; i < inputnum; i++) {
            sum = sum + numcontainer[i];
        }
        return sum;
    }

    public double substraction(double numcontainer[], int inputnum) {
        double storefirstvalue = numcontainer[0];
        for (int i = 1; i <= inputnum; i++) {
            storefirstvalue = storefirstvalue - numcontainer[i];
        }
        return storefirstvalue;
    }

    public double multiplication(double numcontainer[], int inputnum) {
        double mul = numcontainer[0];
        for (int i = 1; i <= inputnum; i++) {
            mul = mul * numcontainer[i];
        }
        return mul;
    }

    public double division(double numcontainer[], int inputnum) {
        double div = numcontainer[0];
        for (int i = 1; i <= inputnum; i++) {
            if (numcontainer[i] == 0) {
                System.out.println("Cannot divide by zero.");
                return Double.NaN; // Return NaN (Not a Number) for division by zero
            }
            div = div / numcontainer[i];
        }
        return div;
    }

    public void mainPag() {
        boolean dependvar = true;
        while (dependvar) {
            System.out.println("Which arithmetic operation do you want to perform");
            System.out.println("Enter any arithmetic operator symbol ");
            System.out.println("For \nAddition '+'  \nSubstraction '-'  \nMultiplication '*'  \nDivision '/'");

            String inputOperator = sc.nextLine();
            try {

                switch (inputOperator) {
                    case "+":
                        double add = addition(numcontainer, inputnum);
                        System.out.println("Addition is: " + add);
                        break;
                    case "-":
                        double sub = substraction(numcontainer, inputnum);
                        System.out.println("Substraction is: " + sub);
                        break;
                    case "*":
                        double mul = multiplication(numcontainer, inputnum);
                        System.out.println("Multiplication is: " + mul);
                        break;
                    case "/":
                        double div = division(numcontainer, inputnum);
                        if (!Double.isNaN(div)) {
                            System.out.println("Division is: " + div);
                        }
                        break;
                    default:
                        System.out.println("Invalid input. Please enter a valid arithmetic operator.");
                        continue;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            boolean innerloopd = true;
            while (innerloopd) {
                System.out.println("\nDo you want to perform more operations? (Y/Exit)");
                String ConOrEx = sc.next();
                String exit = "Exit";
                String continueOp = "Y";

                if (ConOrEx.equalsIgnoreCase(continueOp)) {
                    numInput();
                    sc.nextLine();
                } else if (ConOrEx.equalsIgnoreCase(exit)) {
                    System.out.println("You have exited successfully.");
                    dependvar = false;
                    innerloopd = false;
                } else {
                    System.out.println("Invalid input. Please try again.");
                    continue;
                }
            } // close inner loop
        } // close outer loop
    } // close method
}
