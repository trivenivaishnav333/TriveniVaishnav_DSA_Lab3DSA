package Balancing_Brackets;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancingBrackets {

    public static boolean areBracketsBalanced(String expr) {

        //Initialize Stack
        Deque<Character> stack = new ArrayDeque<Character>();

        //Traverse across each character in the bracket expression
        for (int i = 0; i < expr.length(); i++)
        {
            //Fetch each character
            char x = expr.charAt(i);

            //check if character is open bracket
            if (x == '(' || x == '[' || x == '{')
            {
                stack.push(x);
                continue;
            }

            if (stack.isEmpty())
                return false;

            char check = stack.pop();
            switch (x)
            {
                case ')':
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }

        return (stack.isEmpty());
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String expr = scan.next();

        if (BalancingBrackets.areBracketsBalanced(expr))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
    }
}