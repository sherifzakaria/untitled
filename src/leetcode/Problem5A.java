package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

// 155. Min Stack
public class Problem5A {
}

class MinStackA {

    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStackA() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
