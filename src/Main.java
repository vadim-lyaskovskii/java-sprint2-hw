import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вас приветствует счётчик калорий!");
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        while (true) {
            printMenu();
            int i = scanner.nextInt();
            if (i == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (i == 2) {
                stepTracker.changeStepGoal();
            } else if (i == 3) {
                stepTracker.printStatistic();
            } else if (i == 4) {
                break;
            } else {
                System.out.println("Неизвестная команда!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите одну из команд:");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Изменить цель по количеству шагов в день");
        System.out.println("3. Напечатать статистику за определённый месяц");
        System.out.println("4. Выйти из приложения");
    }
}
