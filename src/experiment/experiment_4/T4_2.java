package experiment.experiment_4;

import java.util.LinkedList;
import java.util.Queue;

public class T4_2 {
    public static void main(String[] args) {
        LetterStore store = new LetterStore();
        Producer sum = new Producer(store);
        Customer print = new Customer(store);
        sum.start();
        print.start();
    }
}

class Producer extends Thread {
    private final LetterStore store;

    Producer(LetterStore store) {
        this.store = store;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0;i<30;i++){
            store.write((char) (Math.random()*25+97));
            try {
                Thread.sleep((long) (Math.random()*200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Customer extends Thread {
    private final LetterStore store;

    Customer(LetterStore store) {
        this.store = store;
    }

    @Override
    public void run() {
        super.run();
        while (true){
            try {
                Thread.sleep((long) (Math.random()*2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(store.read());
        }
    }
}

class LetterStore extends Thread {
    private final Queue<Character> queue = new LinkedList<>();

    public synchronized void write(char i) {
        queue.add(i);
        this.notify();
    }

    public synchronized char read() {
        while (queue.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.poll();
    }
}
