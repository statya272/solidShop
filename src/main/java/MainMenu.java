public class MainMenu implements Page{
    @Override
    public void printBody() {
        System.out.println("Главное меню:");
    }

    @Override
    public void printMenu() {
        System.out.println("1. Каталог товаров");
        System.out.println("2. Корзина");
        System.out.println("3. Заказы");
        userChoice(User.choiceInt());
    }

    @Override
    public void userChoice(int option) {
        switch (option){
            case (0):
                System.out.println("Программа завершена!");
                return;
            case (1):
                navigator.catalog.printBody();
                navigator.catalog.printMenu();
                break;
            case (2):
                navigator.cart.printBody();
                navigator.cart.printMenu();
                break;
            case (3):
                navigator.order.printBody();
                navigator.order.printMenu();
                break;
            default:
                System.out.println("Такого пункта меню нет");
        }
    }
}
