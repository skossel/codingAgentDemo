import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Java Taschenrechner ===");
        System.out.println("Operationen: + | - | * | /");
        System.out.println("Beenden mit 'q'");
        System.out.println();

        while (true) {
            System.out.print("Erste Zahl: ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("q")) break;

            double a;
            try {
                a = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte eine Zahl eingeben.");
                continue;
            }

            System.out.print("Operation (+, -, *, /): ");
            String op = scanner.nextLine().trim();

            System.out.print("Zweite Zahl: ");
            input = scanner.nextLine().trim();
            double b;
            try {
                b = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte eine Zahl eingeben.");
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
