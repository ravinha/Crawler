package Frazeusz;

public class Counter {

    private int counter;

    Counter(){this.counter = 0;}

    public synchronized int getCounter() {
        return counter;
    }

    synchronized void increase(){ this.counter++; }

}
