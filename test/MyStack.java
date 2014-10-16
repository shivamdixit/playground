import java.util.*;

/**
 * class MyStack
 *
 * Implementation of stack
 */
class MyStack
{
    /**
     * Instance variables
     */
    private int[] arr;  // Store the stack
    private int top;    // Store the top index

    /**
     * Size of stack
     */
    private int size = 10;

    /**
     * Default constructor
     */
    public MyStack()
    {
        arr = new int[size];
        top = -1;
    }

    /**
     * Overloaded Constructor
     */
    public MyStack(int s)
    {
        arr = new int[s];
        top = -1;
        this.size = s;
    }

    /**
     * Check if stack is full
     */
    public boolean isFull()
    {
        if (this.top == size-1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check if stack is empty
     */
    public boolean isEmpty()
    {
        if (this.top == -1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Push element into stack
     */
    public void push(int num)
    {
        this.top++;
        arr[this.top] = num;
    }

    /**
     * Pop element from stack
     */
    public int pop()
    {
        return arr[this.top--];
    }
}
