package synchronize;

class Philosopher implements Runnable {
    final private Object leftFork;
    final private Object rightFork;

    Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();

                synchronized (leftFork) {
                    System.out.println(Thread.currentThread().getName() + ": Picked up left fork");
                    Thread.sleep((long) (Math.random() * 2000));          // Zeit verlängern für Verklemmung

                    synchronized (rightFork) {
                        System.out.println(Thread.currentThread().getName() + ": Picked up right fork");
                        eat();
                        System.out.println(Thread.currentThread().getName() + ": Put down right fork");
                    }
                    System.out.println(Thread.currentThread().getName() + ": Put down left fork");
                }
            }
        } catch (InterruptedException e) {
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

    private void pickUpLeftFork() throws InterruptedException {

    }
}
