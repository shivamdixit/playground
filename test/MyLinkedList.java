/**
 * class MyLinkedList<T>
 *
 * Class to create a linked list of a generic type
 */
class MyLinkedList<T>
{
    /**
     * Header of the linked list
     */
    private MyNode<T> head;

    /**
     * Number of elements in the linked list
     */
    private int size;

    /**
     * Default constructor
     */
    public MyLinkedList()
    {
        head = new MyNode<T>(null, null, null);
        size = 0;
    }

    /**
     * Insert element at the start in  the LL
     *
     * @param T element Element to be inserted
     */
    public void insertStart(T element)
    {
        MyNode<T> node = new MyNode<T>(element, null, null);
        MyNode<T> temp = head;

        head.setNext(node);

        if (size != 0) {
            node.setNext(temp.getNext());
        }

        node.setPrevious(head);
        size++;
    }

    /**
     * Insert element at the end in the LL
     *
     * @param T element Element to be inserted
     */
    public void insertEnd(T element)
    {
        MyNode<T> node = new MyNode<T>(element, null, null);
        MyNode<T> temp = head;

        if (size == 0) {
            head.setNext(node);
            node.setPrevious(head);
        } else {
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }

            temp.setNext(node);
            node.setPrevious(temp);
        }

        size++;
    }

    /**
     * Insert element at the arbitrary position in the LL
     *
     * @param T element Element to be inserted
     * @param int pos Position at which element has to be inserted
     *
     * @throws InvalidPositionException If position is not valid
     */
    public void insert(T element, int pos) throws InvalidPositionException
    {
        if (pos > (size+1) || pos <= 0) {
            throw new InvalidPositionException();
        }

        MyNode<T> node = new MyNode<T>(element, null, null);
        MyNode<T> temp = head;
        int count = 0;

        if (pos == 1) {
            this.insertStart(element);
        } else if (pos == (size+1)) {
            this.insertEnd(element);
        } else {
            while (count <= pos -1) {
                temp = temp.getNext();
                count++;
            }

            node.setNext(temp.getNext());
            temp.setNext(node);
            node.setPrevious(temp);

            temp = node.getNext();
            temp.setPrevious(node);
        }

        size++;
    }

    /**
     * Checks if an element is present in the LL
     *
     * @param T element Element to search in the LL
     * @return boolean True if element is found else false
     */
    public boolean contains(T element)
    {
        MyNode<T> temp = head.getNext();    // Initialize it with first node
        T data;

        if (size == 0) {
            return false;
        } else {
            while (temp != null) {
                data = temp.getData();
                if (data.equals(element)) {
                    return true;
                }

                temp = temp.getNext();
            }
        }

        return false;
    }

    /**
     * Get an element from the LL
     *
     * @param int pos Position of which you want to get the value
     * @return T Object at position pos
     *
     * @throws InvalidPositionException if position if out of bound
     */
    public T get(int pos) throws InvalidPositionException
    {
        if (pos >= (size) || pos <= 0) {
            throw new InvalidPositionException();
        }

        MyNode<T> temp = head;
        int count = 0;

        while (count < pos) {
            temp = temp.getNext();
            count++;
        }

        return temp.getData();
    }

    /**
     * Remove all the element of the LL
     */
    public void clear()
    {
        head.setNext(null);
        size = 0;
    }

    /**
     * Get total number of elements in the LL
     */
    public int numOfElements()
    {
        return size;
    }
}
