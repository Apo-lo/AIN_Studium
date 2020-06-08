package semaphore_group;

class Table extends SemaphoreGroup {
    Table(int numberOfMembers) {
        super(numberOfMembers);

        int[] deltas = new int[this.getNumberOfMembers()];
        this.setDeltas(deltas, 1);
        this.changeValues(deltas);      // set values to 1
    }

    void pickUpForks(int number) throws InterruptedException {
        int[] deltas = new int[this.getNumberOfMembers()];
        this.setDeltas(deltas, 0);
        deltas[number] = -1;                                    // left Fork
        deltas[(number + 1) % this.getNumberOfMembers()] = -1;  // right Fork

        this.changeValues(deltas);

        System.out.println(Thread.currentThread().getName() + ": Picked up both forks");
        Thread.sleep((long)(Math.random() * 1000));
    }

    void putDownForks(int number) throws InterruptedException {
        int[] deltas = new int[this.getNumberOfMembers()];
        this.setDeltas(deltas, 0);
        deltas[number] = 1;                                     // left Fork
        deltas[(number + 1) % this.getNumberOfMembers()] = 1;   // right Fork

        this.changeValues(deltas);

        System.out.println(Thread.currentThread().getName() + ": Put down both forks");
        Thread.sleep((long)(Math.random() * 1000));
    }

    private void setDeltas(int[] deltas, int value) {
        for (int i = 0; i < deltas.length; i++) {
            deltas[i] = value;
        }
    }
}
