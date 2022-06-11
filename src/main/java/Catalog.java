import parsing.Parser;
import parsing.Product;

public class Catalog implements Page {
    private final String catalogAddress = "src/main/resources/catalog.json";
    protected Parser catalog = new Parser(catalogAddress);

    private void filterMenu() {
        System.out.println("По какому параметру будем фильтровать?");
        System.out.println("1. Code");
        System.out.println("2. Name");
        System.out.println("3. Price");
        System.out.println("4. Manufacturer");
        System.out.println("5. Color");
        int param = User.silentChoiceInt();
        System.out.println("Введите значение для поиска:");
        String value = User.choiceString();
        switch (param) {
            case (1):
                while (true) {
                    try {
                        catalog.getList().stream()
                                .filter(x -> x.getCode() == Integer.parseInt(value))
                                .forEach(System.out::println);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка! Нужно ввести число");
                    }
                }
            case (2):
                catalog.getList().stream().filter(x -> x.getName().contains(value))
                        .forEach(System.out::println);
                break;
            case (3):
                while (true) {
                    try {
                        catalog.getList().stream()
                                .filter(x -> x.getPrice() == Double.parseDouble(value))
                                .forEach(System.out::println);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка! Нужно ввести число в формате double");
                    }
                }
            case (4):
                catalog.getList().stream().filter(x -> x.getManufacturer().contains(value))
                        .forEach(System.out::println);
                break;
            case (5):
                catalog.getList().stream().filter(x -> x.getColor().contains(value))
                        .forEach(System.out::println);
                break;
            default:
                System.out.println("Такого пункта меню нет");
                break;
        }
    }

    @Override
    public void printBody() {
        System.out.println("Каталог:");
        catalog.printCatalog();
    }

    @Override
    public void printMenu() {
        System.out.println("1. Добавить товар в корзину");
        System.out.println("2. Фильтр товаров");
        System.out.println("3. Перейти в корзину");
        System.out.println("4. Вернуться в главное меню");
        userChoice(User.choiceInt());

    }

    @Override
    public void userChoice(int option) {
        switch (option) {
            case (0):
                System.out.println("Программа завершена!");
                return;
            case (1):
                System.out.println("Введите code товара для добавления");
                int input = User.silentChoiceInt();
                System.out.println("Введите количество товара для добавления");
                int amount = User.silentChoiceInt();
                boolean found = false;
                for (Product p :
                        catalog.getList()) {
                    if (p.getCode() == input) {
                        navigator.cart.addToCart(p, amount);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Товар не найден");
                }
                printMenu();
                break;
            case (2):
                filterMenu();
                printMenu();
                break;
            case (3):
                navigator.cart.printBody();
                navigator.cart.printMenu();
                break;
            case (4):
                navigator.mainMenu.printBody();
                navigator.mainMenu.printMenu();
                break;
            default:
                System.out.println("Такого пункта меню нет");
        }

    }
}
