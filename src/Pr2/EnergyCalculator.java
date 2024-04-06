package Pr2;

/**
 * Класс, содержащий методы для вычисления энергии.
 */
public class EnergyCalculator {
    /**
     * Метод для вычисления полной энергии физического тела.
     * 
     * @param mass     Масса тела.
     * @param velocity Скорость тела.
     * @param height   Высота тела.
     * @return Полная энергия физического тела.
     */
    public static double calculateTotalEnergy(double mass, double velocity, double height) {
        return mass * velocity * velocity / 2 + mass * 9.81 * height;
    }
}