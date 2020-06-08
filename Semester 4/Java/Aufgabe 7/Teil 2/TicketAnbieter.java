class TicketAnbieter {
    private int VerfuegbareTickets;

    TicketAnbieter(int n) {
        VerfuegbareTickets = n;
    }

    synchronized boolean TicketsVerfuegbar() {
        return VerfuegbareTickets > 0;
    }

    synchronized int TicketVerkauf() {
        return VerfuegbareTickets --;
    }
}
