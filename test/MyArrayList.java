/**
 * class MyArrayList<T>
 *
 * Class to create an ArrayList
 */
class MyArrayList<T>
{
    T arr[];
    private int size;
    private int totalElements;

    /**
     * Default constructor
     */
    public MyArrayList()
    {
        @SuppressWarnings("unchecked")
        T[] arr = (T[]) new Object[10];
        this.arr = arr;
        totalElements = 0;
        this.size = 10;
    }

    /**
     * Parameterized constructor
     */
    public MyArrayList(int s)
    {
        @SuppressWarnings("unchecked")
        T[] arr = (T[]) new Object[s];
        this.arr = arr;
        totalElements = 0;
        this.size = s;
    }

    /**
     * Adds an element in the array list
     *
     * @param T e element to be added
     * @param int pos Position at which element is to be added
     *
     * @throws InvalidPositionException If the position is invalid
     */
    public void add(T e, int pos) throws InvalidPositionException
    {
        if (pos >= size || pos < 0) {
            throw new InvalidPositionException();
        }

        arr[pos] = e;
        totalElements++;
    }

    /**
     * Get the
     */
    public T get(int pos) throws InvalidPositionException
    {
        if (pos >= size || pos < 0) {
            throw new InvalidPositionException();
        }

        return arr[pos];
    }

    /**
     * Checks if the array is empty
     *
     * @param boolean True if the array is empty else false
     */
    public boolean isEmpty()
    {
        if (totalElements == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Clears the array list
     */
    public void clear()
    {
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }

        totalElements = 0;
    }

    /**
     * Removes the element from the array list
     */
    public T remove(int pos) throws InvalidPositionException
    {
        if (pos >= size || pos < 0) {
            throw new InvalidPositionException();
        }

        T temp = arr[pos];
        arr[pos] = null;
        totalElements--;

        return temp;
    }

    /**
     * Checks if an element is present in the array list
     */
    public boolean contains(T obj)
    {
        for (int i = 0; i < size; i++) {

            if (arr[i] == null) {
                continue;
            } else {
                if (arr[i].equals(obj)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Get index of the element in the array list
     */
    public int indexOf(T obj)
    {
        if (obj == null) {
            for (int i = 0; i < size; i++) {
                if (arr[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (arr[i].equals(obj)) {
                    return i;
                }
            }
        }

        return -1;
    }

    /**
     * Get total number of elements in the array list
     */
    public int numOfElements()
    {
        return totalElements;
    }
}
