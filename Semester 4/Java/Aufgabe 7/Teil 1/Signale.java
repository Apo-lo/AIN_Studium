class Signale {
   private boolean ablageposFrei = true;
   private boolean produktablageErlaubt = false;
   private boolean produktAbgelegt = false;

   // Darauf warten, dass Signa1 auf ,true, gesetzt wird
   synchronized void warteAblageposFrei() throws InterruptedException {
      while(!ablageposFrei)
         wait();
   }

   synchronized void warteProduktablageErlaubt() throws InterruptedException {
      while(!produktablageErlaubt)
         wait();
   }

   synchronized void warteProduktAbgelegt() throws InterruptedException {
      while(!produktAbgelegt)
         wait();
   }

   // Signalzustand auf ,value, setzen
   synchronized void setAblageposFrei (boolean value) {
      ablageposFrei = value;
      if(value)
         notify();
   }

   // Signalzustand auf ,value, setzen
   synchronized void setProduktablageErlaubt(boolean value) {
      produktablageErlaubt = value;
      if(value)
         notify();
   }
  
   // Signalzustand auf ,value, setzen
   synchronized void setProduktAbgelegt (boolean value) {
      produktAbgelegt = value;
      if(value)
         notify();
   }
}