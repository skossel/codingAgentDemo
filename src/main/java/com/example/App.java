package com.example;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Java Taschenrechner ===");
        System.out.println("Operationen: + | - | * | /");
        System.out.println("Speicher:    MS (speichern) | M+ (addieren) | M- (subtrahieren) | MR (abrufen) | MC (loeschen)");
        System.out.println("Beenden mit 'q'");
        System.out.println();

        while (true) {
            System.out.print("Erste Zahl (oder MR / MC): ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("q")) break;

            if (input.equalsIgnoreCase("MR")) {
                System.out.printf("Speicher: %.2f%n%n", calculator.memoryRecall());
                continue;
            }
            if (input.equalsIgnoreCase("MC")) {
                calculator.memoryClear();
                System.out.println("Speicher geloescht.\n");
                continue;
            }

            double a;
            try {
                a = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ungueltige Eingabe. Bitte eine Zahl oder einen Speicherbefehl eingeben.");
                continue;
            }

            System.out.print("Operation (+, -, *, /, MS, M+, M-): ");
            String op = scanner.nextLine().trim();

            if (op.equalsIgnoreCase("MS")) {
                calculator.memoryStore(a);
                System.out.printf("%.2f im Speicher gespeichert.%n%n", a);
                continue;
            }
            if (op.equalsIgnoreCase("M+")) {
                calculator.memoryAdd(a);
                System.out.printf("%.2f zum Speicher addiert. Speicher: %.2f%n%n", a, calculator.memoryRecall());
                continue;
            }
            if (op.equalsIgnoreCase("M-")) {
                calculator.memorySubtract(a);
                System.out.printf("%.2f vom Speicher subtrahiert. Speicher: %.2f%n%n", a, calculator.memoryRecall());
                continue;
            }

            System.out.print("Zweite Zahl: ");
            input = scanner.nextLine().trim();
            double b;
            try {
                b = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ungueltige Eingabe. Bitte eine Zahl eingeben.");
                continue;
            }

            try {
                double result = switch (op) {
                    case "+" -> calculator.add(a, b);
                    case "-" -> calculator.subtract(a, b);
                    case "*" -> calculator.multiply(a, b);
                    case "/" -> calculator.divide(a, b);
                    default -> throw new IllegalArgumentException("Unbekannte Operation: " + op);
                };
                System.out.printf("Ergebnis: %.2f%n%n", result);
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println("Fehler: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Taschenrechner beendet.");
    }
}
