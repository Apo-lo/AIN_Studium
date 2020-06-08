class Verpackungsprozess {
   public static void main(String[] args) {
      Signale signale = new Signale();

      new Kartonzufuhrprozess(signale).start();
      new Produktablageprozess(signale).start();
      new Kartonabtransportprozess(signale).start();
   }
}