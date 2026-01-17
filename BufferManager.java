import java.util.LinkedList;
import java.util.Queue;

public class BufferManager {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(5); // Buffer capacity = 5 (like a FIFO depth)

        // The 'Producer' mimics an Input Data Stream
        Thread producer = new Thread(() -> {
            int value = 0;
            while (true) {
                try {
                    buffer.push(value++);
                    Thread.sleep(500); // Wait 500ms between inputs
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        });

        // The 'Consumer' mimics the Processing Unit
        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    buffer.pop();
                    Thread.sleep(1000); // Consumer is slower, mimicking processing delay
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        });

        producer.start();
        consumer.start();
    }
}

class SharedBuffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    public SharedBuffer(int capacity) { this.capacity = capacity; }

    // This is like the 'Write' operation in a FIFO
    public synchronized void push(int value) throws InterruptedException {
        while (queue.size() == capacity) {
            System.out.println("Buffer Full (FIFO Full flag). Producer is waiting...");
            wait(); // Wait until there is space
        }
        queue.add(value);
        System.out.println("Produced: " + value);
        notifyAll(); // Signal the Consumer that data is available
    }

    // This is like the 'Read' operation in a FIFO
    public synchronized int pop() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Buffer Empty (FIFO Empty flag). Consumer is waiting...");
            wait(); // Wait until there is data
        }
        int value = queue.poll();
        System.out.println("Consumed: " + value);
        notifyAll(); // Signal the Producer that space is now available
        return value;
    }
}