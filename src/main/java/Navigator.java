public class Navigator {
    private static Navigator navigator;
    MainMenu mainMenu = new MainMenu();
    Cart cart = new Cart();
    Catalog catalog = new Catalog();
    Order order = new Order();

    private Navigator() {
    }

    public static Navigator getInstance() {
        if (navigator == null) {
            navigator = new Navigator();
        }
        return navigator;
    }

}
