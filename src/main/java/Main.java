import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Программно реализовать три генератора случайных величин:
        1. равномерно распределенной на отрезке [0, 1];
        2. показательно распределенной с параметром λ > 0;
        3. нормально распределенной с параметрами a и σ > 0.
        В отчет включить все этапы выполнения задания. Привести скриншоты работающей
        программы в трех различных режимах. Для оценки качества генераторов сгенерировать
        числовые выборки и на их основе построить соответствующие гистограммы, которые
        включить в отчет.*/

        System.out.println("""
                1. равномерно распределенной на отрезке [0, 1];
                2. показательно распределенной с параметром λ > 0;
                3. нормально распределенной с параметрами a и σ > 0.""");
        int q;
        Scanner in = new Scanner(System.in);
        q = in.nextInt();
        switch (q) {
            case (1):
                //Моделирование случайной величины, равномерно распределенной на отрезке [0,1)
                double U = getU();
                break;
            case (2):
                //Показательное распределение
                double l = 1;//lyambda>0
                double indicativeDistribution = -l * Math.log(getU());
                System.out.println("[0;+infinity] Показательное распределение: " + indicativeDistribution);
                break;
            case (3):
                //Нормальное распределение
                System.out.println("(0,1) (a=0, sigma = 1) Нормальное распределение: " + normalDistribution());

                System.out.println("(0,1) (a=1, sigma = 1) Произвольное нормальное распределение: ");
                break;
        }
    }

    private static double normalDistribution() {
        double v1, v2, s, x1;
        do {
            v1 = 2 * getU() - 1;
            v2 = 2 * getU() - 1;
            s = v1 * v1 + v2 * v2;
        } while (s >= 1 || s == 0);
        double sqrt = Math.sqrt((-2 * Math.log(s)) / s);
        x1 = v2 * sqrt;
        return x1;
    }

    private static double arbitaryNormalDistribution(double x) {
        double sigma = 2;
        double a = 2;
        return sigma * x + a;
    }


    private static double getU() {
        double rand = Math.random();//Возвращает [0,1)
        double N = 1;
        double U = rand / N;
        System.out.println("[0,1) Случайная величина равномерно распределенная на отрезке: " + U);
        return U;
    }
}