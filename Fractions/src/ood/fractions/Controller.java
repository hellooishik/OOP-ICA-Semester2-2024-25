/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ood.fractions;

/**
 *
 * @author USER
 */


import java.util.Scanner;

public class Controller {
    private static Fraction fraction1 = new Fraction(7, 8);
    private static Fraction fraction2 = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== FRACTION CALCULATOR =====");
            System.out.println("1. Display Fractions");
            System.out.println("2. Set Second Fraction");
            System.out.println("3. Add Fractions");
            System.out.println("4. Compare Fractions");
            System.out.println("5. Simplify Fractions");
            System.out.println("6. Quit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayFractions();
                    break;
                case 2:
                    setSecondFraction();
                    break;
                case 3:
                    addFractions();
                    break;
                case 4:
                    compareFractions();
                    break;
                case 5:
                    simplifyFractions();
                    break;
                case 6:
                    System.out.println("Goodbye! Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void displayFractions() {
        System.out.println("First fraction: " + fraction1);
        System.out.println("Second fraction: " + (fraction2 == null ? "Not set" : fraction2));
    }

    private static void setSecondFraction() {
        System.out.print("Enter numerator: ");
        int num = scanner.nextInt();
        System.out.print("Enter denominator: ");
        int den = scanner.nextInt();

        if (den == 0) {
            System.out.println("Denominator cannot be zero.");
            return;
        }
        fraction2 = new Fraction(num, den);
        System.out.println("Second fraction set: " + fraction2);
    }

    private static void addFractions() {
        if (fraction2 == null) {
            System.out.println("Second fraction is not set.");
            return;
        }
        Fraction result = fraction1.add(fraction2);
        System.out.println(fraction1 + " + " + fraction2 + " = " + result);
    }

    private static void compareFractions() {
        if (fraction2 == null) {
            System.out.println("Second fraction is not set.");
            return;
        }
        int comparison = fraction1.compare(fraction2);
        if (comparison > 0) {
            System.out.println(fraction1 + " is greater than " + fraction2);
        } else if (comparison < 0) {
            System.out.println(fraction1 + " is less than " + fraction2);
        } else {
            System.out.println(fraction1 + " is equal to " + fraction2);
        }
    }

    private static void simplifyFractions() {
        int[] simplified = fraction1.simplify();
        System.out.println(fraction1 + " simplifies to " + simplified[0] + "/" + simplified[1]);
    }
}
