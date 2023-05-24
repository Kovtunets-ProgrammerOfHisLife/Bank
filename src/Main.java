import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static final int ATM_NUMBER = 123;
    static final int PIN = 123;
    static Scanner in = new Scanner(System.in);
    static LinkedList<String> records = new LinkedList<>();

    static double balance = 0;

    public static void main(String[] args) {
        signIn();

        while (true){
            showMenuOptions();
            getNumberAndDo();
        }
    }

    private static void signIn() {
        while (!askAtmAndPin()){
            System.out.println("Wrong password or atm_number, try one more time!");
        }
        System.out.println("Welcome to Atm machine!");
    }

    private static void getNumberAndDo() {
        int number = in.nextInt();
        switch (number) {
            case 1 -> availableBalance();
            case 2 -> withdrawAmount();
            case 3 -> depositAmount();
            case 4 -> viewMiniStatement();
            case 5 -> exit();
        }
    }

    private static void exit() {
        System.out.println("You're exited");
        signIn();
    }

    private static void viewMiniStatement() {
        for (String record : records) {
            System.out.println(record);
        }
    }

    private static void depositAmount() {
        System.out.println("Enter amount for deposit: ");
        double amount = in.nextDouble();
        balance += amount;
        records.add(amount + " amount deposited");
        System.out.println(amount + "$ deposited successfully in your account!");
        availableBalance();
    }

    private static void withdrawAmount() {
        System.out.println("Enter amount you want to Withdraw: ");
        double amount = in.nextDouble();
        balance -= amount;
        records.add(amount + " amount withdrawn");
        System.out.println("Collect your "+amount+"$");
        availableBalance();
    }

    private static void availableBalance() {
        System.out.println("Available Balance: " + balance + "$");
    }

    private static void showMenuOptions() {
        String[] offers = { "Check Available Balance",
                "Withdraw Amount",
                "Deposit Amount",
                "View Mini Statement",
                "Exit" };
        for (int i = 0; i < offers.length; i++) {
            System.out.println((i + 1) + ". " + offers[i]);
        }
        System.out.println("Enter your choice");
    }

    /**
     * @return boolean: true if atm_number en pin are correct and false if not.
     */
    private static boolean askAtmAndPin() {
        System.out.println("Enter AtmNumber:");
        int atm = in.nextInt();
        System.out.println("Enter Pin:");
        int pin = in.nextInt();

        return atm == ATM_NUMBER && pin == PIN;
    }
}