import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int input = -1;
        do {
            try {
                input = Integer.parseInt(scanner.next());
                if (sum < 1000) {
                    sum += input;
                }
            } catch (Exception e) {
                System.out.println("Wrong input format " + e.getMessage());
            }

        } while (input != 0);

        if (sum >= 1000) {
            System.out.println(sum - 1000);
        } else {
            System.out.println(sum);
        }
    }
}