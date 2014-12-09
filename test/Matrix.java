import java.util.*;

/**
 * class InvalidDimensionException
 *
 * Thrown when matrix objects are not of compatible dimensions
 */
class InvalidDimensionException extends Exception
{
    public String toString()
    {
        return "Matrix are not compatible!";
    }
}

/**
 * class MultiplyThread
 *
 * Creates multiple threads
 */
class MultiplyThread implements Runnable
{
    Matrix m1, m2;
    int i, j;
    int[][] result;
    Thread t;

    /**
     * Constructor
     */
    public MultiplyThread(Matrix one, Matrix two, int[][] res, int i, int j)
    {
        m1 = one;
        m2 = two;
        this.i = i;
        this.j = j;
        this.result = res;

        t = new Thread(this);   // Create a new thread
        t.start();              // Register the new thread
    }

    /**
     * Implement the run method of runnable interface
     */
    public void run()
    {
        int sum, k;
        for (k = 0, sum = 0; k < m1.getCols(); k++) {
            sum += (m1.getElement(i, k) * m2.getElement(k, j));
        }

        result[i][j] = sum;
    }
}

/**
 * class Matrix
 *
 * To store a matrix
 */
class Matrix
{
    /**
     * The number of rows in matrix
     */
    private final int numOfRows;

    /**
     * The number of columns in matrix
     */
    private final int numOfCols;

    /**
     * Elements of the matrix
     */
    private int[][] elements;

    /**
     * Constructor
     *
     * @param rows Number of rows
     * @param cols Number of columns
     */
    public Matrix(int rows, int cols)
    {
        this.numOfRows = rows;
        this.numOfCols = cols;
        elements = new int[rows][cols];
    }

    /**
     * Getter method
     *
     * @return int Number of rows
     */
    public int getRows()
    {
        return this.numOfRows;
    }

    /**
     * Getter method
     *
     * @return int Number of cols
     */
    public int getCols()
    {
        return this.numOfCols;
    }

    /**
     * Set the elements of the matrix
     *
     * @return Matrix object
     */
    public Matrix setElements(int[][] array)
    {
        for (int i = 0; i < this.numOfRows; i++) {
            for (int j = 0; j < this.numOfCols; j++) {
                elements[i][j] = array[i][j];
            }
        }

        return this;
    }

    /**
     * Get an element of the matrix
     *
     * @param row Row of the matrix
     * @param col Column of the matrix
     *
     * @return int Element
     */
    public int getElement(int row, int col)
    {
        return elements[row][col];
    }

    /**
     * Prints the matrix
     */
    public void print()
    {
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                System.out.print(elements[i][j] + " ");
            }

            System.out.println();
        }
    }

    /**
     * Adds two matrix
     *
     * @param m Matrix object to add
     * @throws InvalidDimensionException If matrix cannot be added
     *
     * @return Matrix Result object of addition
     */
    public Matrix add(Matrix m) throws InvalidDimensionException
    {
        if (this.numOfRows != m.getRows() || this.numOfCols != m.getCols()) {
            throw new InvalidDimensionException();
        }

        int[][] result = new int[this.numOfRows][this.numOfCols];
        for (int i = 0; i < this.numOfRows; i++) {
            for (int j = 0; j < this.numOfCols; j++) {
                result[i][j] = this.getElement(i, j) + m.getElement(i, j);
            }
        }

        return ((new Matrix(numOfRows, numOfCols)).setElements(result));
    }

    /**
     * Multiply two matrix
     *
     * @param m Matrix object to multiply
     * @throws InvalidDimensionException If matrix cannot be multiplied
     *
     * @return Matrix Result object of multiplication
     */
    public Matrix multiply(Matrix m) throws InvalidDimensionException
    {
        if (this.numOfCols != m.numOfRows) {
            throw new InvalidDimensionException();
        }

        int sum, k, count = 0;
        int[][] result = new int[this.numOfRows][m.getCols()];
        MultiplyThread[] threads = new MultiplyThread[numOfRows * m.getCols()];

        for (int i = 0; i < this.numOfRows; i++) {
            for (int j = 0; j < m.getCols(); j++) {
                // Create a new thread and store it in an array for join()
                threads[count++] = new MultiplyThread (this, m, result, i, j);
            }
        }

        // Wait for all threads to finish
        for (int i = 0; i < count; i++) {
            try {
                threads[i].t.join();
            } catch (InterruptedException exc) {
                System.out.println("Thread was interrupted");
            }
        }

        return ((new Matrix(this.numOfRows, m.getCols())).setElements(result));
    }
}

/**
 * Driver program
 *
 * Creates two matrix and multiply them
 */
class TestMatrix
{
    public static Matrix scanMatrix()
    {
        int numOfRows = 0, numOfCols = 0;
        int[][] array;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows and cols of matrix");

        try {
            numOfRows = sc.nextInt();
            numOfCols = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input!");
            System.exit(0);
        }

        Matrix m = new Matrix(numOfRows, numOfCols);
        array = new int[numOfRows][numOfCols];

        System.out.println("Enter elements of matrix");
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                try {
                    array[i][j] = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid input!");
                    System.exit(0);
                }
            }
        }

        m.setElements(array);
        return m;
    }

    public static void main(String[] args)
    {
        Matrix m1, m2, m3;
        m1 = scanMatrix();
        m2 = scanMatrix();

        try {
            m3 = m1.multiply(m2);
            m3.print();
        } catch (Exception e) {
            System.out.print(e);
        }

    }
}
