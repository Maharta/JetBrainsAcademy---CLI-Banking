import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try {
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            int[][] matrix = new int[number][number];

            for (int i = 0; i < number; i++) {
                for (int j = 0; j < number; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < number; i++) {
                for (int j = 0; j < number; j++) {
                    if (matrix[i][j] != matrix[j][i]) {
                        System.out.println("NO");
                        return;
                    }
                }
            }
            System.out.println("YES");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}