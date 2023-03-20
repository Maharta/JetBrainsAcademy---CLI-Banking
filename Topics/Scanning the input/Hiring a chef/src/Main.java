import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        String yearsOfExperience = scanner.nextLine();
        String cuisine = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append("The form for ").append(firstName);
        sb.append(" is completed. ").append("We will contact ");
        sb.append("you if we need a chef who cooks ");
        sb.append(cuisine).append(" dishes ");
        sb.append("and has ").append(yearsOfExperience);
        sb.append(" years of experience.");
        System.out.println(sb.toString());
        // start coding here
    }
}