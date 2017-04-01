package pl.marcinkokoszka.Lista4;

import com.sun.xml.internal.bind.v2.TODO;
import sun.invoke.empty.Empty;

import java.util.Scanner;

/**
 * Created by kokoseq on 01.04.2017.
 */
public class Main4_5 {

    public static void main(String[] args) {
        calculator();
    }

    //TODO make calculator take String[] and separate input from the algorythm

    private static void calculator(){
        UnlimitedListStack<Double> stack=new UnlimitedListStack<>();
        Scanner s=new Scanner (System.in);
        String[] formula;
        Double tempA, tempB;
        System.out.println("Podaj wyrażenie w Odwróconej Notacji Polskiej ze spacjami.");
        formula=s.nextLine().split(" ");
        for (String aFormula : formula) {
            if (Character.isDigit(aFormula.charAt(0))) {
                stack.push(new Double(aFormula));
            } else {
                switch (aFormula.charAt(0)) {
                    case '+':
                        try {
                            tempA = stack.pop();
                            tempB = stack.pop();
                            stack.push(tempB + tempA);
                            System.out.println(tempB + " + " + tempA + " = " + (tempB + tempA));
                        } catch (EmptyStackException e) {
                            System.out.println("Niepoprawne wyrażenie ONP.");
                        }

                        break;
                    case '-':
                        try {
                            tempA = stack.pop();
                            tempB = stack.pop();
                            stack.push(tempB - tempA);
                            System.out.println(tempB + " - " + tempA + " = " + (tempB - tempA));
                        } catch (EmptyStackException e) {
                            System.out.println("Niepoprawne wyrażenie ONP.");
                        }

                        break;
                    case '*':
                        try {
                            tempA = stack.pop();
                            tempB = stack.pop();
                            stack.push(tempB * tempA);
                            System.out.println(tempB + " * " + tempA + " = " + (tempB * tempA));
                        } catch (EmptyStackException e) {
                            System.out.println("Niepoprawne wyrażenie ONP.");
                        }

                        break;
                    case '/':
                        try {
                            tempA = stack.pop();
                            tempB = stack.pop();
                            stack.push(tempB / tempA);
                            System.out.println(tempB + " / " + tempA + " = " + (tempB / tempA));
                        } catch (EmptyStackException e) {
                            System.out.println("Niepoprawne wyrażenie ONP.");
                        }

                        break;
                }
            }
        }
        System.out.println(stack.pop());
    }
}
