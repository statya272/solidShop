import java.util.Scanner;

public class User {
    private static Scanner scanner = new Scanner(System.in);

    public static String choiceString() {
                return scanner.nextLine();
    }
    public static int choiceInt() {
        System.out.println("Введите пункт меню или 0 для завершения программы");
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Ошибка! Введите пункт меню или 0 для завершения программы");
            }
        }
    }

    public static int silentChoiceInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Ошибка! Введите пункт меню или 0 для завершения программы");
            }
        }
    }
}
