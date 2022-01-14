import java.util.ArrayList;
import java.util.List;

public class RandomVariablesGenerator {
    List<Double> values = new ArrayList<>();
    public List<Double> generateValues(int option,int quantity) {

        switch (option) {
            case (1):
                //Моделирование случайной величины, равномерно распределенной на отрезке [0,1)
                for (int i = 0; i < quantity; i++) {
                    values.add(getUValue());
                }
                break;
            case (2):
                //Показательное распределение

                double l = 1;//lyambda>0
                for (int i = 0; i < quantity; i++) {
                    double indicativeDistribution = -l * Math.log(getUValue());
                    values.add(indicativeDistribution);
                }
                break;
            case (3):
                //Нормальное распределение
                for (int i = 0; i < quantity; i++) {
                    values.add(getNormalDistributionValue());
                }
                break;
            case (4):
                //Нормальное распределение с произвольными a и σ
                for (int i = 0; i < quantity; i++) {
                    values.add(getArbitaryNormalDistributionValue(1, 1));
                }
                break;
        }
        return values;
    }

    private double getNormalDistributionValue() {
        double v1, v2, s, x1;
        do {
            v1 = 2 * getUValue() - 1;
            v2 = 2 * getUValue() - 1;
            s = v1 * v1 + v2 * v2;
        } while (s >= 1 || s == 0);
        double sqrt = Math.sqrt((-2 * Math.log(s)) / s);
        x1 = v2 * sqrt;
        return x1;
    }

    private double getArbitaryNormalDistributionValue(double a, double sigma) {
        return sigma * getNormalDistributionValue() + a;
    }


    private double getUValue() {
        double rand = Math.random();//Возвращает [0,1)
        double N = 1;
        return rand / N;
    }
}
