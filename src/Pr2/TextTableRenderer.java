package Pr2;

public class TextTableRenderer extends AbstractTableRenderer {
    @Override
    public String render(CalculationResult result) {
        return renderTable(result);
    }

    @Override
    public String renderTable(CalculationResult result) {
        // Реализуйте метод для создания текстовой таблицы здесь
        return "Текстовая таблица с результатами";
    }
}