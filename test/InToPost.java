import java.util.*;

/**
 * class InToPost
 *
 * Class to convert infix to postfix and evaluate it
 */
class InToPost
{
    /**
     * Converts an infix expression to postfix expression
     *
     * @param String infix expression
     * @return String postfix expression
     */
    static String convert(String infix)
    {
        String postfix = "";
        char c, temp;

        try {
            CharStack s = new CharStack(50);

            for (int i = 0; i < infix.length(); i++) {
                c = infix.charAt(i);

                if (isInt(c)) {
                    postfix += c;

                } else if (c == '(') {
                    try {
                        s.push(c);
                    } catch (StackFullException e) {
                            System.out.println(e);
                    }
                } else if (isOperator(c)) {
                    if (s.isEmpty()) {
                        try {
                            s.push(c);
                        } catch (StackFullException e) {
                            System.out.println(e);
                        }
                    } else {
                        try {
                            while (priority(s.top()) >= priority(c)) {
                                    postfix += s.pop();
                                    if (s.isEmpty()) {
                                        break;
                                }
                            }
                            s.push(c);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }

                } else if (c == ')') {
                    try {
                        while ((temp = s.pop()) != '(') {
                            postfix += temp;
                        }
                    } catch (StackEmptyException e) {
                        System.out.println(e);
                    }
                }
            }

            while (!s.isEmpty()) {
                try {
                    postfix += s.pop();
                } catch (StackEmptyException e) {
                    System.out.println(e);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return postfix;
    }

    /**
     * Evaluates a valid postfix expression
     *
     * @param String postfix expression
     * @return int value of the expression
     */
    public static int evalPost(String postfix)
    {
        CharStack s = new CharStack();
        char temp, res;
        int number1, number2, result = 0;

        for (int i = 0; i < postfix.length(); i ++) {
            temp = postfix.charAt(i);
            if (isInt(temp)) {
                try {
                    s.push(temp);
                } catch (StackFullException e) {
                    System.out.println(e);
                }

            } else if (isOperator(temp)) {
                try {
                    number1 = s.pop() - '0';
                    number2 = s.pop() - '0';

                    switch (temp) {
                        case '+':
                            result = number2 + number1;
                            break;

                        case '-':
                            result = number2 - number1;
                            break;

                        case '*':
                            result = number2 * number1;
                            break;

                        case '/':
                            result = number2 / number1;
                            // Possible ArithmeticException
                            break;
                    }

                    res = (char)(result+48);
                    s.push(res);

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }

        try {
            result = s.pop() - '0';
        } catch (StackEmptyException e) {
            System.out.println(e);
        }

        return (int)result;
    }

    /**
     * Checks if a character is an operator (+,-,*,/)
     *
     * @param char c Character to check
     * @return boolean true or false
     */
    private static boolean isOperator(char c)
    {
        if (c == '+' || c == '-' || c == '*' || c == '/') {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if a character is an integer between 0 to 9
     *
     * @param char c Character to check
     * @return boolean true or false
     */
    private static boolean isInt(char c)
    {
        int ascii = c - 48;

        if (ascii >= 0 && ascii <= 9) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get the priority of the operator
     *
     * @param char c Character to get the priority
     * @return int priority value
     */
    private static int priority(char c)
    {
        int ans = 0;
        if (c == '*' || c == '/') {
            ans = 2;
        } else if (c == '+' || c == '-') {
            ans = 1;
        }

        return ans;
    }

    /**
     * Checks if the infix expression is valid
     *
     * @param String infix expression
     * @return boolean true if valid else false
     */
    private static boolean isValidInfix(String infix)
    {
        int rank = 0, paran = 0;
        char temp;

        for (int i = 0; i < infix.length() ; i++) {
            temp = infix.charAt(i);
            if (isInt(temp)) {
                rank++;
            } else if (isOperator(temp)) {
                rank--;
            } else if (temp == '(') {
                paran++;
            } else if (temp == ')') {
                paran--;
            }

            if (rank !=0 && rank != 1) {
                break;
            }
            if (paran < 0) {
                break;
            }
        }

        if (rank != 1 || paran != 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args)
    {
        int ans;
        String infix, postfix;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the infix expression: ");
        infix = sc.next();  // Get the infix expression

        try {
            if (!isValidInfix(infix)) {
                throw new InvalidInfixException();
            }
            postfix = convert(infix);
            System.out.println("The postfix expression is : " + postfix);

            ans = evalPost(postfix);
            System.out.println("Result is : " + ans);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
