package Pr2;

import java.io.Serializable;

/**
 * Класс, представляющий результат вычислений.
 */
public class CalculationResult implements Serializable {
    private double parameter1;
    private double parameter2;
    private double result;

    /**
     * Конструктор для инициализации объекта результата вычислений.
     * 
     * @param parameter1 Параметр 1.
     * @param parameter2 Параметр 2.
     */
    public CalculationResult(double parameter1, double parameter2) {
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
        this.result = parameter1 + parameter2;
    }

    /**
     * Получить значение параметра 1.
     * 
     * @return Значение параметра 1.
     */
    public double getParameter1() {
        return parameter1;
    }

    /**
     * Получить значение параметра 2.
     * 
     * @return Значение параметра 2.
     */
    public double getParameter2() {
        return parameter2;
    }

    /**
     * Получить результат вычислений.
     * 
     * @return Результат вычислений.
     */
    public double getResult() {
        return result;
    }
}