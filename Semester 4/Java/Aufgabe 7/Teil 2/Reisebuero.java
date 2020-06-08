class Reisebuero extends Thread {
    private final String name;
    private final TicketAnbieter ticketAnbieter;

    Reisebuero(String name, TicketAnbieter ticketAnbieter) {
        this.name = name;
        this.ticketAnbieter = ticketAnbieter;
    }

    private void warteAufKunde() {
        try {
            Thread.sleep(Math.round(1000 * Math.random()));
        } catch (InterruptedException e) {
            System.out.println("Unzulaessige Unterbrechung");
            System.exit(0);
        }
    }

    public void run() {
        warteAufKunde();
        while (ticketAnbieter.TicketsVerfuegbar()) {
            synchronized (ticketAnbieter) {
                if (ticketAnbieter.TicketsVerfuegbar()) {
                    int nr = ticketAnbieter.TicketVerkauf();
                    System.out.println(name + " verkauft Ticket " + nr);
                    warteAufKunde();
                }
            }
        }
    }
}
