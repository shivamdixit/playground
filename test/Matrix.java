import java.util.*;

/**
 * Matrix class
 */
class Matrix
{
    /**
     * Function to print the given series in matrix
     *
     * @param int Dimensionsf the matrix
     * @return void
     */
    public static void printSeries(int dimensions)
    {
        int matrix[][], i, j, k, count;
        matrix =  new int[dimensions][dimensions];

        /**
         * Store the result
         */
        for (i = 0; i < dimensions; i++){
            count = 0;
            for (k = 0; k < i; k++) {
                matrix[i][k] = 0;
            }

            for (j = 0; k < dimensions; j++) {
                matrix[i][k] = (int)Math.pow(2, j);
                k++;
            }
        }

        /**
         * Print the matrix
         */
        for (i = 0; i < dimensions; i++) {
            for (j = 0; j < dimensions; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println("");
        }
    }

    /**
     * main() method of class
     */
    public static void main(String[] args)
    {
        int number;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter dimensions of matrix :");
        number = sc.nextInt();

        printSeries(number);
    }
}
