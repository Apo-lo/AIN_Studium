package semaphore_group;

class Philosopher implements Runnable {
    final private int number;
    final private Table table;

    Philosopher(int number, Table table) {
        this.number = number;
        this.table = table;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                table.pickUpForks(number);
                eat();
                table.putDownForks(number);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    private void think() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + ": Thinking...");
        Thread.sleep((long)(Math.random() * 1000));
    }

    private void eat() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + ": Eating...");
        Thread.sleep((long)(Math.random() * 1000));
    }
}
