import java.io.*;
import java.util.Objects;
import java.util.Random;

public class Order implements Page {
    private final String dirName = "src/main/resources/orders";
    private final Random random = new Random();
    private final int orderNumber = random.nextInt(1_000_000_000);
    private final String fileName = "Заказ №" + orderNumber;
    private final File ordersDir = new File(dirName);

    public void makeOrder(String cart) {
        String newFileName = fileName;
        String orderAddress = ordersDir + "/" + newFileName;
        try (FileWriter writer = new FileWriter(orderAddress)) {
            writer.write(cart);
            writer.flush();
            System.out.println(newFileName + " оформлен");
        } catch (IOException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printOrders() {
        try {
            if (Objects.requireNonNull(ordersDir.listFiles()).length == 0) {
                System.out.println("Список заказов пуст");
            } else {
                for (File order :
                        Objects.requireNonNull(ordersDir.listFiles())) {
                    String fileName = order.getName();
                    System.out.println(fileName);
                    System.out.println("{");
                    try {
                        FileReader fr = new FileReader(order);
                        BufferedReader reader = new BufferedReader(fr);
                        String line = reader.readLine();
                        while (line != null) {
                            System.out.println(line);
                            line = reader.readLine();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("}");
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void printBody() {
        System.out.println("Список заказов:");
        printOrders();
    }

    @Override
    public void printMenu() {
        System.out.println("1. Вернуться в главное меню");
        userChoice(User.choiceInt());
    }

    @Override
    public void userChoice(int option) {
        switch (option) {
            case (0):
                System.out.println("Программа завершена!");
                return;
            case (1):
                navigator.mainMenu.printBody();
                navigator.mainMenu.printMenu();
                break;
            default:
                System.out.println("Такого пункта меню нет");
        }
    }
}
