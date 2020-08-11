package program.com.exercise03;

public class Main {
    public static void main(String[] args) {
        CarManagement carManagement = new CarManagement();
        int option = 0;
        do {
            option = carManagement.menu();
            if (option == -1) {
                return;
            }

        } while (option != -1);
    }
}