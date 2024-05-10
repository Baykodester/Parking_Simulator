import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int N = 10;
        Queue sequentialQueue = new Queue(N);
        PriorityQueue priorityQueue = new PriorityQueue(N);
        
        int totalProcessingTimeSequential = 0;
        int totalProcessingTimePriority = 0;
        int totalCompletionTimeSequential = 0;
        int totalCompletionTimePriority = 0;

        for (int i = 1; i <= N; i++) {
            int processingTimeSequential = rand.nextInt(291) + 10; // Random processing time for sequential queue.
            int processingTimePriority = rand.nextInt(291) + 10; // Random processing time for priority queue.

            Car carSequential = new Car(i, processingTimeSequential);
            QueueNode carNodeSequential = new QueueNode(carSequential, totalProcessingTimeSequential);
            sequentialQueue.insert(carNodeSequential);
            totalProcessingTimeSequential += processingTimeSequential;

            Car carPriority = new Car(i, processingTimePriority);
            priorityQueue.insert(carPriority);
            totalProcessingTimePriority += processingTimePriority;
        }
        
        ////////////////

        System.out.println("FIFO(Sequential) Queue Implementation:");
        System.out.println("Car Number | Processing Time");

        while (!sequentialQueue.isEmpty()) {
            QueueNode carNode = sequentialQueue.remove();
            totalCompletionTimeSequential += carNode.car.proccestime;
            System.out.println(carNode.car.id + "          | " + carNode.car.proccestime);
        }

        System.out.println("Average Processing Time per Car (Sequential Queue): " +((double) totalCompletionTimeSequential / N) + " seconds");

        ////////////////
        
        System.out.println("\nPriority Queue Implementation:");
        System.out.println("Car Number | Processing Time");

        while (!priorityQueue.isEmpty()) {
            Car car = priorityQueue.remove();
            totalCompletionTimePriority += car.proccestime;
            System.out.println(car.id + "          | " + car.proccestime);
        }

        System.out.println("Average Processing Time per Car (Priority Queue): "+ ((double) totalCompletionTimePriority / N) + " seconds");
        
        ////////////////

        double Gain =((double)totalProcessingTimeSequential - totalProcessingTimePriority)/(totalProcessingTimeSequential + totalProcessingTimePriority)*100;

        System.out.println("\nDifference in Average Processing Time: " + Gain + "%");
    }
}