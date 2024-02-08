package stack;

import java.util.Stack;

class Answer {

    // Change these boolean values to control whether you see
    // the expected result and/or hints.
    static boolean showExpectedResult = false;
    static boolean showHints = false;

    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String token) {
        return "+-*/".contains(token);
    }

    private static double performOperation(String operator, double operand1, double operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    // Return the result of the Reverse Polish notation expression
    static double evaluateRPN(String expression) {
        // Your code goes here.
        // track all operands in a stack, if item in string is an operand pop the previous otems and operate on them

        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                double operandOne = stack.pop();
                double operandTwo = stack.pop();
                double result = performOperation(token, operandOne, operandTwo);
                stack.push(result);
            }
        }

        return stack.pop();

    }

}
