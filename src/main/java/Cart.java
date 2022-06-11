import parsing.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart implements Page {
    private Map<Product, Integer> cart = new HashMap<>();

    public void addToCart(Product product, int amount) {
        if (cart.containsKey(product)) {
            int newValue = cart.get(product) + amount;
            cart.replace(product, newValue);
        } else {
            cart.put(product, amount);
        }
        System.out.println("Товар " + product.getName() +
                " x" + amount +
                " добавлен в корзину");
    }

    public void removeFromCart(int code) {
        boolean found = false;
        for (Product p :
                navigator.catalog.catalog.getList()) {
            if (p.getCode() == code) {
                cart.remove(p);
                found = true;
                System.out.println("Товар " + p.getName() +
                        " удален из корзины");
            }
        }
        if (!found) {
            System.out.println("Товар не найден в корзине");
        }
    }

    @Override
    public void printBody() {
        System.out.println("Корзина:");
        if (cart.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(this);
        }
    }

    @Override
    public void printMenu() {
        System.out.println("1. Оформить заказ");
        System.out.println("2. Удалить товар из корзины");
        System.out.println("3. Вернуться в каталог товаров");
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
                navigator.order.makeOrder(toString());
                navigator.order.printBody();
                navigator.order.printMenu();
                break;
            case (2):
                System.out.println("Введите code товара для удаления");
                removeFromCart(User.silentChoiceInt());
                printBody();
                printMenu();
                break;
            case (3):
                navigator.catalog.printBody();
                navigator.catalog.printMenu();
                break;
            case (4):
                navigator.mainMenu.printBody();
                navigator.mainMenu.printMenu();
                break;
            default:
                System.out.println("Такого пункта меню нет");
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (Map.Entry<Product, Integer> pair : cart.entrySet()) {
            Product key = pair.getKey();
            int value = pair.getValue();
            result = result.concat("Code: " + key.getCode() + " " +
                    "Название: " + key.getName() + " Количество: " +
                    value + " Стоимость: " + (key.getPrice() * value) + "\n");
        }
        return result;
    }
}
