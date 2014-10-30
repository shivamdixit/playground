class IntStack
{
    private int arr[];
    private int top;

    /**
     * Size of stack
     */
    private int size = 10;

    /**
     * Default constructor
     */
    public IntStack()
    {
        arr = new int[size];
        top = -1;
    }

    /**
     * Overloaded Constructor
     */
    public IntStack(int s)
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
    public void push(int num) throws StackFullException
    {
        if (this.isFull()) {
            throw new StackFullException();
        }

        this.top++;
        arr[this.top] = num;
    }

    /**
     * Pop element from stack
     */
    public int pop() throws StackEmptyException
    {
        if (this.isEmpty()) {
            throw new StackEmptyException();
        }

        return arr[this.top--];
    }

    /**
     * Returns the top element without removal
     */
    public int top() throws StackEmptyException
    {
        if (this.isEmpty()) {
            throw new StackEmptyException();
        }

        return arr[this.top];
    }
}
