import java.util.*;
import java.util.Arrays;
import java.util.List;

/**
 * Fibonacci series
 */
class Fibonacci
{
    static int arr[] = new int[1000];

    /**
     * Function to find nth term of fibonacci
     */
    public static int findNth(int n)
    {
        /**
         * Base conditions
         */
        if (n == 1 || n == 2) {
            return n-1;
        }

        if (arr[n] != 0) {
            return arr[n];
        }

        arr[n] = (findNth(n-1) + findNth(n-2));
        return arr[n];
    }

    public static void main(String[] args)
    {
        int number;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the nth term :");
        number = sc.nextInt();

        System.out.println("Nth term is " + findNth(number));
    }
}
