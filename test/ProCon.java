import java.util.*;

class Queue {

    public final int queueSize = 10;
    List<Integer> q = new ArrayList<Integer>();
    int numOfElements = 0;

    synchronized void consume() {
        while (isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Consumer was terminated.");
            }
        }

        System.out.println("Consuming: " + q.remove(0));
        numOfElements--;
        notify();
    }

    synchronized void produce(int e) {
        while (isFull()) {
            try {
                wait();
            } catch (InterruptedException exc) {
                System.out.println("Consumer was terminated.");
            }
        }

        System.out.println("Producing: " + q.add(e));
        numOfElements++;
        notify();
    }

    synchronized boolean isEmpty() {
        if (numOfElements == 0) {
            return true;
        } else {
            return false;
        }
    }

    synchronized boolean isFull() {
        if (numOfElements == queueSize) {
            return true;
        } else {
            return false;
        }
    }
}

class Producer implements Runnable {
    Queue q;
    Thread t;

    Producer(Queue q) {
        this.q = q;
        t = new Thread(this, "Producer");
        t.start();
    }

    public void run() {
        int i = 0;
        while (true) {
            q.produce(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Caught!");
            }
        }
    }
}

class Consumer implements Runnable {

    Queue q;
    Thread t;

    Consumer(Queue q) {
        this.q = q;
        t = new Thread(this, "Consumer");
        t.start();
    }

    public void run() {
        while (true) {
            q.consume();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Caught!");
            }
        }
    }
}

class MainClass {

    public static void main(String[] args) {
        Queue q = new Queue();
        Producer p = new Producer(q);
        Consumer c =  new Consumer(q);
    }
}
