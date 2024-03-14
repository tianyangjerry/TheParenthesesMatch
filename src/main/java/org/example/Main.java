package org.example;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter an expression made up of only " +
                "‘{‘, ‘(‘, ‘[‘, ‘]’, ‘)’, or ‘}’");
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        System.out.println(checkBalancedParentheses(expression));
    }
    public static boolean checkBalancedParentheses(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
