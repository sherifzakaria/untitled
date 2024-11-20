package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

// 20. Valid Parentheses
public class Problem4 {

    public static void main(String[] args) {
        System.out.println(new Problem4().isValid("]"));
    }

    public boolean isValid(String s) {
        Deque<Character> brackets = new ArrayDeque<>();
        for (char b : s.toCharArray()) {
            if (b == '(' || b == '[' || b == '{') {
                brackets.push(b);
            } else {
                try {
                    if (b == ')' && brackets.pop() != '(') {
                        return false;
                    }
                    if (b == '}' && brackets.pop() != '{') {
                        return false;
                    }
                    if (b == ']' && brackets.pop() != '[') {
                        return false;
                    }
                } catch (NoSuchElementException ex) {
                    return false;
                }
            }
        }

        return brackets.isEmpty();
    }
}
