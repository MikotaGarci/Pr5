package Pr2;

public class TextTableRenderer extends AbstractTableRenderer {
    @Override
    public String render(CalculationResult result, int displayOption) {
        return renderTable(result, displayOption);
    }

    @Override
    public String renderTable(CalculationResult result, int displayOption) {
        // Реалізуйте метод для створення текстової таблиці тут
        return "Текстова таблиця з результатами";
    }
}