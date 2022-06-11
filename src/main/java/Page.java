public interface Page {

    Navigator navigator = Navigator.getInstance();

    void printBody();

    void printMenu();

    void userChoice(int option);
}
