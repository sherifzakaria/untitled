package algoexpert;

public class Question10 {
    public static void main(String[] args) {
        System.out.println(caesarCypherEncryptor("xyz", 2));
    }

    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.
        StringBuilder strBuilder = new StringBuilder();
        char z = 'z';
        key = key % 26;

        for (int i = 0; i < str.length(); i++) {
            char ch;
            if (str.charAt(i) + key > z) {
                ch = (char) ((str.charAt(i) + key - z) + 'a' -1);
            } else {
                ch = (char) (str.charAt(i) + key);
            }
            strBuilder.append(ch);
        }
        return strBuilder.toString();
    }
}
