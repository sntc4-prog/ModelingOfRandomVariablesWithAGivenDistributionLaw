import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int value;
        Scanner input = new Scanner(System.in);
        System.out.println("""
                [1] -> Равномерно распределенной на отрезке [0, 1];
                [2] -> Показательно распределенной с параметром λ > 0;
                [3] -> Нормально распределенной с параметрами a и σ > 0.
                [4] -> Нормально распределенной с произвольными a и σ""");
        RandomVariablesGenerator generator = new RandomVariablesGenerator();
        List<Double> values;
        value = input.nextInt();
        switch (value) {
            case (1) -> {
                //Моделирование случайной величины, равномерно распределенной на отрезке [0,1)
                values = generator.generateValues(1, 100);
                for (Double val : values) {
                    System.out.println(val);
                }
            }
            case (2) -> {
                //Показательное распределение
                values = generator.generateValues(2, 100);
                for (Double val : values) {
                    System.out.println(val);
                }
            }
            case (3) -> {
                //Нормальное распределение
                values = generator.generateValues(3, 100);
                for (Double val : values) {
                    System.out.println(val);
                }
            }
            case (4) -> {
                //Нормальное распределение с произвольными a и σ
                values = generator.generateValues(4, 100);
                for (Double val : values) {
                    System.out.println(val);
                }
            }
        }
    }
}