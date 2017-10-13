package com.example.windows_81.calculator;

/**
 * Created by Windows-8.1 on 1/19/2017.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;




public final class Calculator {

    private static Queue<String> expressionQueue;
    private static Queue<String> expressionQueuePostfix;

    private Calculator(){

    }

    public static String calculateExpression(String expr) throws Exception{
        try{
            Calculator.parseExpression(expr);
            Calculator.convertIntoPostfix();
            String result = Calculator.calculatePostfixExpression();
            return result;
        }catch(Exception ex){
            throw ex;
        }
    }

    private static String calculatePostfixExpression() {
        Stack<String> operandStack = new Stack<String>();

        while(!expressionQueuePostfix.isEmpty()){
            String token = expressionQueuePostfix.poll();
            if(isOperand(token))
                operandStack.push(token);
            else{
                double result;
                double first = Double.parseDouble(operandStack.pop());
                double second = Double.parseDouble(operandStack.pop());
                switch(token){
                    case "+":
                        result = second + first;
                        operandStack.push(String.valueOf(result));
                        break;
                    case "-":
                        result = second - first;
                        operandStack.push(String.valueOf(result));
                        break;
                    case "*":
                        result = second * first;
                        operandStack.push(String.valueOf(result));
                        break;
                    case "/":
                        result = second / first;
                        operandStack.push(String.valueOf(result));
                        break;
                }
            }
        }

        if(operandStack.size() == 1)
            return operandStack.pop();
        else
            return "Invalid Expression";
    }

    private static void convertIntoPostfix() {
        Stack<Character> operatorStack = new Stack<Character>();
        expressionQueuePostfix = new LinkedList<String>();
        while(!expressionQueue.isEmpty()){
            String token = expressionQueue.poll();
            if(isOperand(token))
                expressionQueuePostfix.add(token);
            else if(token.equals("("))
                operatorStack.push(token.charAt(0));
            else if(token.equals(")")){
                while(!operatorStack.empty() && operatorStack.peek() != '('){
                    char val = operatorStack.pop();
                    expressionQueuePostfix.add(String.valueOf(val));
                }
                operatorStack.pop();  // popping '(' from stack
            }
            else if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                if(operatorStack.empty() || operatorStack.peek() == '(')
                    operatorStack.push(token.charAt(0));
                else{
                    while(!operatorStack.empty() && operatorStack.peek() != '(' && Calculator.getPrecedence(token.charAt(0)) <= Calculator.getPrecedence(operatorStack.peek())){
                        char val = operatorStack.pop();
                        expressionQueuePostfix.add(String.valueOf(val));
                    }
                    operatorStack.push(token.charAt(0));
                }
            }
        }

        while(!operatorStack.empty()){
            char val = operatorStack.pop();
            expressionQueuePostfix.add(String.valueOf(val));
        }

    }

    private static boolean isOperand(String token) {
        if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("(") || token.equals(")"))
            return false;
        else
            return true;
    }

    private static int getPrecedence(char op) {
        if(op == '*' || op == '/')
            return 2;
        else if(op == '+' || op == '-')
            return 1;
        return 10;
    }

    private static void parseExpression(String expr) {
        String token = "";
        expressionQueue = new LinkedList<String>();
        for(int i=0; i<expr.length(); i++){
            char ch = expr.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch =='(' || ch == ')'){
                if(!token.equals(""))
                    expressionQueue.add(token);
                expressionQueue.add(Character.toString(ch));
                token = "";
            }
            else{
                token = token + Character.toString(ch);
            }
        }
        if(!token.equals(""))
            expressionQueue.add(token);

    }

    public static void main(String[] args) throws Exception {


        System.out.println(Calculator.calculateExpression("6*3+2/6"));


    }

}

