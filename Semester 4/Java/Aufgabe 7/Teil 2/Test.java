class Test {
    public static void main(String[] args) {
        TicketAnbieter ticketAnbieter = new TicketAnbieter(4);
        new Reisebuero("Reiseland", ticketAnbieter).start();
        new Reisebuero("Happy Travels", ticketAnbieter).start();
    }
}


