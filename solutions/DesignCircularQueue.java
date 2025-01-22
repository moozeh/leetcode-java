class MyCircularQueue {
    int[] q;
    int front;
    int rear;

    public MyCircularQueue(int k) {
        q = new int[k + 1];
        front = 1;
        rear = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        q[front] = value;
        front = (front + 1) % q.length;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        rear = (rear + 1) % q.length;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return q[(rear + 1) % q.length];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        return q[(front - 1 + q.length) % q.length];
    }
    
    public boolean isEmpty() {
        return (rear + 1)%q.length == front;
    }
    
    public boolean isFull() {
        return rear == front;
    }
}