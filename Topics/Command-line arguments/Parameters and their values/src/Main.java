class Problem {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            if (i % 2 == 0) {
                result.append(args[i]);
            } else {
                result.append("=");
                result.append(args[i]);
                System.out.println(result);
                result = new StringBuilder();
            }
        }
    }
}