
class Queue {
    private QueueNode[] queueArray;
    private int maxSize;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int size) {
        maxSize = size;
        queueArray = new QueueNode[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(QueueNode m) {
        if (rear == maxSize - 1) {
            System.out.println("Queue is full");
            return;
        }
        queueArray[++rear] = m;
        nItems++;
    }

    public QueueNode remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        QueueNode temp = queueArray[front++];
        nItems--;
        return temp;
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }
}