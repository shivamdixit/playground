class MyNode<T>
{
    private T data;
    private MyNode<T> next;
    private MyNode<T> prev;

    public MyNode(T element, MyNode<T> n, MyNode<T> p)
    {
        this.data = element;
        this.next = n;
        this.prev = p;
    }

    public T getData()
    {
        return data;
    }

    public MyNode<T> getNext()
    {
        return next;
    }

    public MyNode<T> getPrevious()
    {
        return prev;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public void setNext(MyNode<T> n)
    {
        this.next = n;
    }

    public void setPrevious(MyNode<T> p)
    {
        this.prev = p;
    }
}
