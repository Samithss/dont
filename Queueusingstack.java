package org.example;



class Queue {
    private int[] stack1;
    private int[] stack2;
    private int stack1Top;
    private int stack2Top;

    public Queue(int capacity) {
        stack1 = new int[5];
        stack2 = new int[5];
        stack1Top = -1;
        stack2Top = -1;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Stack overflow");
            return;
        }

        stack1[++stack1Top] = item;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        }

        if (stack2Top == -1) {
            while (stack1Top >= 0) {
                stack2[++stack2Top] = stack1[stack1Top--];
            }
        }

        return stack2[stack2Top--];
    }

    public boolean isEmpty() {
        return stack1Top == -1 && stack2Top == -1;
    }

    public boolean isFull() {
        return stack1Top == stack1.length - 1 || stack2Top == stack1.length - 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Queue elements:");

        for (int i = stack2Top; i >= 0; i--) {
            System.out.println(stack2[i]);
        }

        for (int i = 0; i <= stack1Top; i++) {
            System.out.println(stack1[i]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.display();
        queue.enqueue(60);

        System.out.println("Dequeued item: " + queue.dequeue());
        System.out.println("Dequeued item: " + queue.dequeue());
        queue.display();
        System.out.println("Dequeued item: " + queue.dequeue());
        System.out.println("Dequeued item: " + queue.dequeue());
        System.out.println("Dequeued item: " + queue.dequeue());
        queue.display();
     queue.dequeue();
        queue.display();



    }
}
