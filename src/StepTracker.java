import java.util.Scanner;

class StepTracker {
    MonthData[] monthToData = new MonthData[12];
    Scanner scanner;
    int goalByStepsPerDay = 10_000;
    Converter converter = new Converter();
    StepTracker(Scanner scanner) {
        this.scanner = scanner;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        if (!(month >= 1 && month <= 12)) {
            System.out.println("Номер вводимого месяца должен быть от 1 до 12 включительно");
            return;
        }

        System.out.println("Введите день от 1 до 30");
        int day = scanner.nextInt();
        if (!(day >= 1 && day <= 30)) {
            System.out.println("Номер вводимого дня должен быть от 1 до 30 включительно");
            return;
        }

        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        if (steps < 0) {
            System.out.println("Количество шагов должно быть положительным числом");
            return;
        }

        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = steps;
    }

    void changeStepGoal() {
        System.out.println("Цель шагов в день, введите количество шагов");
        goalByStepsPerDay = scanner.nextInt();
        if (goalByStepsPerDay < 0) {
            System.out.println("Количество шагов должно быть положительным числом");
        }
    }

    void printStatistic() {
        System.out.println("Введите число месяца");
        int month = scanner.nextInt();
        if (!(month >= 1 && month <= 12)) {
            System.out.println("Номер вводимого месяца должен быть от 1 до 12 включительно");
            return;
        }

        MonthData monthData = monthToData[month - 1];
        int sumSteps = monthData.sumStepsFromMonth();
        System.out.println("Количество пройденных шагов по дням:");
        monthData.printDaysAndStepsFromMonth();
        System.out.println("Общее количество шагов за месяц: " + sumSteps);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + monthData.maxSteps());
        System.out.println("Среднее количество шагов: " + sumSteps/30);
        System.out.println("Пройденная дистанция (в километрах): " + converter.convertToKm(sumSteps));
        System.out.println("Количество сожжённых килокалорий: " + converter.convertStepsToKilocalories(sumSteps));
        System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println();
    }
}
