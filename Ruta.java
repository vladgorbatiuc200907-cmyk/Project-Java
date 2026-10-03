public class Ruta {
   private String denumire;
   private double distanta;


   public Ruta(String denumire, double distanta) {
       this.denumire = denumire;
       this.distanta = distanta;
   }
   public String getDenumire() { return denumire; }
   public void setDenumire(String denumire) { this.denumire = denumire; }


   public double getDistanta() { return distanta; }
   public void setDistanta(double distanta) { this.distanta = distanta; }


   @Override
   public String toString() {
       return "Ruta: " + denumire + ", Distanta: " + distanta + " km";
   }
}
