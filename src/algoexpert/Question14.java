package algoexpert;

public class Question14 {
    public static void main(String[] args) {
        System.out.println(runLengthEncoding("AAAAAAAAAAAAABBCCCCDD"));
    }

    public static String runLengthEncoding(String string) {
        // Write your code here.

        StringBuilder builder = new StringBuilder();
        int counter = 1;

        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i - 1) == string.charAt(i) && counter < 9) {
                counter++;
            } else {
                builder.append(counter).append(string.charAt(i - 1));
                counter = 1;
            }
        }

        builder.append(counter).append(string.charAt(string.length() - 1));

        return builder.toString();
    }
}
