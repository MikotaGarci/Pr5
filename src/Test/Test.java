package Test;

import Pr2.*;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter mass:");
        double mass = scanner.nextDouble();
        
        System.out.println("Enter velocity:");
        double velocity = scanner.nextDouble();

        System.out.println("Enter height:");
        double height = scanner.nextDouble();

        // Обчислити загальну енергію
        double totalEnergy = Pr2.EnergyCalculator.calculateTotalEnergy(mass, velocity, height);
        System.out.println("Total Energy: " + totalEnergy);

        System.out.println("\nSelect display option (1 - Text table, 2 - HTML table):");
        int displayOption = scanner.nextInt();
        
        CalculationResultRenderer renderer;
        if (displayOption == 1) {
            renderer = new Pr2.TextTableRenderer();
        } else {
            renderer = new Pr2.HTMLResultRenderer();
        }

        // Створити об'єкт результату
        CalculationResult result = new Pr2.CalculationResult(mass, velocity);
        
        // Відобразити результат
        String renderedResult = renderer.render(result, displayOption);
        System.out.println("Rendered Result:\n" + renderedResult);
        
        scanner.close();
    }
}