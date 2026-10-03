import java.time.LocalDate;


public class Contract implements Calculabil {
   private Client client;
   private Sofer sofer;
   private Ruta ruta;
   private double pretPeKm;
   private double costTotal;
   private LocalDate dataPlecare;
   private LocalDate dataSosire;


   public Contract(Client client, Sofer sofer, Ruta ruta, double pretPeKm, LocalDate dataPlecare, LocalDate dataSosire) {
       this.client = client;
       this.sofer = sofer;
       this.ruta = ruta;
       this.pretPeKm = pretPeKm;
       this.dataPlecare = dataPlecare;
       this.dataSosire = dataSosire;


    
       this.costTotal = calculeazaCost(ruta.getDistanta(), pretPeKm);


     
       sofer.calculeazaSalariu(ruta.getDistanta(), pretPeKm);
       client.adaugaCheltuiala(costTotal);
   }


   @Override
   public double calculeazaCost(double distanta, double pretPeKm) {
       return distanta * pretPeKm;
   }


   public Client getClient() { return client; }
   public Sofer getSofer() { return sofer; }


   public boolean isInPeriod(LocalDate start, LocalDate end) {
       return (dataPlecare.isAfter(start) || dataPlecare.isEqual(start)) &&
               (dataSosire.isBefore(end) || dataSosire.isEqual(end));
   }


   public void afisareDetalii() {
       System.out.println("Contract: Client " + client.getNume() + " → Șofer " + sofer.getNume() +
               ", Rută: " + ruta.getDenumire() + ", Plecare: " + dataPlecare + ", Sosire: " + dataSosire +
               ", Cost total: " + costTotal + " lei.");
   }
}


