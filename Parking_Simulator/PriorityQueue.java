
class PriorityQueue {
    private Car[] queueArray;
    private int maxSize;
    private int nItems;

    public PriorityQueue(int size) {
        maxSize = size;
        queueArray = new Car[maxSize];
        nItems = 0;
    }

    public void insert(Car m) {
        if (nItems == maxSize) {
            System.out.println("Queue is full");
            return;
        }

        int j;
        for (j = nItems - 1; j >= 0; j--) {
            if (m.proccestime > queueArray[j].proccestime) {
                queueArray[j + 1] = queueArray[j];
            } else {
                break;
            }
        }
        queueArray[j + 1] = m;
        nItems++;
    }

    public Car remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        Car temp = queueArray[--nItems];
        return temp;
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }
}