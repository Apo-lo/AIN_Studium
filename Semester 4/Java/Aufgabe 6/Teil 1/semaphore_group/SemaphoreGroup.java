package semaphore_group;

class SemaphoreGroup {
    private int[] values;

    SemaphoreGroup(int numberOfMembers) {
        if(numberOfMembers <= 0) {
            return;
        }
        values = new int[numberOfMembers];
    }

    int getNumberOfMembers() {
        return values.length;
    }

    synchronized void changeValues(int[] deltas) {
        if(deltas.length != values.length) {
            return;
        }

        while(!canChange(deltas)) {
            try {
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        doChange(deltas);
        System.out.println("Changed sem-values to: " + values[0] + " - " + values[1] + " - " + values[2] +
                " - " + values[3] + " - " + values[4]);
        notifyAll();
    }

    private Boolean canChange(int[] deltas) {
        for(int i = 0; i < values.length; i++) {
            if(values[i] + deltas[i] < 0) {
                return false;
            }
        }
        return true;
    }

    private void doChange(int[] deltas) {
        for(int i = 0; i < values.length; i++) {
            values[i] = values[i] + deltas[i];
        }
    }
}
