package experiment.experiment_4;

import java.util.LinkedList;
import java.util.Queue;

public class T4_1 {
    public static void main(String[] args) {
        Store store = new Store();
        Sum sum = new Sum(store);
        Print print = new Print(store);
        sum.start();
        print.start();
    }
}

class Sum extends Thread {
    private final Store store;

    Sum(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0;i<100;i++){
            store.write(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Print extends Thread {
    private final Store store;

    Print(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        super.run();
        while (true){
            System.out.println(store.read());
        }
    }
}

class Store extends Thread {
    private final Queue<Integer> queue = new LinkedList<>();

    public synchronized void write(int i) {
        queue.add(i);
        this.notify();
    }

    public synchronized int read() {
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
