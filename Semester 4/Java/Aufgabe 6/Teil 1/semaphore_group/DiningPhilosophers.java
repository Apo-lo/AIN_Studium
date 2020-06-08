package semaphore_group;

public class DiningPhilosophers {
    public static void main(String[] args) {
        final int NUMBER_OF_PILOSOPHERS = 5;

        Table table = new Table(NUMBER_OF_PILOSOPHERS);
        Philosopher[] philosophers = new Philosopher[NUMBER_OF_PILOSOPHERS];

        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i] = new Philosopher(i, table);

            Thread t = new Thread(philosophers[i], "Philosopher " + i);
            t.start();
        }
    }
}
