import java.util.*;

/**
 * Binary class
 */
class Binary
{
    /**
     * Function to convert a decimal number to binary
     *
     * @param int Decimal number to be converted
     * @return int Binary equivalent of the number
     */
    public static int toBinary(int num)
    {
        int mask = 1, answer = 0, i = 0;

        while (num > 0) {
            answer = (answer + ((num & mask) * (int)Math.pow(10, i)));
            num = num >>> 1;
            i++;    // Increment the counter
        }

        return answer;
    }

    /**
     * main() function
     */
    public static void main(String[] args)
    {
        int number;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number :");
        number = sc.nextInt();

        System.out.println("The result is " + toBinary(number));
    }
}
