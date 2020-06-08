class Produktablageprozess extends Thread {
   private Signale signale;
   
   public Produktablageprozess(Signale signale) {
      this.signale = signale;
   }

   private void legeProduktAb() throws InterruptedException {
      sleep(1000);
   }

   private void legeProduktAbFallsErlaubt() throws InterruptedException {
      signale.warteProduktablageErlaubt();
      System.out.println("-2- Produkt wird abgelegt");
      legeProduktAb();
      signale.setProduktablageErlaubt(false);
      signale.setProduktAbgelegt(true);
   }

   public void run() {
      while (true) {
         try {
            legeProduktAbFallsErlaubt();
         } catch (InterruptedException e) {
            System.out.println("Unzulaessige Unterbrechung");
            System.exit(0);
         }
      }
   }
}