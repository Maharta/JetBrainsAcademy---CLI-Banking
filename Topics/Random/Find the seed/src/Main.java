import java.util.*;

public class Main {
    private static final int INFINITY = 9_999_999;
    private static final int MIN_INFINITY = -9_999_999;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int minSeeds = a;
        int minOfMax = INFINITY;

        for (int i = a; i <= b; i++) {
            int currentMax = MIN_INFINITY;
            Random random = new Random(i);
            for (int j = 0; j < n; j++) {
                int val = random.nextInt(k);
                currentMax = Math.max(currentMax, val);
            }
            if (currentMax < minOfMax) {
                minOfMax = currentMax;
                minSeeds = i;
            }
            if (currentMax == minOfMax) {
                minSeeds = Math.min(i, minSeeds);
            }
        }

        System.out.println(minSeeds);
        System.out.println(minOfMax);
    }
}