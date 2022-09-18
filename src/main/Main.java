package main;

import shablon.Calculator;


import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String[] actions = {"+","-","/","*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        System.out.println("Введите выражение: ");
        String number = sc.nextLine();

        int actionIndex =- 1;
        for (int i = 0; i < actions.length; i++) {
            if(number.contains(actions[i] ) ){
                actionIndex = i;
                break;
            }
        }

        if (actionIndex ==- 1) {
            System.out.println("Некорректное выражение:");
            return;
        }

        String[] data = number.split(regexActions[actionIndex]);
        if (calculator.itsRomeNumber(data[0]) == calculator.itsRomeNumber(data[1]) ) {
            int a,b;

            boolean romeNumber = calculator.itsRomeNumber(data[0]);
            if (romeNumber) {
                a = calculator.romanToInt(data[0]);
                b = calculator.romanToInt(data[1]);
            } else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }

            int result;
            switch (actions[actionIndex] ){
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    result = a / b;
                    break;
            }
            if (romeNumber) {
                System.out.println(calculator.intToRoman(result) );
            } else {
                System.out.println(result);
            }
        }else{
            System.out.println("Числа должны быть в одном формате");
        }

    }
}