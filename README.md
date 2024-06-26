### Використання командного рядка Java для обчислення енергії та тестування

Цей Java-застосунок дозволяє обчислювати енергію фізичного тіла та тестувати різноманітні функції через командний рядок.
## AbstractTableRenderer.java
 ```bash
   package Pr2;

public abstract class AbstractTableRenderer implements CalculationResultRenderer {
    public abstract String renderTable(CalculationResult result, int displayOption);
}
```
## CalculationResult.java
 ```bash
   package Pr2;

import java.io.Serializable;

public class CalculationResult implements Serializable {
    private double parameter1;
    private double parameter2;
    private double result;

    public CalculationResult(double parameter1, double parameter2) {
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
        this.result = parameter1 + parameter2;
    }

    public double getParameter1() {
        return parameter1;
    }

    public double getParameter2() {
        return parameter2;
    }

    public double getResult() {
        return result;
    }
} 
```

## CalculationResultRenderer.java
 ```bash
   package Pr2;

public interface CalculationResultRenderer {
    String render(CalculationResult result, int displayOption);
}
```


## EnergyCalculator.java
 ```bash
    
package Pr2;

public class EnergyCalculator {
    public static double calculateTotalEnergy(double mass, double velocity, double height) {
        return mass * velocity * velocity / 2 + mass * 9.81 * height;
    }
} 
```


## HTMLResultRenderer.java
 ```bash
package Pr2;

public class HTMLResultRenderer implements CalculationResultRenderer {
    @Override
    public String render(CalculationResult result, int displayOption) {
        return "<html><body>Parameter1: " + result.getParameter1() + ", Parameter2: " + result.getParameter2() + ", Result: " + result.getResult() + "</body></html>";
    }
}
```


## SerializationDemo.java
 ```bash
package Pr2;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerializationDemo {
    public static void main(String[] args) {
        CalculationResult deserializedResult = null;
        try (FileInputStream fis = new FileInputStream("calculation_result.ser");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            deserializedResult = (CalculationResult) ois.readObject();
            CalculationResultRenderer renderer = new TextResultRenderer();
            System.out.println(renderer.render(deserializedResult, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## Solver.java
 ```bash
 package Pr2;

public class Solver {
    public static void main(String[] args) {
        // Ваш код здесь
    }
}
```


## TextResultRenderer.java
 ```bash
package Pr2;

public class TextResultRenderer implements CalculationResultRenderer {
    @Override
    public String render(CalculationResult result, int displayOption) {
        return "Parameter1: " + result.getParameter1() + ", Parameter2: " + result.getParameter2() + ", Result: " + result.getResult();
    }
}
```
## TextTableRenderer.java
 ```bash
package Pr2;

public class TextTableRenderer extends AbstractTableRenderer {
    @Override
    public String render(CalculationResult result, int displayOption) {
        return renderTable(result, displayOption);
    }

    @Override
    public String renderTable(CalculationResult result, int displayOption) {
        StringBuilder table = new StringBuilder();
        
        table.append("+-----------------------+\n");
        table.append("|   Parameter   |   Value   |\n");
        table.append("+-----------------------+\n");
        table.append(String.format("|    Parameter1 |  %.2f   |\n", result.getParameter1()));
        table.append(String.format("|    Parameter2 |  %.2f   |\n", result.getParameter2()));
        table.append(String.format("|       Result   |  %.2f   |\n", result.getResult()));
        table.append("+-----------------------+\n");
        
        return table.toString();
    }
}
```

## Test.java
 ```bash
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
```

### Ось результат ↓

![Результат](/screenshot/Pr5.png)




