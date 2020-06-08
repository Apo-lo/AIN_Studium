class Kartonabtransportprozess extends Thread {
   private Signale signale;
   
   public Kartonabtransportprozess(Signale signale) {
      this.signale = signale;
   }

   private void fahreKartonWeg() throws InterruptedException {
      sleep(1000);
   }

   private void fahreKartonVonAblageposWeg() throws InterruptedException {
      signale.warteProduktAbgelegt();
      System.out.println("-3- Karton wird weggefahren");
      fahreKartonWeg();
      signale.setProduktAbgelegt(false);
      signale.setAblageposFrei(true);
   }

   public void run() {
      while (true) {
         try {
            fahreKartonVonAblageposWeg();
         } catch (InterruptedException e) {
            System.out.println("Unzulaessige Unterbrechung");
            System.exit(0);
         }
      }
   }
}