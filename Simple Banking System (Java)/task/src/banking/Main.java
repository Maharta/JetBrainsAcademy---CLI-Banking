package banking;

import java.util.Scanner;

public class Main {
    private static boolean isActive = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardSystem cardSystem = CardSystem.getInstance();
        String dbFilePath = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-fileName")) {
                dbFilePath = args[i + 1];
                break;
            }
        }

        if (dbFilePath.isEmpty()) {
            System.out.println("Database path argument is not specified!");
            return;
        }


        BankDB.setUrl("jdbc:sqlite:" + dbFilePath);
        BankDB.createOrConnectToDBFile();
        BankDB.createCardTableIfNotExist();

        do {
            System.out.println("1. Create an account");
            System.out.println("2. Log into account");
            System.out.println("0. Exit");

            String input = scanner.nextLine();

            switch (input) {
                case "1" -> {
                    Card newCard = cardSystem.addCard();
                    System.out.println("Your card number:");
                    System.out.println(newCard.getNumber());
                    System.out.println("Your card PIN:");
                    System.out.println(newCard.getPIN());
                }
                case "2" -> isActive = openLoginCLI();
                case "0" -> isActive = false;
                default -> System.out.println("Please input a number between 1, 2, or 0");
            }

        } while (isActive);

    }

    private static boolean openLoginCLI() {
        CardSystem cardSystem = CardSystem.getInstance();
        System.out.println("Enter your card number:");
        Scanner scanner = new Scanner(System.in);
        String cardNumber = scanner.nextLine();
        System.out.println("Enter your PIN:");
        String PIN = scanner.nextLine();

        Card card = cardSystem.loginWithCredentials(cardNumber, PIN);
        boolean success = card != null;

        if (!success) {
            System.out.println("Wrong card number or PIN!");
            return true;
        }

        System.out.println("You have successfully logged in!");

        while (true) {
            System.out.println("1. Balance");
            System.out.println("2. Log out");
            System.out.println("0. Exit");


            String input = scanner.nextLine();

            switch (input) {
                case "1" -> {
                    int balance = card.getBalance();
                    System.out.println(balance);
                }
                case "2" -> {
                    scanner.close();
                    return true;
                }
                case "0" -> {
                    return false;
                }
                default -> System.out.println("Input a number between 1, 2, or 0");
            }

        }

    }
}