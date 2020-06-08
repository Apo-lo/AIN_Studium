class Kartonzufuhrprozess extends Thread {
   private Signale signale;
   
   public Kartonzufuhrprozess(Signale signale) {
      this.signale = signale;
   }

   private void fahreKartonVor() throws InterruptedException {
      sleep(1000); // Verfahrzeit bis zur Ablageposition
   }

   private void fahreKartonZurAblageposition() throws InterruptedException {
      signale.warteAblageposFrei();
      System.out.println("-1- Karton wird vorgefahren");
      fahreKartonVor();
      signale.setAblageposFrei(false);
      signale.setProduktablageErlaubt(true);
   }

   public void run() {
      while(true) {
         try {
            fahreKartonZurAblageposition();
         } catch (InterruptedException e) {
            System.out.println("Unzulaessige Unterbrechung");
            System.exit(0);
         }
      }
   }
}