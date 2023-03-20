package banking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardSystem cardSystem = CardSystem.getInstance();


        while (true) {
            System.out.println("1. Create an account");
            System.out.println("2. Log into account");
            System.out.println("0. Exit");

            String input = scanner.nextLine();
            boolean breakLoop = false;

            switch (input) {
                case "1" -> {
                    Card newCard = cardSystem.addCard();
                    System.out.println("Your card number:");
                    System.out.println(newCard.getNumber());
                    System.out.println("Your card PIN:");
                    System.out.println(newCard.getPIN());
                }
                case "2" -> breakLoop = openLoginCLI();
                case "0" -> breakLoop = true;
                default -> System.out.println("Please input a number between 1, 2, or 0");
            }

            if (breakLoop) {
                break;
            }
        }

    }

    private static boolean openLoginCLI() {
        CardSystem cardSystem = CardSystem.getInstance();
        System.out.println("Enter your card number:");
        Scanner scanner = new Scanner(System.in);
        String cardNumber = scanner.nextLine();
        System.out.println("Enter your PIN:");
        String PIN = scanner.nextLine();

        Card card = cardSystem.getCardByNumber(cardNumber);
        boolean success = card != null && card.login(PIN);

        if (!success) {
            System.out.println("Wrong card number or PIN!");
            return false;
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
                    return false;
                }
                case "0" -> {
                    return true;
                }
                default -> System.out.println("Input a number between 1, 2, or 0");
            }

        }

    }
}