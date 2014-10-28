class CharStack
{
    private char arr[];
    private int top;

    /**
     * Size of stack
     */
    private int size = 10;

    /**
     * Default constructor
     */
    public CharStack()
    {
        arr = new char[size];
        top = -1;
    }

    /**
     * Overloaded Constructor
     */
    public CharStack(int s) throws Exception
    {
        if (s < 0) {
            throw new Exception("Size of stack cannot be negative!");
        }

        arr = new char[s];
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
    public void push(char num) throws StackFullException
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
    public char pop() throws StackEmptyException
    {
        if (this.isEmpty()) {
            throw new StackEmptyException();
        }

        return arr[this.top--];
    }

    /**
     * Returns the top element without removal
     */
    public char top() throws StackEmptyException
    {
        if (this.isEmpty()) {
            throw new StackEmptyException();
        }

        return arr[this.top];
    }
}
