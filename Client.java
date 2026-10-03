public class Client extends Persoana {
   private double sumaCheltuita;


   public Client(String nume, String adresa, String telefon) {
       super(nume, adresa, telefon);
       this.sumaCheltuita = 0.0;
   }


   
   public double getSumaCheltuita() { return sumaCheltuita; }
   public void setSumaCheltuita(double sumaCheltuita) { this.sumaCheltuita = sumaCheltuita; }


   public void adaugaCheltuiala(double suma) {
       this.sumaCheltuita += suma;
   }


   @Override
   public void afisareDetalii() {
       System.out.println("Client: " + nume + ", Adresa: " + adresa + ", Telefon: " + telefon + ", Suma cheltuită: " + sumaCheltuita + " lei");
   }
}
